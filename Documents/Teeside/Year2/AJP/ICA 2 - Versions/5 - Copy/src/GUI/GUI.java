/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import middleware.*;
import static middleware.AgentFactory.agentType.PORTAL;
import static middleware.AgentFactory.agentType.ROUTER;
import static middleware.AgentFactory.agentType.USER;
import static middleware.MessageFactory.messageType.USERMSG;

/**
 *
 * @author 44789
 */
public class GUI extends JPanel implements ActionListener {

    
    //Router JOptionPane that appears at start
    String routerName;
    Router router;
    
    //Panel that will hold all of the router control information buttons etc
    JPanel routerControlPanel;
    
    //Panel to advertise a port
    JPanel advertiseRouter;
    JLabel port;
    JTextField portText;
    JButton portAdvertise;
    
    //buttons to add portal and agent
    JPanel buttonPanel;
   
    //Button to add portal and string to set portal name
    JButton addPortalButton;
    String addPortalPane;

    //Adds agent to specific pportal
    JButton addAgentButton;
    int addAgentPane;
    JPanel addAgentPanel;
    JTextField addAgentText;
    //JComboBox<Portal> portalOptions;
    ArrayList<Portal> portalList;
    ArrayList<UserAgent> agentList;
    JComboBox<String> portalOptions;
    

    //panel for connecting to another router
    JPanel connectRouterP;
    JLabel portNoLabel;
    JTextField portNoText;
    JLabel ipAddLabel;
    JTextField ipAddText;
    JButton connect;
    
    //Tabbed pane for info on the router table, messages and vnodes
    JTabbedPane infoPane;
    JPanel rTablePanel;
    JPanel MSGs;
    JPanel vNodes;
    
    //Monitor for portal Activity
    JPanel portalActivityPanel;
    
    //panel for active agents and portals
    JPanel activePanel;
    
    //panel to hold label saying Active Agents/Portals
    JPanel activePanelTopPanel;
    JLabel activeLabel;
    
    //Panel to hold table with information of portal activity
    JPanel infoPanel;
    JTable portalActivity;
    Object[] columns = {"From", "To", "Message"};
    DefaultTableModel model;
    Object[] row;

    
    
    GUI()
    {
        routerName = JOptionPane.showInputDialog(null,"Router Name:", "Enter a name for the router", JOptionPane.OK_CANCEL_OPTION);
        router = (Router) AgentFactory.createAgent(ROUTER, routerName);
        
        //Panel that will hold all of the router control information buttons etc
        routerControlPanel = new JPanel();
        routerControlPanel.setBorder(BorderFactory.createTitledBorder("Router Control Panel: " + routerName));
        routerControlPanel.setLayout(new BoxLayout(routerControlPanel, BoxLayout.X_AXIS));
        routerControlPanel.setPreferredSize(new Dimension(870,100));
        routerControlPanel.setMaximumSize(new Dimension(870,100));
        routerControlPanel.setVisible(true);
        this.add(routerControlPanel);

        //Panel that will allow the user to advertise the router
        advertiseRouter = new JPanel();
        advertiseRouter.setBorder(BorderFactory.createTitledBorder("Advertise Router"));
        advertiseRouter.setLayout(new BoxLayout(advertiseRouter, BoxLayout.X_AXIS));
        advertiseRouter.setPreferredSize(new Dimension(200,100));
        advertiseRouter.setVisible(true);
        routerControlPanel.add(advertiseRouter);
        
        //Label saying port 
        port = new JLabel("Port:");
        advertiseRouter.add(port);
        
        //Textfield to enter port name
        portText = new JTextField();
        portText.setPreferredSize(new Dimension(70,25));
        portText.setMaximumSize(new Dimension(70,25));
        advertiseRouter.add(portText);
        
        //Button to advertise the port
        portAdvertise = new JButton("Advertise");
        advertiseRouter.add(portAdvertise);
        
        //Panel that will have buttons to add a portal and an agent
        buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Add:"));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setPreferredSize(new Dimension(120,100));
        buttonPanel.setVisible(true);
        routerControlPanel.add(buttonPanel);
        
        //Button to add a portal
        addPortalButton = new JButton("Add Portal");
        addPortalButton.addActionListener(this);
        buttonPanel.add(addPortalButton);
        
        //Button to add a router
        addAgentButton = new JButton("Add Agent");
        addAgentButton.addActionListener(this);
        buttonPanel.add(addAgentButton);
        
        //Will be added to add agent panel
        addAgentText = new JTextField(19);
        portalOptions = new JComboBox<String>();
        portalList = new ArrayList<Portal>();
        agentList = new ArrayList<UserAgent>();
        
        //panel that appears when add agent is clicked, chooses agent name 
        //and which portal the agent will be added to 
        addAgentPanel = new JPanel();
        addAgentPanel.setLayout(new GridLayout(2,2));
        addAgentPanel.add(new JLabel("Agent Name"));
        addAgentPanel.add(addAgentText);
        addAgentPanel.add(new JLabel("Portal"));
        addAgentPanel.add(portalOptions);
        
        
        //Panel for connecting to router
        connectRouterP = new JPanel();
        connectRouterP.setBorder(BorderFactory.createTitledBorder("Connect to Router"));
        connectRouterP.setPreferredSize(new Dimension(550,100));
        connectRouterP.setVisible(true);
        routerControlPanel.add(connectRouterP);
        
        
        //Port number
        portNoLabel = new JLabel("Port No:");
        connectRouterP.add(portNoLabel);
        
        //Text to enter port
        portNoText = new JTextField();
        portNoText.setPreferredSize(new Dimension(70,25));
        portNoText.setMaximumSize(new Dimension(70,25));
        connectRouterP.add(portNoText);
        
        //IP Address
        ipAddLabel = new JLabel("IP Add:");
        connectRouterP.add(ipAddLabel);
        
        //Text field to enter IP address 
        ipAddText = new JTextField();
        ipAddText.setPreferredSize(new Dimension(200,25));
        ipAddText.setMaximumSize(new Dimension(200,25));
        connectRouterP.add(ipAddText);
        
        //Button to connect router
        connect = new JButton("Connect");
        connect.addActionListener(this);
        connectRouterP.add(connect);
        
        //Panels that will be in jtabbedpane to show information        
        rTablePanel = new JPanel();
        MSGs = new JPanel();
        vNodes = new JPanel();
        
        //Infopane that will show info like routing table, messages, and vnodes
        infoPane = new JTabbedPane();
        infoPane.addTab("RTable", rTablePanel);
        infoPane.addTab("MSGs", MSGs);
        infoPane.addTab("VNodes", vNodes);
        infoPane.setPreferredSize(new Dimension(870,200));
        infoPane.setVisible(true);
        this.add(infoPane);
        
        //Panel that will be at bottom half of screen
        portalActivityPanel = new JPanel();
        portalActivityPanel.setBorder(BorderFactory.createTitledBorder("Portal Activity Monitor: " + routerName));
        portalActivityPanel.setLayout(new BoxLayout(portalActivityPanel, BoxLayout.X_AXIS));
        portalActivityPanel.setPreferredSize(new Dimension(870, 500));
        portalActivityPanel.setMaximumSize(new Dimension(870, 500));
        portalActivityPanel.setVisible(true);
        this.add(portalActivityPanel);
        
        //will show active agents and portals
        activePanel = new JPanel();
        activePanel.setBorder(BorderFactory.createTitledBorder(""));
        activePanel.setLayout(new BoxLayout(activePanel, BoxLayout.Y_AXIS));
        activePanel.setPreferredSize(new Dimension(300, 480));
        activePanel.setMaximumSize(new Dimension(300, 480));
        activePanel.setVisible(true);
        portalActivityPanel.add(activePanel);
        
        //Panel will have title of active agents/portals
        activePanelTopPanel = new JPanel();
        activePanelTopPanel.setBorder(BorderFactory.createTitledBorder(""));
        activePanelTopPanel.setLayout(new GridBagLayout());
        activePanelTopPanel.setPreferredSize(new Dimension(300, 30));
        activePanelTopPanel.setMaximumSize(new Dimension(300, 30));
        activePanelTopPanel.setVisible(true);
        activePanel.add(activePanelTopPanel);
        
        activeLabel = new JLabel("Active Agents/Portals");
        activePanelTopPanel.add(activeLabel);
        
        
        infoPanel = new JPanel();
        infoPanel.setBorder(BorderFactory.createTitledBorder(""));
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setPreferredSize(new Dimension(500, 480));
        infoPanel.setMaximumSize(new Dimension(500, 480));
        infoPanel.setVisible(true);
        portalActivityPanel.add(infoPanel);
        
        
        // Data to be displayed in the JTable 
        String[][] data = { 
            { "Kundan Kumar Jha", "4031", "CSE" }, 
            { "Anand Jha", "6014", "IT" } 
        }; 
  
        //JTable will hold information of who has sent message and to who, as well as the message itself
        portalActivity = new JTable();
        
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        
        portalActivity.setModel(model);
        portalActivity.setBounds(80,80,600,600);
        portalActivityPanel.add(new JScrollPane(portalActivity));
        row = new Object[3];
        
//        from = new JTextField();
//        from.setBounds(20, 100, 100, 25);
//        to = new JTextField();
//        to.setBounds(20, 130, 100, 25);
//        message = new JTextField();
//        message.setBounds(20, 160, 100, 25);
        
        
       
    }
    
    /**
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e)
    {
        //If add portal button is clicked, adds a portal to the router
        if(e.getSource() == addPortalButton)
        {
            addPortalPane = JOptionPane.showInputDialog(null, "Portal Name:", "Create a new portal",  JOptionPane.OK_CANCEL_OPTION);
            Portal port = (Portal) AgentFactory.createAgent(PORTAL, addPortalPane);
            port.setRouter(router);
            //adds portal to the portal list
            portalList.add(port);
            //adds portal name to the dropdown menu
            portalOptions.addItem(addPortalPane);
           
        }
        else if(e.getSource() == addAgentButton)
        {
            addAgentPane = JOptionPane.showConfirmDialog(null, addAgentPanel, "Create a new agent", JOptionPane.OK_CANCEL_OPTION);
            if(addAgentPane == JOptionPane.OK_OPTION)
            {
                UserAgent agent = (UserAgent) AgentFactory.createAgent(USER, addAgentText.getText());
                agentList.add(agent);
                String portalName = portalOptions.getSelectedItem().toString();
                for(int i = 0; i <= portalList.size()-1; i++)
                {
                    if(portalName == portalList.get(i).getName())
                    {
                        agent.setPortal(portalList.get(i));
                        break;
                    }
                }
                
                AgentPanel(agent);
                
            }
            
            
            
        }
    }
    
    public void AgentPanel(UserAgent agentI)
    {
        JFrame agentFrame  = new JFrame();
        agentFrame.setSize(600,300);
        agentFrame.setTitle(agentI.getName());
        agentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        agentFrame.setResizable(true);
        agentFrame.setVisible(true);

        JPanel agentPanel = new JPanel();
        agentPanel.setLayout(new BoxLayout(agentPanel, BoxLayout.Y_AXIS));
        agentPanel.setPreferredSize(new Dimension (600,300));
        agentPanel.setVisible(true);
        agentFrame.add(agentPanel);


        String[][] dataTable ={ {"Hello" ,"Good Day"},
                {"hI", "A"}};
        String[] messageColumn = {"Message" , "Agent"}; 
        JTable agentTable = new JTable(dataTable, messageColumn);
        agentTable.setBounds(29, 30, 100, 200);
        agentPanel.add(new JScrollPane(agentTable));

        JPanel sendMessagePanel = new JPanel();
        sendMessagePanel.setLayout(new GridLayout(3,2));
        sendMessagePanel.setPreferredSize(new Dimension (600, 100));
        sendMessagePanel.setVisible(true);
        agentPanel.add(sendMessagePanel);

        //Label saying agent 
        JLabel agentL = new JLabel("Agent");
        sendMessagePanel.add(agentL);

        //Textfield to enter agent to send message to
        JTextField agentT = new JTextField(100);
        sendMessagePanel.add(agentT);
        
        //Label saying message
        JLabel messageL = new JLabel("Message");
        sendMessagePanel.add(messageL);

        //Textfield to enter message to send to agent
        JTextField messageT = new JTextField(100);
        sendMessagePanel.add(messageT);

        JButton clear = new JButton("Clear");
        clear.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        agentT.setText("");
                        messageT.setText("");
                    }

                });
        sendMessagePanel.add(clear);

        JButton send = new JButton("Send");
        send.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if(agentExists(agentT.getText()) == true) 
                        {
                            UserMessage m = (UserMessage) MessageFactory.createMessage(USERMSG, messageT.getText(), 1, agentI.getName(), agentT.getText());
                            agentI.sendMessage(m);
                            row[0] = agentI.getName();
                            row[1] = agentT.getText();
                            row[2] = messageT.getText();
                            model.addRow(row); 
                        }
   
                    }
                });
        sendMessagePanel.add(send);
    }
    
   public boolean agentExists(String agentName)
   {
       for(int i = 0; i <= agentList.size()-1; i++)
       {
           System.out.println(agentList.get(i).getName());
           System.out.println("Break");
           if(agentList.get(i).getName() == agentName)
           {
               return true;
           }
       }
       System.out.println("You should work");
       return false;
   }
    
    
    
}
