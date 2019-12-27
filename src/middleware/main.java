/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;

import static middleware.AgentFactory.agentType.PORTAL;
import static middleware.AgentFactory.agentType.ROUTER;
import static middleware.AgentFactory.agentType.USER;
import static middleware.MessageFactory.messageType.USERMSG;

/**
 *
 * @author 44789
 */
public class main {
    
    public static void main(String args[]) throws InterruptedException
    {
        Portal p1 = (Portal) AgentFactory.createAgent(PORTAL, "p1");
        Portal p2 = (Portal) AgentFactory.createAgent(PORTAL, "p2");
        Portal p3 = (Portal) AgentFactory.createAgent(PORTAL, "p3");
        UserAgent a1 = (UserAgent) AgentFactory.createAgent(USER, "a1");
        UserAgent a2 = (UserAgent) AgentFactory.createAgent(USER, "a2");
        UserAgent a3 = (UserAgent) AgentFactory.createAgent(USER, "a3");
        Router r = (Router) AgentFactory.createAgent(ROUTER, "r");
        
        p1.setRouter(r);
        p2.setRouter(r);
        p3.setRouter(r);
        
        a1.setPortal(p1);
        a2.setPortal(p2);
        a3.setPortal(p3);

        UserMessage m = (UserMessage) MessageFactory.createMessage(USERMSG, "hello1", 1, "a1", "a3");

        a1.sendMessage("a3", m);

    }
}
