/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import middleware.MessageFactory;
import static middleware.MessageFactory.messageType.USERMSG;
import middleware.UserAgent;
import middleware.UserMessage;

/**
 *
 * @author 44789
 */
public class AgentPanel extends JPanel{
    
    String panelName;
    UserAgent agent;
    ArrayList<UserAgent> agentList;
    ArrayList<AgentPanel> apList;
    
    
    JFrame agentFrame;
    JPanel agentPanel;
    
    String[][] dataTable ={ {"Hello" ,"Good Day"},
                {"hI", "A"}};
    String[] messageColumn = {"Message" , "Agent"}; 
    JTable agentTable;
    
    JPanel sendMessagePanel;
       
    JLabel agentL;
    JTextField agentT;
    JLabel messageL;
    JTextField messageT;
    
    JButton clear;
    JButton send;
    
    AgentPanel(String panelName, UserAgent agent, ArrayList<UserAgent> agentList)
    {   
        this.panelName = panelName;
        this.agent = agent;
        this.agentList = agentList;
        apList = new ArrayList<AgentPanel>();
                
        agentFrame = new JFrame("AgentPanel"); 
        agentFrame.setSize(600,300);
        agentFrame.setTitle(agent.getName());
        agentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        agentFrame.setResizable(true);
        agentFrame.setVisible(true);
        
        agentPanel = new JPanel();
        agentPanel.setLayout(new BoxLayout(agentPanel, BoxLayout.Y_AXIS));
        agentPanel.setPreferredSize(new Dimension (600,300));
        agentPanel.setVisible(true);
        agentFrame.add(agentPanel);
        
        agentTable = new JTable(dataTable, messageColumn);
        agentTable.setBounds(29, 30, 100, 200);
        agentPanel.add(new JScrollPane(agentTable));
        
        sendMessagePanel = new JPanel();
        sendMessagePanel.setLayout(new GridLayout(3,2));
        sendMessagePanel.setPreferredSize(new Dimension (600, 100));
        sendMessagePanel.setVisible(true);
        agentPanel.add(sendMessagePanel);
        
        //Label saying agent 
        agentL = new JLabel("Agent");
        sendMessagePanel.add(agentL);
        //Textfield to enter agent to send message to
        agentT = new JTextField(100);
        sendMessagePanel.add(agentT);
        //Label saying message
        messageL = new JLabel("Message");
        sendMessagePanel.add(messageL);
        //Textfield to enter message to send to agent
        messageT = new JTextField(100);
        sendMessagePanel.add(messageT);
        
        clear = new JButton("Clear");
        clear.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        agentT.setText("");
                        messageT.setText("");
                    }

                });
        sendMessagePanel.add(clear);
        
        send = new JButton("Send");
        send.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        UserMessage m = (UserMessage) MessageFactory.createMessage(USERMSG, messageT.getText(), 1, agent.getName(), agentT.getText());
                        agent.sendMessage(m);
                       // sentMessage();
                        
//                        for(int i = 0; i <= agentList.size()-1; i++)
//                        {
//                            if(agentT.getText() == agentList.get(i).getName())
//                            {
//                                for(int j = 0; j <= apList.size()-1; j++)
//                                {
//                                    if(agentT.getText() == apList.get(j).getAgentName())
//                                    {
//                                        apList.get(j).sentMessage();
//                                    }
//                                }
//                            }
//                        }
                    }
                });
        
        sendMessagePanel.add(send);
    }
    
    
    public void sentMessage()
    {
        messageT.setText("It is a step in good");
    }
    
    public void setapList(ArrayList<AgentPanel> ap)
    {
        apList = ap;
    }
    
    public void setAgentList(ArrayList<UserAgent> agentI)
    {
        agentList = agentI;
    }
    
    public String getAgentName()
    {
        return panelName;
    }


}
