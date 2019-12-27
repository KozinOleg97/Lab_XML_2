import com.example.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.Serializable;
import java.util.List;

public class JAXBParser {

    JAXBParser(String path)  {

        String fileName = path;

        // объект Student с какими-то данными
       /* Student student = new Student();

        Doc doc = new Doc();
        doc.setDocID(BigInteger.valueOf(1111111));

        student.setStudentDoc(doc);// setId(1);

        Date yourDate = new Date();
        yourDate.setTime(1233);
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(yourDate);
        XMLGregorianCalendar date2 = null;
        try {
            date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        student.setDateOfBirth(date2);// setAge(22);
        student.setName("Andrew");
        student.setSurname("Surname___");
        student.setPatronim("Patronim__");*/



        // восстанавливаем объект из XML файла
        University university = fromXmlToObject(fileName);
        if (university != null) {
            System.out.println(university.toString());
            System.out.println(university.getClass());
        }


        university = editObj(university);

        // сохраняем объект в XML файл
        convertObjectToXml(university, fileName);


    }

    private University editObj(University university) {

        university.setUniversityName("New Name");
        Administration administration =  university.getAdministration();
        DepartmentOfScientific departmentOfScientific = administration.getDepartmentOfScientific();
        Library library = departmentOfScientific.getLibrary();
        Book book =  library.getBook();
        List<Serializable> q = book.getBookIDAndTitleAndState();

        return university;
    }


    // восстанавливаем объект из XML файла
    private University fromXmlToObject(String filePath) {
        try {
            // создаем объект JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(University.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (University) un.unmarshal(new File("src\\main\\resources\\testXML\\New_1.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    // сохраняем объект в XML файл
    private void convertObjectToXml(University university, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(University.class);
            Marshaller marshaller = context.createMarshaller();
            // читабельн вывод XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //  объект в файл
            marshaller.marshal(university, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}