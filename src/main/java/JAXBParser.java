import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBParser {

    JAXBParser(String path) {

        String fileName = path;

        // объект Student с какими-то данными
        Student student = new Student();
        student.setId(1);
        student.setAge(22);
        student.setName("Andrew");
        student.setLanguage("Java");
        student.setPassword("simplepassword");

        // сохраняем объект в XML файл
        convertObjectToXml(student, fileName);

        // восстанавливаем объект из XML файла
        Student unmarshStudent = fromXmlToObject(fileName);
        if (unmarshStudent != null) {
            System.out.println(unmarshStudent.toString());
            System.out.println(unmarshStudent.getClass());
        }
    }


    // восстанавливаем объект из XML файла
    private  Student fromXmlToObject(String filePath) {
        try {
            // создаем объект JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (Student) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    // сохраняем объект в XML файл
    private  void convertObjectToXml(Student student, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = context.createMarshaller();
            // читабельн вывод XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //  объект в файл
            marshaller.marshal(student, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}