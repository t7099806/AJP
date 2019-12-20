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
        Portal p = new Portal("p1");
        UserAgent a = new UserAgent("a1");
        UserAgent b = new UserAgent("a2");
        
        a.setPortal(p);
        b.setPortal(p);
        
        UserMessage m = new UserMessage("hello1", 1, "a1", "a2");

       
        a.sendMessage("a2", m);

    }
}
