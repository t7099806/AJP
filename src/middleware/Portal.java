/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 44789
 */
public class Portal extends MetaAgent
{
    TreeMap<String, MetaAgent> map = new TreeMap<>();
    Router router;
    
    public Portal(String name) 
    {
        super(name);
    }

    
    @Override
    public void msgHandler(Message msg)
    {
        if (map.containsKey(msg.recipient))
        {
            try 
            {
                map.get(msg.recipient).put(msg);
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(Portal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            try 
            {
                this.portal.map.get(msg.recipient).put(msg);
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(Portal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void sendMessage(String recipient, Message msg) 
    {

    }

    @Override
    public void receiveMessage(Message msg) 
    {
        System.out.println("Portal " + this.name + " received message " + msg.id
         + " from " + msg.sender + ". Sending message to " + msg.recipient);
    }
    
    public void addAgent(String s, MetaAgent ma)
    {
        map.put(s, ma);
    }
    
    public void removeAgent(String s)
    {
        map.remove(s);
    }
    
    public void addRouter(Router r)
    {
        router = r;
    }
    
    
}
