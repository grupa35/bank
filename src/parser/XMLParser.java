package parser;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class XMLParser {
	public Document buildXMLFile(String xml) {
		try {
			return DocumentBuilderFactory
					.newInstance()
					.newDocumentBuilder()
					.parse(new InputSource(new StringReader(xml)));
		} 
		catch(Exception e) {
			return null;
		}
	}
}
