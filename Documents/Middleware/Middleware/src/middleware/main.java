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
    
    public static void main(String args[]){
        
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
        

        UserAgent agentI = new UserAgent();
        String userName = "jim";
        agentI.setName(userName);
        
        
        UserAgent agentA = new UserAgent();
        String userNameA = "John";
        agentA.setName(userNameA);
        
        Portal portal = new Portal();
        portal.addAgent(userName, agentI);
        portal.addAgent(userNameA, agentA);
        
        String rawMessageA = "Hello";
        int idA = 1;
        String senderA = "John";
        String recipientA = "jim";
        
        Message msg = new Message(rawMessageA, idA, senderA, recipientA);
        
    }
}
