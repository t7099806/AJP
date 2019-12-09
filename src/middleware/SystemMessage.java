/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;

/**
 *
 * @author 44789
 */
public class SystemMessage extends Message{
    
    public SystemMessage(String rawMessage, int id, String sender, String recipient) {
        super(rawMessage, sender, recipient);
    }
    
    @Override
    public String wrap()
    {
        return null;
    }
    
}
