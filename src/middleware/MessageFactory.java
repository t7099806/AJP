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
public class MessageFactory {
    
    protected enum messageType
    {
        USERMSG, SYSTEM;
    }
    
    public static Message createMessage(MessageFactory.messageType mt, 
            String content, int id, String sender, String recipient)
    {
        Message msg = null;
        switch(mt)
        {
            case USERMSG: msg = new UserMessage(content, id, sender, recipient);
                break;
            case SYSTEM: msg = new SystemMessage(content, id, sender, recipient);
                break;
        }
        return msg;
    }
}
