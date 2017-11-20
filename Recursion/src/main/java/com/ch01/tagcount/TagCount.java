/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch01.tagcount;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author prokopiukd
 */
public class TagCount {

    public Map<String, Integer> m(String data) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes());
        Map<String, Integer> openTagMap = new HashMap();
        Map<String, Integer> closeTagMap = new HashMap();
        parser.parse(in, new DefaultHandler() {

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (openTagMap.get(qName) == null) {
                    openTagMap.put(qName, 0);
                }
                openTagMap.put(qName, openTagMap.get(qName) + 1);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (closeTagMap.get("</>" + qName) == null) {
                    closeTagMap.put("</>" + qName, 0);
                }
                closeTagMap.put("</>" + qName, closeTagMap.get("</>" + qName) + 1);
            }

        });
        closeTagMap.putAll(openTagMap);
        return closeTagMap;
    }

    public static void main(String[] args) throws Exception {
        TagCount tagCount = new TagCount();
        String oldContent = "<html><body><br/></body></html>";
        Map<String, Integer> oldContentMap = tagCount.m(oldContent);
        String actualContent = "<html><body><br/><br/></body></html>";
        Map<String, Integer> actualContentMap = tagCount.m(actualContent);        
        System.out.println(oldContentMap.equals(actualContentMap));
    }

}
