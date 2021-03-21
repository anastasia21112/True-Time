/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtrue.time;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import layout.TableLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author daphneliu
 */
public class UserDashboard {
    public static JFrame window;
    public static JLabel logoLabel;
    public static JLabel introLabel;
    public static JLabel dayLabel;
    public static JButton helpButton;
    public static JButton viewListButton;
    public static JButton logoutButton;
    
    public UserDashboard()
    {
        window = new JFrame();
        window.setTitle("True Time");
        window.setSize(325, 675);
        window.setResizable(false);
        window.setContentPane(new ImagePanel());

        double windowSize[][] = {{50, 225, 50}, // Columns
        {75, 250, 50,75, 25, 30, 30, 30, 20, 20}}; // Rows
        window.setLayout(new TableLayout(windowSize));
        
        ImageIcon icon = new ImageIcon(new ImageIcon("images/logo_part_transparent.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        logoLabel = new JLabel(icon, JLabel.CENTER);
        window.add(logoLabel, "1, 1");

        introLabel = new JLabel("<html>Hello, Anastasia!<br/> Welcome to your dashboard. </html>", SwingConstants.LEFT);
        introLabel.setFont(new Font("", Font.PLAIN, 15));
        introLabel.setForeground(Color.WHITE);
        window.add(introLabel, "1, 2");
        
        dayLabel = new JLabel("<html>This is your Day 1 of using True Time. Keep it up!</html>");
        dayLabel.setFont(new Font("", Font.PLAIN, 15));
        dayLabel.setForeground(Color.WHITE);
        window.add(dayLabel, "1, 3");
        
        viewListButton = new JButton("View To Do Lists");
        viewListButton.addActionListener(new ListListener());
        window.add(viewListButton, "1, 5");
        
        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new LogoutListener());
        window.add(logoutButton, "1, 7");
        
        helpButton = new JButton("Get Help");
        window.add(helpButton, "1, 6");

        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void closeGUI()
    {
        window.dispose();
    }
    
    class LogoutListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            closeGUI();
            new LoginActivity();
        }
    }
    class ListListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            closeGUI();
            new ListOfLists();
        }
        
    }
    
}
