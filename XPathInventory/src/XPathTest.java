import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPathTest {

	public static void main(String[] args) {

		// get the factory
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		docBuilderFactory.setNamespaceAware(true);

		Document doc = null;

		try {
			// using factory to get an instance of DocumentBuilder
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

			// using builder to get DOM representation of XML file
			doc = docBuilder.parse("inventories.xml");
		} catch (ParserConfigurationException pcEx) {
			System.out.println("Грешка при конфигуриране...");
			pcEx.getStackTrace();
		} catch (IOException ioxEx) {
			System.out.println("Грешка при намирането на файла...");
			ioxEx.printStackTrace();
		} catch (SAXException saxEx) {
			saxEx.printStackTrace();
		} catch (ClassCastException ccEx) {
			System.out.println("Грешка при парсване...");
			ccEx.printStackTrace();
		}

		XPathFactory xPathFactory = XPathFactory.newInstance();
		XPath xPath = xPathFactory.newXPath();

		// System.out.println("Get book titles written after 2001: ");
		// String expression = "//book[@year>2001]//title//text()";
		//

		// try {
		// xPathExpression = xPath.compile(expression);
		// } catch (XPathExpressionException xPathEx) {
		// xPathEx.printStackTrace();
		// }
		//
		// Object result = null;
		// try {
		// result = xPathExpression.evaluate(doc, XPathConstants.NODESET);
		// } catch (XPathExpressionException xPathEx) {
		// xPathEx.printStackTrace();
		// }
		//
		// NodeList nodes = (NodeList) result;
		//
		// for (int i = 0; i < nodes.getLength(); i++) {
		// System.out.println(nodes.item(i).getNodeValue());
		// }

		System.out.println("------------------------------");
		System.out.println("Get book titles with writer name containing Niven ");

		XPathExpression xPathExpression = null;

		String expression2 = "//book[contains(author,'Niven')]";
		try {
			xPathExpression = xPath.compile(expression2);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		Object result2 = null;
		try {
			result2 = xPathExpression.evaluate(doc, XPathConstants.NODESET);
		} catch (XPathExpressionException xPathEx) {
			xPathEx.printStackTrace();
		}

		NodeList nodes = (NodeList) result2;

		for (int i = 0; i < nodes.getLength(); i++) {
			System.out.println(nodes.item(i).getChildNodes().item(1).getTextContent());
		}

	}

}
