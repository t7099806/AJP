/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;

import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author 44789
 */
public class ArrayListBlockingQueue extends LinkedBlockingQueue<Message> {
    
    LinkedBlockingQueue<Message> queue;
    
    public ArrayListBlockingQueue()
    {
        queue = new LinkedBlockingQueue();
    }
    
    public void enqueue(Message msg) throws InterruptedException
    {
        queue.put(msg);
    }
    
    public void dequeue() throws InterruptedException
    {
        queue.take();
    }
    
}
