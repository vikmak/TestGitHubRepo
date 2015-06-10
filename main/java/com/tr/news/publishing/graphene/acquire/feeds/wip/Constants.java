package com.tr.news.publishing.graphene.acquire.feeds.wip;

import java.util.regex.Pattern;

import com.tr.news.publishing.graphene.utility.DateParser;

/**
 * Constants for WIP feed
 * 
 * @author c155270 - Neha Mukati
 */
public class Constants {

/// Changes by Sheldon

	public static final DateParser PUB_DATE_PARSER = new DateParser("MMM dd, yyyy");

	public static final Pattern REGEX_HEADER_SPLIT = Pattern.compile("(>JN.*?)(?=>)", Pattern.DOTALL);

	public static final Pattern REGEX_CONTENT_SPLIT = Pattern.compile("(>TI.*?)(?=>(TI|EN))", Pattern.DOTALL);

	public static final Pattern REGEX_FOOTER_SPLIT = Pattern.compile(">EN.*", Pattern.DOTALL);

	public static final Pattern REGEX_HEADLINE = Pattern.compile(">TI(.*?)(?=>TX)", Pattern.DOTALL);

	public static final Pattern REGEX_BODY_TEXT = Pattern.compile(">TX(.*)", Pattern.DOTALL);

	public static final Pattern REGEX_PUBDATA = Pattern.compile(">JN(.*?)(?=>)", Pattern.DOTALL);

	public static final Pattern REGEX_EXTRACT_PUBKEY = Pattern.compile("^(.*?)(,|$)");
	public static final Pattern REGEX_EXTRACT_PUBDATE = Pattern.compile("([^,]+,\\s\\d{4})");
	public static final Pattern REGEX_PUB_VOLUME = Pattern.compile("Vol\\. (\\d+)");
	public static final Pattern REGEX_PUB_PAGE = Pattern.compile("No\\. (\\d+)");

	public static final String PUBDATA_STRING = "PubData";
	public static final String PUB_VOLUME = "PubVolume";

	public static final String[][] ENTITY_REPLACEMENTS = {
	        {
	                "''", "\""
	        }, {
	                "\u2014", "-"
	        }, {
	                "\u2026", "..."
	        }
	};

	private Constants() {

	}
}