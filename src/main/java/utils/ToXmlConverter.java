package utils;

import model.AthleteModel;
import org.w3c.dom.Document;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class ToXmlConverter {

    public void convert(List<AthleteModel> athleteList) {
        try {
            FormXml d = new FormXml();
            d.getXmlDocumentFormed(athleteList);
            transformToXml(d.getDocument());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transformToXml(Document doc) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(getNameAndDir()));
        transformer .setOutputProperty(OutputKeys.INDENT, "yes");
        transformer .setOutputProperty(OutputKeys.METHOD, "xml");
        transformer .setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(source, result);
        StreamResult consoleResult = new StreamResult(System.out);
        transformer.transform(source, consoleResult);

        System.out.println("File saved to " + System.getProperty("user.home") + " directory");
    }


    public String getNameAndDir() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name for new XML document:");
        String name = scan.nextLine();
        return System.getProperty("user.home") + "/" + name + ".xml";
    }
}
