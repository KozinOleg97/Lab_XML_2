import com.example.Doc;
import com.example.ObjectFactory;
import com.example.Student;
import com.example.University;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;

public class LabInterface {

    private String pathToXSD;
    private String pathToPatternXML;
    private String pathToFinalXML;

    LabInterface(String pathToXSD, String pathToPatternXML, String pathToFinalXML) {

        this.pathToXSD = pathToXSD;
        this.pathToPatternXML = pathToPatternXML;
        this.pathToFinalXML = pathToFinalXML;
    }

    public void doDOM() {
        DOMElem dom = new DOMElem(pathToPatternXML);
        dom.randomizeNames();
        dom.printDOC2();
        dom.save(pathToFinalXML);

    }

    public void doSAX() {
        MySAXHandler mySaxHandler = new MySAXHandler();
        MySAXParser mySAXParser = new MySAXParser();
        mySAXParser.parse(pathToFinalXML, mySaxHandler);
    }

    public void doJAXB(Class aClass , String fileToGen) {
       JAXBParser jaxbParser = new JAXBParser(fileToGen);

    }

    public void doValidation() {
        XMLByXSDValidator validator = new XMLByXSDValidator();
        System.out.println(validator.checkByXSD(pathToXSD, pathToFinalXML));
    }

}
