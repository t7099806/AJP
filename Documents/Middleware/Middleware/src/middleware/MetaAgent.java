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
public class MetaAgent extends ArrayListBlockingQueue {
    String name;
    Portal portal;
    
    MetaAgent(Portal portal)
    {
        super();
        this.portal = portal;
    }
    
    public void messageHandler(Message msg)
    {
        
    }
    
    public void sendMessage(Message msg, String name)
    {
        
    }
    
    public void messageRecieved(Message msg)
    {
        
    }
    
    public void setName(String name)
    {
        if(isValidName(this.name) == true)
        {
             this.name = name;
        }
    }
    
    public String getName()
    {
        return this.name;
    }
    
    
    public boolean isValidName(String name)
    {
        return true;
    }
}
