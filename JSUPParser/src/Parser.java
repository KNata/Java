import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.w3c.dom.NodeList;


public class Parser {

	
	
	Parser() {
		
	}
	
	
	public void tryParser() throws ParserConfigurationException, IOException {
		URL url = new URL("http://en.wikipedia.org/wiki/Chicken_Kiev");
	    URLConnection uc = url.openConnection();

	    InputStreamReader input = new InputStreamReader(uc.getInputStream());
	    BufferedReader in = new BufferedReader(input);
	    String inputLine;

	     FileWriter outFile = new FileWriter("chikenKyiv");
	     PrintWriter out = new PrintWriter(outFile);

	    while ((inputLine = in.readLine()) != null) {
	        out.println(inputLine);
	    }

	    in.close();
	    out.close();

	    File fXmlFile = new File("");
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
	    Elements newsHeadlines = doc.select("head");
	    System.out.println(newsHeadlines.hasText());
	    System.out.println(newsHeadlines.html());

	}
}
