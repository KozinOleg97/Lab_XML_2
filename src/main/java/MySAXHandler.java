import Exeptions.EditErr;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MySAXHandler extends DefaultHandler {

    private String curQName;
    private String name = "";
    private String surname = "";
    private String patronim = "";
    private Integer state = 0;
    private Integer studentsNumb = 0;
    private int bookState = 0;
    private int bookNumb = 0;


    @Override
    public void startDocument() {


        System.out.println("Start parse XML");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        this.curQName = qName;

        switch (qName) {

            case "library":
                bookState = 1;
                break;
            case "book":
                if (bookState == 1) {
                    bookState = 2;
                }
                break;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {


        switch (qName) {

            case "library":
                bookState = 0;
                break;
            case "book":
                if (bookState == 2) {
                    bookState = 1;
                }
                break;
        }


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
    public void characters(char[] ch, int start, int length) {

        if (bookState == 2) {
            switch (curQName) {
                case "book":
                    bookNumb++;



            }
        }


        switch (curQName) {
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
    public void endDocument() {

        System.out.println("Overall books: " + bookNumb);
        System.out.println("End parse XML");
    }
}
