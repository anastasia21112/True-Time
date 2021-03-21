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

/**
 *
 * @author daphneliu
 */
public class CreateNewTask {
    public static JFrame window;
    public static JPanel backgroundPanel;
    public static JPanel mainPanel;
    public static JPanel listPanel;
    public static JPanel placeHolder = new JPanel();
    
    public CreateNewTask(){
        window = new JFrame();
        window.setTitle("True Time");
        window.setSize(325, 675);
        window.setResizable(false);
        window.setContentPane(new ImagePanel());
        
        double windowSize[][] = {{50, 100, 75, 50}, // Columns
            {100, 25, 25, 25, 25, 25, 25, 250, 25}}; // Rows
        window.setLayout(new TableLayout(windowSize));
        
        JLabel pageTitle = new JLabel("Create a New Task", SwingConstants.CENTER);
        pageTitle.setFont(new Font("", Font.PLAIN, 20));
        window.add(pageTitle, "1, 1, 3");
        
        JLabel nameLabel = new JLabel("Name of Task: ");
        JTextField name = new JTextField("Name");
        window.add(nameLabel, "1, 3, 3");
        window.add(name, "2, 3, 3");
        
        JLabel durationLabel = new JLabel("<html>Estimated Time <br/>to Complete <br/> in Minutes: </html>");
        JTextField duration = new JTextField("Duration");
        window.add(durationLabel, "1, 5, 3, 6");
        window.add(duration, "2, 6, 3, 5");
        
        JButton plusButton = new JButton("Create Task");
        window.add(plusButton, "1, 8, 3");

        
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
