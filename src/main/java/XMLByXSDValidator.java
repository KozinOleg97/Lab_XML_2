import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLByXSDValidator {



    public boolean checkByXSD(String XSDpath, String XMLpath){
        try {


            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(XSDpath));
            Validator validator = schema.newValidator();

            validator.validate(new StreamSource(new File(XMLpath)));

        } catch (SAXException e) {
            System.out.println("SAX Exception! Validation failed");
            return false;
        } catch (IOException e) {
            System.out.println("IO Exception! Validation failed");
            return false;
        }
        return true;
    }
}
