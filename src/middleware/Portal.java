/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;

import java.util.HashMap;

/**
 *
 * @author 44789
 */
public class Portal extends MetaAgent{
    
    HashMap<String, UserAgent> map = new HashMap(); 

    public Portal(String id) 
    {
        super(id);
    }


    public void addAgent(String name, UserAgent agent)
    {
        map.put(name, agent);
    }
    
    public void removeAgent(String name)
    {
        map.remove(name);
    }
    
    public void messageReceived(Message msg) throws InterruptedException
    {
        MetaAgent s = msg.recipient;
        sendMessage(s, msg);
    }
    
    public void sendMessage(MetaAgent recipient, Message msg) throws InterruptedException
    {
        recipient.messageRecieved(msg);
    }
}
