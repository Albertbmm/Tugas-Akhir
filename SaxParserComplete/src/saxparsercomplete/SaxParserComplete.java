/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparsercomplete;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author USER
 */
public class SaxParserComplete {

   public static void main(String argv[]) {

    try {

	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();

	DefaultHandler handler = new DefaultHandler() {

	
        int length1;
        int length;
        int qLength;
	public void startElement(String uri, String localName,String qName,
                Attributes attributes) throws SAXException {
                /*untuk mengambil atribut elemen di dalam nested*/
                qLength = qName.length();
                for(int i=0;i<qLength;i++){
                    String qValuename = qName.toString().toLowerCase();
                    //System.out.println(qValuename);
                    if(qValuename.equalsIgnoreCase("lifeline")){
                        //mencoba untuk mengambil atribute elemen lifeline 
                        length = attributes.getLength();
                        for(int j=0;j<length;j++){
                        String attrName = attributes.getLocalName(j);
                        if(attrName.compareToIgnoreCase("name")== 0){
                                String val = attributes.getValue(j);
                                System.out.println("NamaFungsi: " + val);
                            
                        }
                      
                        }
                    }
                    else if(qValuename.equalsIgnoreCase("message")){
                        //mencoba untuk mengambil atribute elemen lifeline 
                        length = attributes.getLength();
                        for(int j=0;j<length;j++){
                        String attrName = attributes.getLocalName(j);
                        if(attrName.compareToIgnoreCase("name")== 0){
                                String val = attributes.getValue(j);
                                System.out.println("IsiMessage: " + val);
                            
                        }

                        }
                    }

                    break;
                }
                
	}
     };

       saxParser.parse("src/XML/contoh1.xmi", handler);

     } catch (Exception e) {
       e.printStackTrace();
     }

   }

}