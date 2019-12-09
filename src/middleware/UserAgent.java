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
public class UserAgent extends MetaAgent 
{
    
    Portal portal;
    
    public UserAgent(String id, Portal p) 
    {
        super(id);
        portal = p;      
    }
    
    public String getSender(Message msg)
    {
        return msg.sender.getName();
    }
    
    public String getRecipient(Message msg)
    {
        return msg.recipient.getName();
    }
    
    public String getRawMessage(Message msg) throws InterruptedException
    {
        msg = queue.take();
        return msg.wrap();
    }
    
    public int getMessageId(Message msg)
    {
        return msg.id;
    }
    
    @Override
    public void sendMessage(Message msg, String name) throws InterruptedException
    {
        portal.messageReceived(msg);
    }
    
    public void messageRecieved(Message msg) throws InterruptedException
    {
        System.out.println("is this working????");
    }
    
}
