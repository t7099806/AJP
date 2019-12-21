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
public class main {
    
    public static void main(String args[]) throws InterruptedException
    {
        Portal p1 = new Portal("p1");
        Portal p2 = new Portal("p2");
        Portal p3 = new Portal("p3");
        UserAgent a1 = new UserAgent("a1");
        UserAgent a2 = new UserAgent("a2");
        UserAgent a3 = new UserAgent("a3");
        Router r = new Router("r");
        
        p1.setRouter(r);
        p2.setRouter(r);
        p3.setRouter(r);
        
        a1.setPortal(p1);
        a2.setPortal(p2);
        a3.setPortal(p3);

        
        
        UserMessage m = new UserMessage("hello1", 1, "a1", "a3");

       
        a1.sendMessage("a3", m);

    }
}
