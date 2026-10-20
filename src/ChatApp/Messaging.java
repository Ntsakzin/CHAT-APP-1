/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChatApp;

import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author nkuna
 */
public class Messaging {
    
    
    private String messageID;
    private String recipient;
    private String message;
    private int messageNumber;
    private String messageHash;
    private static int totalMessages=0;
    
    
    public Messaging(String recipient, String message, int messageNumber){
        this.recipient = recipient;
        this.message = message;
        this.messageNumber = messageNumber; 
        
        Random ran = new Random();
        
        this.messageID =String.valueOf(1000000000L+(long)(ran.nextDouble()* 9000000000L));
        this.messageHash = createMessageHash();
    }
    
    
    public boolean checkMessageID(){
        
        return messageID.length()<=10;
        
    }
    
    public boolean checkRecipientCell(){
        if (recipient.matches("^\\+27\\d{9}$")){
            
        }
        
        return recipient.matches("^\\+27\\d{9}$");
    }
    
    public String createMessageHash(){
        
        String[] words = message.split(" ");
        String firstWords=words[0].toUpperCase();
        String lastWords=words[words.length-1].replaceAll("[^a-zA-Z]","").toUpperCase();
        
        return messageID.substring(0,2) + ":" + messageNumber + ":" + firstWords + lastWords;
    }
    
    public String SentMessage(int option){
        
        if (option == 1){
            totalMessages++;
            
            return "Message successfully sent";
        }
        else if(option == 2){
            
            return "Press 0 to delete the message";
        }
        else if(option == 3){
            
            storeMessage();
            
            return "Message successfuly stored";
        }
        else {
            return "Invalid option";
        }
    }
    
    public String printMessages(){
        
        return "\nMessag ID:" + messageID + "\nMessage Hash:" + messageHash + "\nRecipient:" + recipient + "\nMessage:" + message;
    }
    
    public static int returnTotalMessages(){
        
        return totalMessages;
    }
    
    public void storeMessage(){
        try{
            FileWriter writer = new FileWriter("messages.json", true);
            
            writer.write("{\n");
            writer.write("\"MessageID\":\"" + messageID + "\",\n");
            
            writer.write("\"MessageHash\":\"" + messageHash + "\",\n");
            
            writer.write("\"Recipient\":\"" + recipient + "\",\n");
            
            writer.write("\"Message\":\"" + message + "\",\n");
            writer.write("}\n");
            
            writer.close();
        } catch (IOException e){
            System.out.println("Error storing message");
        }
    }
}
