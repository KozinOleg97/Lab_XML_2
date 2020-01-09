package ru.rsatu;

import ru.rsatu.Exeptions.*;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;

public class LabInterface {

    private String pathToXSD;
    private String pathToPatternXML;
    private String pathToFinalXML;
    private static final Logger log = Logger.getLogger(LabInterface.class);

    public LabInterface(String pathToXSD, String pathToPatternXML, String pathToFinalXML) {

        this.pathToXSD = pathToXSD;
        this.pathToPatternXML = pathToPatternXML;
        this.pathToFinalXML = pathToFinalXML;
    }

    public void doDOM() throws DOMErr {
        System.out.println("\n-------------DOM---------------------------\n");

        try {
            DOMElem dom = new DOMElem();

            Document document = dom.getXML(pathToPatternXML);
            dom.randomizeNames(document);

            dom.save(pathToFinalXML, document);

            dom.printDOC2(pathToFinalXML);

        } catch (InitErr initErr) {
            log.error("DOM Init err(wrong path): " + initErr.getPath(), initErr);
            throw new DOMErr("Fail to Init");
        } catch (OutputErr outputErr) {
            log.error("DOM output err: " + outputErr.getPath() + " | " + outputErr.getData(), outputErr);
            throw new DOMErr("Fail to Output");
        } catch (EditErr editErr) {
            log.error("DOM edit err", editErr);
            throw new DOMErr("Fail to Edit");
        }
        System.out.println("\n-------------end---------------------------\n");

    }

    public void doSAX() throws SAXErr {
        System.out.println("\n-------------SAX---------------------------\n");
        MySAXHandler mySaxHandler = new MySAXHandler();
        MySAXParser mySAXParser = new MySAXParser();
        try {
            mySAXParser.parse(pathToFinalXML, mySaxHandler);
        } catch (InitErr initErr) {
            log.error("SAX Init err: " + initErr.getPath(), initErr);
            throw new SAXErr("Fail to Init");
        } catch (EditErr editErr) {
            log.error("SAX edit err", editErr);
            throw new SAXErr("Fail to Edit");
        }
        System.out.println("\n-------------end---------------------------\n");
    }

    public void doJAXB(String fileToGen) throws JAXBErr {
        System.out.println("\n-------------JAXB---------------------------\n");

        try {
            JAXBParser jaxbParser = new JAXBParser(pathToFinalXML, fileToGen);
        } catch (EditErr editErr) {
            log.error("Edit (convert) err", editErr);
            throw new JAXBErr("Fail to Edit");
        }
        System.out.println("\n-------------end---------------------------\n");
    }

    public void doValidation() {
        System.out.println("\n-------------Validation---------------------------\n");

        XMLByXSDValidator validator = new XMLByXSDValidator();
        System.out.println("Validation result: " + validator.checkByXSD(pathToXSD, pathToFinalXML));

        System.out.println("\n-------------end---------------------------\n");
    }

    public void doValidation(String pathToXSD, String pathToFinalXML) {
        System.out.println("\n-------------Validatoin---------------------------\n");

        XMLByXSDValidator validator = new XMLByXSDValidator();
        System.out.println("Validation result: " + validator.checkByXSD(pathToXSD, pathToFinalXML));

        System.out.println("\n-------------end---------------------------\n");
    }

}
