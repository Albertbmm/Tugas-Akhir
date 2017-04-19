/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaparserModel;

/**
 *
 * @author USER
 */
public class Account {
     private String name;
       private String message;
       private String messageSort;
       private String type;

       public Account() {
       }

       public Account(String name, String message, String messageSort, String type) {
              this.name = name;
              this.type = type;
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
       public String getName() {
              return name;
       }

       public void setName(String name) {
              this.name = name;
       }

       public String getType() {
              return type;
       }

       public void setType(String type) {
              this.type = type;
       }

       public String toString() {
              StringBuffer sb = new StringBuffer();
              sb.append("Atribute element Lifeline - ");
              sb.append("Name:" + getName());
              sb.append(", ");
              sb.append("Type:" + getType());
              sb.append(", ");
              sb.append("pesan:" + getMessage());
              sb.append(", ");
              sb.append("Tipe pesan:" + getMessageSort());
              sb.append(". ");
         

              return sb.toString();
       }
    
}
