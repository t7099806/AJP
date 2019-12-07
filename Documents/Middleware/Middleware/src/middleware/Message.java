/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;

/**
 *
 * @author 44789
 */
public class Message {
    
    String rawMessage;
    int id;
    String sender;
    String recipient;
    static int idAutoIncrement = 0;
    
     Message(String rawMessage, int id, String sender, String recipient)
    {
        this.rawMessage = rawMessage;
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
    }
    
    public String wrap()
    {
        idIncrement();
        return("Message id: " + id + "\n"
                +"To: " + recipient + "\n"
                +"From: " + sender + "\n"
                +"Message: " + rawMessage);
    }
    
    public void idIncrement()
    {
        idAutoIncrement++;
    }
    
    
    
}
