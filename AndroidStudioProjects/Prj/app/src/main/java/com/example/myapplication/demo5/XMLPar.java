package com.example.myapplication.demo5;

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

public class XMLPar {
    //1.lay ve 1 tai lieu tu internet
    public Document getDocument(String xml) throws IOException, SAXException {
        Document document=null;
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();//tao tai lieu trang
        DocumentBuilder builder=null;
        try {
            builder=factory.newDocumentBuilder();//xay dung input dua du lieu vao tai lieu
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        InputSource inputSource=new InputSource();//su dung input
        //tao luong doc du lieu theo link truyen vao
        inputSource.setCharacterStream(new StringReader(xml));
        inputSource.setEncoding("UTF-8");
        //dua du lieu vao tai lieu
        document=builder.parse(inputSource);
        return document;
    }
    //2. Lat ve title, link cua element
    public String getValue(Element node,String name)
    {
        String result="";
        //lay ve tat ca cac nut cung ten
        NodeList nodeList=node.getElementsByTagName(name);
        //lay ve text cua item dau tien
        result=getTextOfNode(nodeList.item(0));
        return result;
    }
    //phuong thuc lay text cua node
    private String getTextOfNode(Node item) {
        Node con;
        if(item!=null)
        {
            if(item.hasChildNodes())//neu co node con
            {
                for(con=item.getFirstChild();con!=null;con.getNextSibling())//doc tu con ca den con ut
                {
                    if(con.getNodeType()==Node.TEXT_NODE)
                    {
                        return con.getNodeValue();//tra ve ket qua
                    }
                }
            }
        }
        return "";
    }
}
