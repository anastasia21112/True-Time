/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtrue.time;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import layout.TableLayout;
import javax.swing.*;

/**
 *
 * @author AnastasiaDunca
 */
public class LoginActivity extends JFrame{
    
    private JButton loginButton = new JButton("LOGIN");
    private JTextField usernameField = new JTextField("");
    private JPasswordField passwordField = new JPasswordField();
    private JLabel usernameLabel = new JLabel("Username: ");
    private JLabel passwordLabel = new JLabel("Password: ");
    private JLabel logoLabel = new JLabel();
    private String username = "";
    private String password = "";
    
    public LoginActivity()
    {
        this.setContentPane(new ImagePanel());
  
        logoLabel.setIcon(new ImageIcon(new ImageIcon("images/logo_part_transparent.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
         double windowSize[][] = {{90, 150, 130, 20}, // Columns
            {80, 250, 10, 10, 20, 30, 10, 10, 20, 30, 20}}; // Rows
        this.setLayout(new TableLayout(windowSize));
        
        this.add(logoLabel, "1, 1");
        this.add(usernameLabel, "1, 2");
        this.add(usernameField, "1, 4");
        this.add(passwordLabel, "1, 6");
        this.add(passwordField, "1, 8");
        this.add(loginButton, "1, 10");
        
        loginButton.addActionListener(new LoginListener());
        
        this.setTitle("Login");
        this.setSize(325, 675);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    public String getUsername() {   return username;    };
    public String getPassword() {   return password;    };
    
    public void closeGUI()
    {
        this.dispose();
    }
    
    class LoginListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            username = usernameField.getText();
            password = passwordField.getText();
            closeGUI();
            new UserDashboard();
        }
        
    }
    
    
}
