import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParserFactory;

public class MySAXHandler extends DefaultHandler {

    private String curQName, XMLPath;
    private String name = "", surname = "", patronim = "";
    private Integer state = 0, studentsNumb = 0;


    @Override
    public void startDocument() throws SAXException {


        System.out.println("Start parse XML");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        this.curQName = qName;

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {


        switch (qName) {
            case "students":
                if (this.state == 1) {

                    this.state = 0;

                    System.out.println("----Student " + this.studentsNumb + "----" + "\n"
                            + this.surname + " " + this.name + " " + this.patronim + "\n"
                            + "-----------------");

                    this.patronim = this.name = this.surname = "";
                }
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {


        switch (this.curQName) {
            case "students":
                if (this.state == 0) {
                    this.state = 1;
                    this.studentsNumb++;
                }

                if (this.state == 1) {
                    //throw new Exception("Bad XML");
                    //System.out.println("Bad XML");
                }
                break;
            case "name":
                if (this.state == 1 && this.name == "") {
                    this.name = new String(ch, start, length);
                }
                break;
            case "surname":
                if (this.state == 1 && this.surname == "") {
                    this.surname = new String(ch, start, length);
                }
                break;
            case "patronim":
                if (this.state == 1 && this.patronim == "") {
                    this.patronim = new String(ch, start, length);
                }
                break;
        }
    }


    @Override
    public void endDocument() throws SAXException {

        System.out.println("End parse XML");
    }
}
