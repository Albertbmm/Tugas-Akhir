/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaparserModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javaparserModel.Account;
import javaparsermodel.message;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * BUTUH DI EDIT
 * @author USER
 */
public class javaparserModel extends DefaultHandler{

       private Account acct;
       private message msgg;
       private String temp;
       private ArrayList<Account> accList = new ArrayList<Account>();
       private ArrayList<message> msg = new ArrayList<message>();
    public static void main(String[] args) throws IOException, SAXException,ParserConfigurationException, org.xml.sax.SAXException 
    {
              SAXParserFactory spfac = SAXParserFactory.newInstance();

              //Now use the parser factory to create a SAXParser object
              SAXParser sp = spfac.newSAXParser();

              //Create an instance of this class; it defines all the handler methods
              javaparserModel handler = new javaparserModel();

              //Finally, tell the parser to parse the input and notify the handler
              sp.parse("src/xml/contoh1.xmi", handler);
              
             
              handler.readList();
    }
    
    public void characters(char[] buffer, int start, int length) {
              temp = new String(buffer, start, length);
       }
     public void startElement(String uri, String localName,String qName, Attributes attributes) throws SAXException {
              temp = "";
              if (qName.equalsIgnoreCase("lifeline")) {
                     acct = new Account();
                     String packageName = attributes.getValue("name");
                     String packageType = attributes.getValue("xmi:type");
                     acct.setType(packageType);
                     acct.setName(packageName);
              }
              else if (qName.equalsIgnoreCase("message")) {
                     msgg = new message();
                     String messageName = attributes.getValue("name");
                     String messagesort = attributes.getValue("messageSort");
                     msgg.setMessage(messageName);
                     msgg.setMessageSort(messagesort);
              }
       }
     
    public void endElement(String uri, String localName, String qName)
                     throws SAXException {

            if (qName.equalsIgnoreCase("lifeline")) {
                     // add it to the list
                     accList.add(acct);
              }
            else if (qName.equalsIgnoreCase("message")) {
                     // add it to the list
                     msg.add(msgg);
              }
            /*else if (qName.equalsIgnoreCase("Name")) {
                     acct.setName(temp);
              } else if (qName.equalsIgnoreCase("Id")) {
                     acct.setId(Integer.parseInt(temp));
              } else if (qName.equalsIgnoreCase("Amt")) {
                     acct.setAmt(Integer.parseInt(temp));
              }
                */
               
       }
    
    private void readList() {
        
        System.out.println("Banyak Elemen Lifeline :  '" + accList.size()  + "'.");
              Iterator<Account> it = accList.iterator();
              while (it.hasNext()) {
                     System.out.println(it.next().toString());
    }
        
        System.out.println("Banyak Message : " + msg.size());
        Iterator<message> it2 = msg.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next().toString());
        }
              
    
}
}
