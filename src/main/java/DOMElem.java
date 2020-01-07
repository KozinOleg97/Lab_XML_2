import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import Exeptions.EditErr;
import Exeptions.InitErr;
import Exeptions.OutputErr;
import org.apache.log4j.Logger;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DOMElem {

    private static final Logger log = Logger.getLogger(XMLByXSDValidator.class);


    public Document getXML(String path) throws InitErr {
        Document document = null;
        try {

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            document = documentBuilder.parse(path);


        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new InitErr("getXML Err", path);
        }


        return document;
    }


    private List<String> loadListOfNames() throws EditErr {
        List<String> listOfNames = null;
        try {
            Path filePath = new File("src/main/resources/NamesDB.txt").toPath();
            listOfNames = Files.readAllLines(filePath, Charset.defaultCharset());

        } catch (IOException e) {
            throw new EditErr("LoadListOfNamesErr (No file src/main/resources/NamesDB.txt)");
        }

        return listOfNames;
    }

    /**
     * Return name data for one person
     *
     * @param listOfNames
     * @return String[]: name, surname, patronim;
     */
    private String[] getRandomData(List<String> listOfNames) {

        Integer Min = 1, Max = listOfNames.size() - 1, rndNum;
        rndNum = Min + (int) (Math.random() * ((Max - Min) + 1));

        String[] randomName = listOfNames.get(rndNum).split(" ");

        return randomName;
    }


    public void randomizeNames(Document DOMDoc) throws EditErr {

        List<String> listOfNames = loadListOfNames();

        int cnt = 0;
        String ns = DOMDoc.getNamespaceURI();

        NodeList nodeList = DOMDoc.getElementsByTagName("*");

        try {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    String[] data = getRandomData(listOfNames);

                    switch (node.getNodeName()) {
                        case "name":
                            node.setTextContent(data[0]);
                            cnt++;
                            break;
                        case "surname":
                            node.setTextContent(data[1]);
                            cnt++;
                            break;
                        case "patronim":
                            node.setTextContent(data[2]);
                            cnt++;
                            break;
                        case "title":
                            node.setTextContent(generateString(new Random(), "йцукенгзстырвла_", 6));
                            break;
                        case "bookID":
                            Random rnd = new Random();
                            node.setTextContent(String.format("%05d", rnd.nextInt(9999)));
                            break;
                    }


                }
            }
        } catch (IndexOutOfBoundsException e) {

            throw new EditErr("NameDB inex err");
        }

        log.info("Changed " + cnt + " nodes");


    }

    public static String generateString(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }


    public void printDOC2(String xmlPath) throws InitErr, OutputErr {

        Document DOMDoc = getXML(xmlPath);
        Node node1 = DOMDoc.getDocumentElement();

        Node doc = node1.getParentNode();


        NodeList nodeList = DOMDoc.getElementsByTagName("*");
        try {
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
        } catch (NullPointerException e) {
            throw new OutputErr("Print error (nullPointer)", xmlPath, doc);
        }
    }

    public void save(String path, Document DOMDoc) throws OutputErr {
        DOMSource source = null;
        try {

            Transformer tr = TransformerFactory.newInstance().newTransformer();
            source = new DOMSource(DOMDoc);

            FileOutputStream fos = new FileOutputStream(path);
            StreamResult result = new StreamResult(fos);

            tr.transform(source, result);

        } catch (TransformerException e) {

            throw new OutputErr("Data err", path, source);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            throw new OutputErr("Paths err", path, source);
        }
    }


}
