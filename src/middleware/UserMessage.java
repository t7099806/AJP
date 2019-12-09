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
public class UserMessage extends Message{
    
    public UserMessage(String rawMessage, MetaAgent sender, MetaAgent recipient) {
        super(rawMessage, sender, recipient);
    }
    
    @Override
    public String wrap()
    {
        return("Message id: " + id + "\n"
                +"To: " + recipient.getName() + "\n"
                +"From: " + sender.getName() + "\n"
                +"Message: " + rawMessage);
    }
    
}
