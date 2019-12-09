/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;

/**
 *
 * @author James Fairbairn
 */
public abstract class Message 
{
    private String content;
    private int id;
    private String sender;
    private String recipient;
    

    public Message(String Content, int id, String sender, String recipient) 
    {
        this.content = Content;
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
    }
    
    public String getContent() 
    {
        return content;
    }

    public void setContent(String Content) 
    {
        this.content = Content;
    }
    
    public abstract String wrap();
}
