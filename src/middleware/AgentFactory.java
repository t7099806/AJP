/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;

/**
 *
 * @author Karl
 */
public class AgentFactory {
    
    protected enum agentType
    {
        USER, PORTAL, ROUTER;
    }
    
    public static MetaAgent createAgent(agentType at, String s)
    {
        MetaAgent ma = null;
        switch(at)
        {
            case USER: ma = new UserAgent(s);
                break;
            case PORTAL: ma = new Portal(s);
                break;
            case ROUTER: ma = new Router(s);
                break;
        }
        return ma;
    }
    
}
