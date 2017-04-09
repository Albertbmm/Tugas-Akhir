/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
/**
 *
 * @author USER
 */

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySaxParser {

   public static void main(String argv[]) {

    try {

	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();

	DefaultHandler handler = new DefaultHandler() {

	boolean bfname = false;
	boolean blname = false;
	boolean bnname = false;
	boolean bsalary = false;
        boolean blid = false;
        boolean companyT = true;
        int length1;
        int length;
        int qLength;
	public void startElement(String uri, String localName,String qName,
                Attributes attributes) throws SAXException {
                /*untuk mengambil atribut elemen di dalam nested*/
                qLength = qName.length();
                for(int i=0;i<qLength;i++){
                    String qValuename = qName.toString().toLowerCase();
                    System.out.println(qValuename);
                    if(qValuename.equalsIgnoreCase("company")){
                        //mencoba untuk mengambil elemen yang sama 
                        //companyT = qValuename.equalsIgnoreCase("company");
                       // System.out.println("Company berhasil berhasil dibuka");
                    }
                    else if(qValuename.equalsIgnoreCase("lastname")){
                        length = attributes.getLength();
                        for(int j=0;j<length;j++){
                            String attributeLN = attributes.getLocalName(j);
                            System.out.println(attributeLN);
                            //break;
                        }
                       // System.out.println("lastname berhasil dibuka ");
                    }
                    else if(qValuename.equalsIgnoreCase("staff")){
                        //System.out.println("staff berhasil dibuka ");
                    }
                    
                    break;
                }
                /*
		System.out.println("Start Element :" + qName);
                if (qName.equalsIgnoreCase("STAFF")) {
                   length = attributes.getLength();
                for(int i=0;i<length;i++){
                    String attrstaff = attributes.getLocalName(i);
                    if (attrstaff.equalsIgnoreCase("id"))
                       {
                         String attrValuename = attributes.getValue(i);
                         System.out.println(attrValuename);
                         //blid = true;
                      }
                    if(attrstaff.equals("job"))
                    {
                        String attrValue2 = attributes.getValue(i);
                        System.out.println(attrValue2);
                        //blid = true;
                    }
                 }
                    
		}
                
		if (qName.equalsIgnoreCase("FIRSTNAME")) {
                   length1 = attributes.getLength();
                   for(int i=0;i<length1;i++){
                       String attrName = attributes.getLocalName(i);
                       if(attrName.equalsIgnoreCase("asli"))
                       {
                           String attrValue = attributes.getValue(i);
                           System.out.println(attrValue);
                       }
                       
                   }
                    bfname = true;
		}
                
                
		if (qName.equalsIgnoreCase("LASTNAME")) {
			blname = true;
		}

		if (qName.equalsIgnoreCase("NICKNAME")) {
			bnname = true;
		}

		if (qName.equalsIgnoreCase("SALARY")) {
			bsalary = true;
		}*/

	}

	public void endElement(String uri, String localName,
		String qName) throws SAXException {

		System.out.println("End Element :" + qName);

	}

	public void characters(char ch[], int start, int length) throws SAXException {

		/*if (bfname) {
			System.out.println("First Name : " + new String(ch, start, length));
			bfname = false;
		}*/
                if(blid){
                    System.out.println("Id mkyong "+ new String(ch, start, length));
                    blid = false;
                }
		/*if (blname) {
			System.out.println("Last Name : " + new String(ch, start, length));
			blname = false;
		}*/

		/*f (bnname) {
			System.out.println("Nick Name : " + new String(ch, start, length));
			bnname = false;
		}

		if (bsalary) {
			System.out.println("Salary : " + new String(ch, start, length));
			bsalary = false;
		}
                    */
	}

     };

       saxParser.parse("src/XML/contoh.xml", handler);

     } catch (Exception e) {
       e.printStackTrace();
     }

   }

}