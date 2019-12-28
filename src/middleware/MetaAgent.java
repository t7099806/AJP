/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author James Fairbairn
 */
public abstract class MetaAgent extends LinkedBlockingQueue<Message> 
        implements Runnable 
{

    public final String name;
    protected Thread thread;
    protected volatile boolean run;
    Portal portal;
            
    public MetaAgent(String name) 
    {   
        this.name = name;
        this.run = true;
        
        start();
    }
    
    protected void start()
    {
        thread = new Thread(this);
        thread.start();
    }
    
    public void stop()
    {
        try 
        {
            run = false;
            thread.interrupt();
            thread.join();
        } 
        catch (InterruptedException ex) 
        {
            Logger.getLogger(MetaAgent.class.getName())
                .log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() 
    {
        while(run)
        {
            try 
            {
                msgHandler(this.take());
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(MetaAgent.class.getName())
                   .log(Level.INFO, null, ex);
            }
        }
    }
    
    public void msgHandler(Message msg)
    {
        System.out.println("To " + this.name + ": " + msg.getContent() + "\nFrom: " + msg.sender);
    }
    
    public abstract void sendMessage(Message msg);
    
    public abstract void receiveMessage(Message msg);
    
    public String getName()
    {
        return this.name;
    }
    public void setPortal(Portal p)
    {
        portal = p;
        portal.map.put(name, this);
        portal.router.map.put(name, portal);
    }
}
