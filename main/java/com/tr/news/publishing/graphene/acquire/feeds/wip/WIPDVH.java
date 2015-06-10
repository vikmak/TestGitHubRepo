/**
 * 
 */
package com.tr.news.publishing.graphene.acquire.feeds.wip;

import org.apache.commons.lang.StringUtils;

import com.tr.news.publishing.graphene.acquire.BadStoryException;
import com.tr.news.publishing.graphene.acquire.DocumentParsingContext;
import com.tr.news.publishing.graphene.acquire.DocumentParsingException;
import com.tr.news.publishing.graphene.acquire.feeds.util.field.FieldConstants;
import com.tr.news.publishing.graphene.acquire.feeds.util.flatfile.field.FieldFlatFileDocumentVersionHandler;
import com.tr.news.publishing.graphene.acquire.utility.ContentSetBuilder;
import org.w3c.dom.Element;
import com.tr.news.publishing.graphene.document.DocumentProcessingContext;

/**
 * Document Version Handler for WIP
 * 
 * @author - c155270 - Neha Mukati
 */
public class WIPDVH extends FieldFlatFileDocumentVersionHandler {
	@Override
	protected void postProcess(final DocumentProcessingContext context,
	        final DocumentParsingContext<String> parsingContext,
	        final ContentSetBuilder cb) throws BadStoryException, DocumentParsingException {
		final String body = parsingContext.getSingleValue(FieldConstants.BODY);

		Element bodyPara = null;
		if (StringUtils.isNotBlank(body)) {
			final String[] lines = StringUtils.splitByWholeSeparator(body, "\r\r");
			for (final String line : lines) {
				if (StringUtils.isNotBlank(line)) {
					//Driver Specific - put a <BR> break on single \r
					final String[] breakLines = StringUtils.split(line, "\r");
					if (breakLines.length > 1) {
						bodyPara = cb.createTag_Paragraph();
						for (int i = 0; i < breakLines.length; i++) {
							if (StringUtils.isBlank(breakLines[i])) {
								continue;
							}
							bodyPara.appendChild(cb.createTextNode(StringUtils.trim(breakLines[i])));
							//Avoid break after last paragraph
							if (i < breakLines.length - 1) {
								bodyPara.appendChild(cb.createTag_Br());
							}
						}
						cb.appendToBody(bodyPara);
						bodyPara = null;
					} else {
						cb.appendToBody(cb.createTag_Paragraph(StringUtils.trim(line)));
					}
				}
			}
		}

	}
}
