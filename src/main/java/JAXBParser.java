
import ru.rsatu.kozin.lab.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class JAXBParser {

    JAXBParser(String pathFrom, String pathTo)  {




        // восстанавливаем объект из XML файла
        University university = fromXmlToObject(pathFrom);
        if (university != null) {
            System.out.println(university.toString());
            System.out.println(university.getClass());
        }


        university = editObj(university);

        // сохраняем объект в XML файл
        convertObjectToXml(university, pathTo);


    }

    private University editObj(University university) {

        university.setUniversityName("New Name!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Administration administration =  university.getAdministration();
        DepartmentOfScientific departmentOfScientific = administration.getDepartmentOfScientific();
        Library library = departmentOfScientific.getLibrary();
        List<Book>  books =  library.getBook();
        for (Book book: books){
            System.out.println(book.getTitle()+ "  " + book.getTitle() +"  "+ book.isState());
        }
        //List<Serializable> q = book.getBookIDAndTitleAndState();

        return university;
    }


    // восстанавливаем объект из XML файла
    private University fromXmlToObject(String filePath) {
        try {
            // создаем объект JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(University.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (University) un.unmarshal(new File(filePath));
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
            //File file = new File(filePath);
            //file.createNewFile();
            marshaller.marshal(university, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}