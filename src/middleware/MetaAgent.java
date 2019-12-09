/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author James Fairbairn
 */
public abstract class MetaAgent extends ArrayBlockingQueue<Message> 
        implements Runnable 
{

    private final String name;
    private Thread thread;
    private volatile boolean run;
    Portal portal;

    public MetaAgent(String name, int capacity) 
    {
        super(capacity);
        
        this.name = name;
        this.run = true;
        
        start();
    }
    
    private void start()
    {
        thread = new Thread(this);
        thread.start();
    }
    
    public final void stop()
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
        System.out.println(this.name + ": " + msg.getContent());
    }
    
    public abstract void sendMessage();
    
    public abstract void receiveMessage();
    
    public String getName()
    {
        return this.name;
    }
}
