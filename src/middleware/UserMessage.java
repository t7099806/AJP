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
public class UserMessage extends Message
{

    public UserMessage(String Content, int id, String sender, String recipient) 
    {
        super(Content, id, sender, recipient);
    }

    @Override
    public String wrap() 
    {
        return null;
    }
 
}
