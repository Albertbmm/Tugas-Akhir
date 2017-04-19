/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaparsermodel;


/**
 *
 * @author USER
 */
public class message  {

   
       private String message;
       private String messageSort;
 

       

    public message() {
        
    }
    
       public message(String message, String messageSort) {
              
              this.message = message;
              this.messageSort = messageSort;
       }
    
       public String getMessage(){
           return message;
       }
       public void setMessage(String message){
           this.message = message;
       }
       public String getMessageSort(){
           return messageSort;
       }
       public void setMessageSort(String messageSort){
           this.messageSort = messageSort;
       }
       
       public String toString() {
              StringBuffer sb = new StringBuffer();
              sb.append("Atribute element Lifeline - ");
              sb.append("pesan:" + getMessage());
              sb.append(", ");
              sb.append("Tipe pesan:" + getMessageSort());
              sb.append(". ");
              return sb.toString();
       }
    
}
