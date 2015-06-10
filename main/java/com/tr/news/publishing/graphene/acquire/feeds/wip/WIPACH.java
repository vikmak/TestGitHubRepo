/*
 * Copyright 2013: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR. Disclosure, Use or Reproduction without the written authorization
 * of TRGR is prohibited
 */
package com.tr.news.publishing.graphene.acquire.feeds.wip;

import java.util.Calendar;
import java.util.Collection;

import com.tr.news.publishing.graphene.acquire.DocumentParsingContext;
import com.tr.news.publishing.graphene.acquire.DocumentParsingException;
import com.tr.news.publishing.graphene.acquire.MissingPubDateException;
import com.tr.news.publishing.graphene.acquire.feeds.util.field.FieldConstants;
import com.tr.news.publishing.graphene.acquire.feeds.util.flatfile.field.FieldFlatFileAcquireContentHandler;

/**
 * Acquire Version Handler for WIP.
 * 
 * @author С155270 - Neha Mukati
 */
public class WIPACH extends FieldFlatFileAcquireContentHandler {

	@Override
	protected String retrievePubDate(final DocumentParsingContext<String> parsingContext)
	        throws DocumentParsingException,
	        MissingPubDateException {
		String pubDate = "";
		final Collection<String> pubDates = parsingContext.getDocumentFields().get(FieldConstants.PUBDATE);
		if (pubDates.size() == 0) {
			//Driver Specific - If there is no date it takes it system date.
			pubDate = Constants.PUB_DATE_PARSER.format(Calendar.getInstance().getTime());
		} else if (pubDates.size() > 1) {
			throw new MissingPubDateException("Invalid Pub Date.  Multiple Values.");
		} else {
			//Input Date
			pubDate = pubDates.iterator().next();
		}
		return pubDate;
	}
}
