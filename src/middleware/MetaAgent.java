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

   MetaAgent(String id)
   {
       super();
       name = id;
   }
    
    

    public void messageHandler(Message msg)
    {
        
    }
    
    public void sendMessage(Message msg, String name) throws InterruptedException
    {
        enqueue(msg);
    }
    
    public void messageRecieved(Message msg) throws InterruptedException
    {
        dequeue();
    }
    
    public void setName(String name)
    {
        if(isValidName(this.name) == true)
        {
             this.name = name;
        }
    }
    
//    public void setPortal(Portal portal)
//    {
//        this.portal = portal;
//    }
    
    public String getName()
    {
        return this.name;
    }
    
    
    public boolean isValidName(String name)
    {
        return true;
    }
}
