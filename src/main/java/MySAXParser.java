import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;


public class MySAXParser {

    private SAXParser parser;

    MySAXParser() {
        try {


            SAXParserFactory factory = SAXParserFactory.newInstance();
            //factory.setXIncludeAware();
            SAXParser parser = factory.newSAXParser();

            this.parser = parser;


        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }


    public void parse(String path, DefaultHandler handler) {

        try {

            this.parser.parse(path, handler);


        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
