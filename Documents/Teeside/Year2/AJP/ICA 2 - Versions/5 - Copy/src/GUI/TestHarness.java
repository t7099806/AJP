/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JFrame;

/**
 *
 * @author 44789
 */
public class TestHarness {
    
     public static void main(String args[]) throws InterruptedException
    {
        JFrame app = new JFrame("Jframe App");
        app.setSize(900,800);
        String title = ("Middleware");
        app.setTitle(title);
        GUI panel = new GUI();
        app.add(panel);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setResizable(true);
        app.setVisible(true);

    }
    
}