package XML;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyFactory {
	
	private Student student;
	private ArrayList<Student> studentsList;
	private Element staff;
	
	MyFactory(ArrayList<Student> aStudentsList) {
		studentsList = aStudentsList;
	}
	
	public void createDocument() {
		  try {
			  
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		 
				// root elements
				Document doc = docBuilder.newDocument();
								
				Element rootElement = doc.createElement("Univercity");
				doc.appendChild(rootElement);
				
		 
				// staff elements
				staff = doc.createElement("Students");
				rootElement.appendChild(staff);

				
				for (int i = 0; i < studentsList.size(); i++) {
					//id
					Element id = doc.createElement("id");
					id.appendChild(doc.createTextNode(String.valueOf(studentsList.get(i).getId())));
					staff.appendChild(id);
					
					// firstname elements
					Element firstname = doc.createElement("firstname");
					firstname.appendChild(doc.createTextNode(studentsList.get(i).getFirstName()));
					staff.appendChild(firstname);
			 
					// lastname elements
					Element lastname = doc.createElement("lastname");
					lastname.appendChild(doc.createTextNode(studentsList.get(i).getLastName()));
					staff.appendChild(lastname);
				}
		 
				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File("/Users/natalia/Documents/workspace_eclipseKepler/XLM/file1.xml"));
				 
				transformer.transform(source, result);
		 
				System.out.println("File saved!");
		 
			  } catch (ParserConfigurationException pce) {
				pce.printStackTrace();
			  } catch (TransformerException tfe) {
				tfe.printStackTrace();
			 }
	}
	
	public void readFromDocument() {
		try {
			 
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
		 
			DefaultHandler handler = new DefaultHandler() {
		 
			boolean bfname = false;
			boolean blname = false;
			
		 
			public void startElement(String uri, String localName,String qName) throws SAXException {
		 
				System.out.println("Start Element :" + qName);
		 
				if (qName.equalsIgnoreCase("FIRSTNAME")) {
					bfname = true;
				}
		 
				if (qName.equalsIgnoreCase("LASTNAME")) {
					blname = true;
				}
		 
			}
		 
			public void endElement(String uri, String localName,
				String qName) throws SAXException {
				System.out.println(" Element :" + qName + localName + uri);
			}
		 
			public void characters(char ch[], int start, int length) throws SAXException {
		 
				if (bfname) {
					System.out.println("First Name : " + new String(ch, start, length));
					bfname = false;
				}
		 
				if (blname) {
					System.out.println("Last Name : " + new String(ch, start, length));
					blname = false;
				}
		 
		 
			}
		 
		     };
		 
		       saxParser.parse("/Users/natalia/Documents/workspace_eclipseKepler/XLM/file1.xml", handler);
		 
		     } catch (Exception e) {
		       e.printStackTrace();
		     }
		 
		   }
		
}
