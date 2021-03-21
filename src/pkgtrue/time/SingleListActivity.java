/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtrue.time;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
        double windowSize[][] = {{40,75,25,30, 15,100,40}, // Columns
            {75,25,25, 25, 25, 275,25,25, 25, 25}}; // Rows
        window.setLayout(new TableLayout(windowSize));
        
        JButton backButton = new JButton("Back");
        window.add(backButton,"1,1");
        
        JButton addTask = new JButton("Add Task");
        addTask.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new CreateNewTask(listName);
            }
        });
        window.add(addTask,"5,1");
        
        
        JLabel pageTitle = new JLabel(listName + " List", SwingConstants.CENTER);
        pageTitle.setFont(new Font("", Font.PLAIN, 20));
        window.add(pageTitle, "1,3, 5, 3");
        
        JButton timeTask = new JButton("Time Task");
        window.add(timeTask, "1,7, 2, 7");
        
        JButton deleteTask = new JButton("Delete Task");
        window.add(deleteTask, "4,7, 5,7");
        
        JButton plusButton = new JButton("Delete List");
        window.add(plusButton, "1,9, 5, 9");

        window.add(taskScroll,"1,5, 5, 5");
        
        
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    }
