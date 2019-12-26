import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

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
        dom.save(pathToFinalXML);
    }

    public void doSAX() {
        MySAXHandler mySaxHandler = new MySAXHandler();
        MySAXParser mySAXParser = new MySAXParser();
        mySAXParser.parse(pathToFinalXML, mySaxHandler);
    }

    public void doJAXB(String fileToGen) {
        try {
            JAXBContext context = JAXBContext.newInstance(Student.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            File xml = new File(pathToFinalXML);
            Student student = (Student) unmarshaller.unmarshal(xml);


            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


            /*Student student = new Student();
            student.setAge(50);
            student.setId(9999);
            student.setLanguage("test_lang");
            student.setName("test_name");
            student.setPassword("test_pass");*/


            marshaller.marshal(student, new File(fileToGen));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void doValidation() {
        XMLByXSDValidator validator = new XMLByXSDValidator();
        System.out.println(validator.checkByXSD(pathToXSD, pathToFinalXML));
    }

}
