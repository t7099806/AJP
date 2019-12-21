/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;

import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karl
 */
public class Router extends MetaAgent
{
    TreeMap<String, MetaAgent> map = new TreeMap<>();

    public Router(String name) 
    {
        super(name);
    }

    @Override
    public void sendMessage(String recipient, Message msg) 
    {

    }

    @Override
    public void receiveMessage(Message msg) 
    {
        System.out.println("Router " + this.name + " received message " + msg.id
         + " from " + msg.sender + ". Sending message to " + msg.recipient);
        
    }
    
    @Override
    public void msgHandler(Message msg)
    {
       if (map.containsKey(msg.recipient))
       {
           MetaAgent ma = map.get(msg.recipient);
           try 
           {
               ma.put(msg);
           } 
           catch (InterruptedException ex) 
           {
               Logger.getLogger(Router.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       else
           System.out.println(map.keySet());
    }
}
