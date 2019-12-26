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
                "src\\main\\resources\\testXML\\TestXSD.xsd",
                "src\\main\\resources\\testXML\\NewGen.xml",
                "src\\main\\resources\\testXML\\New_1.xml");

        lab.doValidation();
        lab.doJAXB("student.xml");

        ///////////JAXB DEMO///////////////////////
        //JAXBParser jaxbParser = new JAXBParser("resources\\testXML\\3.xml");

       /* JAXBContext context = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);


        Student student = new Student();
        student.setAge(50);
        student.setId(9999);
        student.setLanguage("qwe");
        student.setName("qweqeqewqew");
        student.setPassword("d");


        marshaller.marshal(student, new File("student.xml"));
*/


    }
}
