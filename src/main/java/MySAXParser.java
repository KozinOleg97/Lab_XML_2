import Exeptions.EditErr;
import Exeptions.InitErr;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;


public class MySAXParser {

    private SAXParser parser;


    public void parse(String path, DefaultHandler handler) throws InitErr, EditErr {

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            //factory.setXIncludeAware();
            SAXParser parser = factory.newSAXParser();

            parser.parse(path, handler);


        } catch (IOException e) {
            throw new InitErr("SAX parse err (paths)", path);
        } catch (ParserConfigurationException e) {
            throw new InitErr("SAX parser config err");
        } catch (SAXException e) {
            throw new EditErr("SAX err");
        }
    }
}
