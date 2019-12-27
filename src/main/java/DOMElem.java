import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DOMElem {

    private static final Logger log = Logger.getLogger(XMLByXSDValidator.class);

    public Document DOMDoc;
    private String path;
    private String[] randomName;
    private List<String> listOfNames;
    private Integer rnd = 0;

    DOMElem(String path) {

        DOMDoc = this.getXML(path);
        loadListOfNames();

    }

    private Document getXML(String path) {
        try {
            this.path = path;

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.parse(path);

            loadListOfNames();
            return document;

        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }


        return null;
    }


    private void loadListOfNames() {
        try {
            //FileInputStream in = new FileInputStream("resources\\NamesDB.txt");
            Path filePath = new File("src/main/resources/NamesDB.txt").toPath();
            listOfNames = Files.readAllLines(filePath, Charset.defaultCharset());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getRandomName() {
        Integer Min = 1, Max =listOfNames.size()-1, rndNum;
        rndNum = Min + (int)(Math.random() * ((Max - Min) + 1));
        //Random rndGen = new Random(System.currentTimeMillis());
        //this.rnd = rndGen.nextInt(listOfNames.size());
        //String str = this.listOfNames.get(rnd);
        randomName = this.listOfNames.get(rndNum).split(" ");

        return randomName[1];
    }

    private String newRandomName(){
        return "";
    }

    private String getRandomSurname() {
        return randomName[0];
    }

    private String getRandomPatronim() {
        return randomName[2];
    }

    public void randomizeNames() {

        int cnt =0;
        NodeList nodeList = DOMDoc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                switch (node.getNodeName()) {
                    case "name":
                        node.setTextContent(getRandomName());
                        cnt++;
                        break;
                    case "surname":
                        node.setTextContent(getRandomSurname());
                        cnt++;
                        break;
                    case "patronim":
                        node.setTextContent(getRandomPatronim());
                        cnt++;
                        break;
                }


            }
        }

        log.info("Changed " + cnt + " nodes");


    }

    public void printDOC() {

        Node node = DOMDoc.getDocumentElement();

        //System.out.println(DOMDoc.nod);

        System.out.println(node.getNodeName());
        System.out.println("\n");

        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                //calls this method for all the children which is Element
                System.out.println(currentNode);
            }
        }
    }


    public void printDOC2(String xmlPath) {

        Document DOMDoc = getXML(xmlPath);
        Node node1 = DOMDoc.getDocumentElement();

        Node doc = node1.getParentNode();

        //System.out.println(DOMDoc.nod);

        //System.out.println(node.getNodeName());
        //System.out.println("\n");

        NodeList nodeList = DOMDoc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            //nodeList.item(i).ow
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                // do something with the current element
                int depth = 0;
                Node cur = node;

                while (cur.getParentNode() != doc) {
                    depth++;
                    cur = cur.getParentNode();
                }

                String spaces = String.join("", Collections.nCopies(depth * 2, "- "));
                String spaces2 = String.join("", Collections.nCopies(depth * 2, "_ "));
                System.out.println("/" + spaces + node.getNodeName());
                if (node.getFirstChild().getNextSibling() == null) {
                    System.out.println("\\" + spaces2 + node.getTextContent());
                }

            }
        }
    }

    public void save() {
        try {
            //Transformer trf = null;
            //DOMSource src = null;
            //FileOutputStream fos = null;

            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(DOMDoc);
            FileOutputStream fos = new FileOutputStream(path);
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);

        }
    }

    public void save(String path) {
        try {
            //Transformer trf = null;
            //DOMSource src = null;
            //FileOutputStream fos = null;

            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(DOMDoc);
            FileOutputStream fos = new FileOutputStream(path);
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
            log.error("DOM save error" , e);
        }
    }


}
