/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;

import java.util.TreeMap;

/**
 *
 * @author Karl
 */
public class Router extends MetaAgent
{
    TreeMap<String, MetaAgent> map = new TreeMap<>();

    public Router(String name) 
    {
        super(name);
    }

    @Override
    public void sendMessage(String recipient, Message msg) 
    {

    }

    @Override
    public void receiveMessage(Message msg) 
    {

    }
    
}
