/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtrue.time;
import java.util.*;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author daphn
 */
public class ListOfLists 
{
    public static JFrame window;
    public static JPanel backgroundPanel;
    public static JPanel mainPanel;
    public static JPanel listPanel;
    
    public ListOfLists()
    {
        window = new JFrame();
        window.setTitle("True Time");
        window.setSize(650, 1400);
        window.setResizable(false);
        window.setContentPane(new ImagePanel());
        
        mainPanel = new JPanel(new BorderLayout());
        JLabel pageTitle = new JLabel("Anastasia's Lists");
        JButton backButton = new JButton("Back");
        listPanel = new JPanel(new GridLayout(10, 1));
        JButton plusButton = new JButton("+");
        
        mainPanel.add(backButton, BorderLayout.NORTH);
        mainPanel.add(pageTitle);
        mainPanel.add(plusButton);
        mainPanel.add(listPanel);
        
        
        
        
        
        window.add(mainPanel);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
