package com.andy.helloandroid;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLContentHandler extends DefaultHandler {
	/*
	 * <CD>
	 * <TITLE>Hide your heart</TITLE>
	 * <ARTIST>Bonnie Tyler</ARTIST>
	 * <COUNTRY>UK</COUNTRY>
	 * <COMPANY>CBS Records</COMPANY>
	 * <PRICE>9.90</PRICE>
	 * <YEAR>1988</YEAR>
	 * </CD>
	 */
	boolean flag = true;
	String tagName;
	String cdTitle, cdArtist, cdCountry, cdCompany, cdPrice, cdYear;

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("start process XML with SAX");
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("end process XML with SAX");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		tagName = localName;
		flag = true;
		// attributes contains all the attributes of one element
		if ("CD".equals(tagName)) {
			System.out.println("a new CD is processing now");
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		if ("CD".equals(localName)) {
			System.out.println("*************************");
			this.printout();
			System.out.println("*************************");
			System.out.println("a CD is processed");
		}
	}
	
	

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		/*
		 * <CD>
		 * <TITLE>Hide your heart</TITLE>
		 * <ARTIST>Bonnie Tyler</ARTIST>
		 * <COUNTRY>UK</COUNTRY>
		 * <COMPANY>CBS Records</COMPANY>
		 * <PRICE>9.90</PRICE>
		 * <YEAR>1988</YEAR>
		 * </CD>
		 */
		/*String temp = new String(ch, start, length);
		String temp2 = new String(ch, 0, ch.length);
		System.out.println(tagName + "|" + start + "|" + length + "|" + temp + "|" + temp2);
		System.out.println(temp.length() + ", " + temp2.length());*/
		if("TITLE".equals(tagName)&&flag){
			cdTitle = new String(ch, start, length);
		}
		if("ARTIST".equals(tagName)&&flag){
			cdArtist = new String(ch, start, length);
		}
		if("COUNTRY".equals(tagName)&&flag){
			cdCountry = new String(ch, start, length);
		}
		if("COMPANY".equals(tagName)&&flag){
			cdCompany = new String(ch, start, length);
		}
		if("PRICE".equals(tagName)&&flag){
			cdPrice = new String(ch, start, length);
		}
		if("YEAR".equals(tagName)&&flag){
			cdYear = new String(ch, start, length);
		}
		flag = false;
	}
	
	private void printout(){
		System.out.println("TITLE:" + cdTitle);
		System.out.println("ARTIST:" + cdArtist);
		System.out.println("COUNTRY:" + cdCountry);
		System.out.println("COMPANY:" + cdCompany);
		System.out.println("PRICE:" + cdPrice);
		System.out.println("YEAR:" + cdYear);
	}
}
