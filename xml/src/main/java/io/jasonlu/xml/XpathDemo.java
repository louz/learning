package io.jasonlu.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by louz on 2016/12/28.
 */
public class XpathDemo {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        String xml = "<?xml version=\"1.0\" ?><a><b>text</b></a>";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();

        System.out.println("/a = " + xpath.evaluate("/a", doc));
        System.out.println("/a/b = " + xpath.evaluate("/a/b", doc));
        Node nodeA = (Node)xpath.evaluate("/a", doc, XPathConstants.NODE);
        System.out.printf("nodeA's name = %s, value = %s%n", nodeA.getNodeName(), nodeA.getNodeValue());
        System.out.printf("nodeA's /b = %s", xpath.evaluate("//b", nodeA));
    }
}
