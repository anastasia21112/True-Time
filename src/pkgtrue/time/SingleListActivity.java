/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtrue.time;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import layout.TableLayout;

/**
 *
 * @author angel
 */
public class SingleListActivity {
    
    public static JFrame window;
    public static JPanel backgroundPanel;
    public static JScrollPane taskScroll;
    public static JPanel taskPanel;
    
    public SingleListActivity(String listName)
    {
        taskPanel = new JPanel();
        taskScroll = new JScrollPane(taskPanel);
        
        window = new JFrame();
        window.setTitle("True Time");
        window.setSize(325, 675);
        window.setResizable(false);
        window.setContentPane(new ImagePanel());
        
        double windowSize[][] = {{40,75,25,45,100,40}, // Columns
            {75,25,25, 25, 25, 325, 25, 25}}; // Rows
        window.setLayout(new TableLayout(windowSize));
        
        JButton backButton = new JButton("Back");
        window.add(backButton,"1,1");
        
        JButton addTask = new JButton("Add Task");
        window.add(addTask,"4,1");
        
        JLabel pageTitle = new JLabel(listName + " List", SwingConstants.CENTER);
        pageTitle.setFont(new Font("", Font.PLAIN, 20));
        window.add(pageTitle, "1,3, 4, 3");
        
        JButton plusButton = new JButton("Delete List");
        window.add(plusButton, "1,7, 4, 7");

        window.add(taskScroll,"1,5, 4, 5");
        
        
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
