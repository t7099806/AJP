/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 44789
 */
public class UserAgent extends MetaAgent 
{
    
    public UserAgent(String name) 
    {
        super(name);
        
        this.run = true;
        start();
    }
    
    @Override
    public void sendMessage(String recipient, Message msg) 
    {
        try 
        {
            portal.put(msg);
        } 
        catch (InterruptedException ex) 
        {
            Logger.getLogger(UserAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void receiveMessage(Message msg) 
    {
        // this 2nd
    }
    
    
    
    public String getSender(Message msg)
    {
        return msg.sender;
    }
    
    public String getRecipient(Message msg)
    {
        return msg.recipient;
    }
    
    public int getMessageId(Message msg)
    {
        return msg.id;
    }

}
