/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparser;

import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;


/**
 *
 * @author User
 */
public class GetElementAttributesInSAXXMLParsing extends DefaultHandler {
    public static void main(String[] args) throws Exception{
        DefaultHandler handler = new GetElementAttributesInSAXXMLParsing();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(false);
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File("src/XML/Untitled.xmi"), handler);
    }
    @Override
    public void startElement(String Uri, String localName,String qName,Attributes attributes)throws SAXException{
        int length = attributes.getLength();
        
        for(int i=0;i<length;i++){
            String sAttrName = attributes.getLocalName(i);
            if(sAttrName.compareTo("name")== 0){
                String sVal = attributes.getValue(i);
                System.out.println("Attribut value : " + sVal);
            } 
            
            /*
            String name = attributes.getQName(i);
            System.out.println("Atribut 1: " + name);
            
            String value = attributes.getValue(i);
            System.out.println("Attribut value : " + value);
            
            String nsUri = attributes.getURI(i);
            System.out.println("Attribute uri: " + nsUri);
            
            //String Lname = attributes.getLocalName(i);
            //System.out.println("nama local : " + Lname);
            */
         
        }
    }
}
