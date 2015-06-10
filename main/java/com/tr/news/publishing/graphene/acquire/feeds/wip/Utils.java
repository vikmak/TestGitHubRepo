/**
 * Copyright 2014: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR. Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited
 */
package com.tr.news.publishing.graphene.acquire.feeds.wip;

import org.apache.commons.lang3.StringUtils;

import com.tr.news.publishing.graphene.acquire.DocumentParsingContext;
import com.tr.news.publishing.graphene.acquire.DocumentParsingException;
import com.tr.news.publishing.graphene.acquire.ParsingContextProcessor;
import com.tr.news.publishing.graphene.document.DocumentProcessingContext;

/**
 * Utilities class for wip feed handler.
 * 
 * @author c155270 - Neha Mukati
 * 
 */
public class Utils {

	public static final ParsingContextProcessor VOLUME_PROCESSOR = new ParsingContextProcessor() {
		@Override
		public void process(final DocumentParsingContext<?> parsingContext,
		        final DocumentProcessingContext processingContext)
		        throws DocumentParsingException {
			final String value = parsingContext.getSingleValue(Constants.PUB_VOLUME);
			if (StringUtils.isNotBlank(value)) {
				processingContext.addPubInfoVolume(value);
			}
		}
	};

	private Utils() {
	}
}
