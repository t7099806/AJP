/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;

import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author 44789
 */
public class Portal extends MetaAgent
{
    TreeMap<String, MetaAgent> map = new TreeMap<>();
    
    public Portal(String name) 
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
        System.out.println("Portal " + this.name + " received message " + msg.id);
    }
    
    public void addAgent(String s, MetaAgent ma)
    {
        map.put(s, ma);
    }
    
    public void removeAgent(String s)
    {
        map.remove(s);
    }
    
}
