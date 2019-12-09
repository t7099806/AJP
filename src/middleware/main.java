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
        
//                
//        //Creating the agent 
//        MetaAgent agent = new MetaAgent();
//        String name = "jack";
//        agent.setName(name);
//        
//        //Creating the second agent
//        MetaAgent agent2 = new MetaAgent();
//        String name2 = "John";
//        agent.setName(name2);
//        
 
//        //creating the portal
//        Portal portal = new Portal();
//        //adding the agent to the portal
//        portal.addAgent(name, agent);
//        portal.addAgent(name2, agent2);
//        
        Portal portal = new Portal("PortalA");
        UserAgent agentI = new UserAgent("I", portal);
        UserAgent agentA = new UserAgent("A", portal);
        
        portal.addAgent("I", agentI);
        portal.addAgent("A", agentA);

        String rawMessageA = "Hello";
        String senderA = "John";
        String recipientA = "jim";
        
        UserMessage msg = new UserMessage("Hello", agentA, agentI);
        
        agentA.sendMessage(msg, "I");
        
    }
}
