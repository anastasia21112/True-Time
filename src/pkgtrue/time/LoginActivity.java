/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtrue.time;

import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author AnastasiaDunca
 */
public class LoginActivity extends JFrame{
    
    private JButton loginButton = new JButton("LOGIN");
    private JTextField usernameField = new JTextField("USERNAME");
    private JTextField passwordField = new JTextField("PASSWORD");
    
    public LoginActivity()
    {
        this.setContentPane(new ImagePanel());
        JPanel loginPanel = new JPanel();
   
        loginPanel.setLayout(new TableLayout());
        loginPanel.setSize(10, 30);
        
        loginPanel.add(usernameField, BorderLayout.NORTH);
        loginPanel.add(passwordField, BorderLayout.CENTER);
        loginPanel.add(loginButton, BorderLayout.SOUTH);
        
        loginPanel.setVisible(true);
        this.setLayout(new BorderLayout());
        this.add(loginPanel, BorderLayout.SOUTH);
        
        this.setTitle("Login");
        this.setSize(300, 500);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    
    
}
