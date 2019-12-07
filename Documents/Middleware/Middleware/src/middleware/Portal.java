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
public class Portal extends MetaAgent{
    
    HashMap<String, MetaAgent> map;
    
    public Portal(Portal portal, HashMap map) {
        super(portal);
        map = new HashMap<String, MetaAgent>();
    }
    
    public void addAgent(String name, MetaAgent agent)
    {
        map.put(name, agent);
    }
    
    public void removeAgent(String name)
    {
        map.remove(name);
    }
    
    
}
