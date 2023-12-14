package manhntph29583.baithi.myasm_nc.MainNews;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class FileXML {
    public Document getDocument(String xml) throws IOException, SAXException {
        Document document =null;
        DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        InputSource inputSource = new InputSource();
        inputSource.setCharacterStream(new StringReader(xml));
        inputSource.setEncoding("UTF-8");
        document = builder.parse(inputSource);
        return document;
    }

    public String getValue(Element node, String name){
        String result = "";
        NodeList nodeList = node.getElementsByTagName(name);
        result = getTextOfNode(nodeList.item(0));
        return result;
    }

    private String getTextOfNode(Node item) {
        Node con;
        if(item!=null){
            if(item.hasChildNodes()){
                for(con=item.getFirstChild(); con!=null; con=item.getNextSibling()){
                    if(con.getNodeType()==Node.TEXT_NODE){
                        return  con.getNodeValue();
                    }
                }
            }
        }
        return "";
    }
}
