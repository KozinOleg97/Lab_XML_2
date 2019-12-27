//import generated.*;
import org.xml.sax.SAXException;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, JAXBException {

        LabInterface lab = new LabInterface(
                "src/main/resources/testXML/TestXSD.xsd",
                "src/main/resources/testXML/NewGen4.xml",
                "src/main/resources/testXML/New_4.xml");

        lab.doDOM();

        lab.doValidation();

        lab.doSAX();

        lab.doJAXB("src/main/resources/testXML/NewGen4.xml", "output.xml");

        lab.doValidation("src/main/resources/testXML/TestXSD.xsd", "output.xml");





    }
}
