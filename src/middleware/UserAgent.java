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
    
    public UserAgent(String name, int capacity) 
    {
        super(name, capacity);
        portal.map.put(this.name, this);
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
        portal.receiveMessage(msg);
    }

    @Override
    public void receiveMessage(Message msg) 
    {
        // this 2nd
    }
    
    public void setPortal(Portal p)
    {
        portal = p;
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
