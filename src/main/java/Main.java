//import generated.*;
import Exeptions.DOMErr;
import Exeptions.JAXBErr;
import Exeptions.SAXErr;
import org.xml.sax.SAXException;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        LabInterface lab = new LabInterface(
                "src/main/resources/testXML/TestXSD.xsd",
                "src/main/resources/testXML/NewGen4.xml",
                "src/main/resources/testXML/FinalEditedXML4.xml");

        try {
            lab.doDOM();

            lab.doValidation();

            lab.doSAX();

            lab.doJAXB("output.xml");

            lab.doValidation("src/main/resources/testXML/TestXSD.xsd", "output.xml");
        } catch (DOMErr | JAXBErr | SAXErr e) {
            System.out.println(e);
        }


    }
}
