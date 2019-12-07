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
public class UserMessage extends Message{
    
    public UserMessage(String rawMessage, int id, String sender, String recipient, int idAutoIncrement) {
        super(rawMessage, id, sender, recipient, idAutoIncrement);
    }
    
    public String wrap()
    {
        return null;
    }
    
}
