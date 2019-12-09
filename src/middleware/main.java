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
    
    public static void main(String args[]) throws InterruptedException{
          
        Portal portal = new Portal("PortalA");
        UserAgent agentI = new UserAgent("I", portal);
        UserAgent agentA = new UserAgent("A", portal);
        UserAgent agentB = new UserAgent("B", portal);
        
        UserMessage msg = new UserMessage("Hello", agentA, agentB);
        
        agentA.sendMessage(msg, "B");
        
        for (MetaAgent ma : portal.map.values())
        {
            System.out.println(ma.name);
        }
    }
}
