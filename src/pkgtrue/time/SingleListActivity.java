/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtrue.time;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
    public static ButtonGroup taskGroup = new ButtonGroup();
    
    public static JLabel totalTime = new JLabel("Total Time: 0");
    public static ListManager manager = new ListManager();
    
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
            {75,25,25, 25, 25, 275,25,25, 25, 25, 20, 25}}; // Rows
        window.setLayout(new TableLayout(windowSize));
        
        JButton backButton = new JButton("Back");
        window.add(backButton,"1,1");
        backButton.addActionListener(new BackListener());
        
        window.add(totalTime, "1, 4, 5");
        totalTime.setText("Total Time: " + manager.getTotalTime(listName));
        JButton addTask = new JButton("Add Task");
        addTask.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                closeGUI();
                new CreateNewTask(listName);
            }
        });
        window.add(addTask,"5,1");
        
        
        JLabel pageTitle = new JLabel(listName + " List", SwingConstants.CENTER);
        pageTitle.setFont(new Font("", Font.PLAIN, 20));
        window.add(pageTitle, "1,3, 5, 3");
        
        JButton timeTask = new JButton("Time Task");
        timeTask.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                closeGUI();
                new StopwatchActivity();
            }
        });
        window.add(timeTask, "1,7, 2, 7");
        
        JButton deleteTask = new JButton("Delete Task");
        window.add(deleteTask, "4,7, 5,7");
        
        JButton plusButton = new JButton("Delete List");
        window.add(plusButton, "1,9, 5, 9");

        window.add(taskScroll,"1,5, 5, 5");
        
        taskPanel.removeAll();
        displayContents(manager.returnContents(listName));
        taskScroll.validate();
        taskScroll.repaint();
        
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void displayContents(ArrayList<String> contents)
    {
        if(!contents.isEmpty())
        {
            
            for(int i = 0; i < contents.size(); i++)
            {
                taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));

                String taskInfo = contents.get(i);
                JRadioButton taskButton = new JRadioButton(taskInfo);
                taskButton.setActionCommand(taskInfo);
                taskButton.setAlignmentX(Component.LEFT_ALIGNMENT);

                taskGroup.add(taskButton);         
                taskPanel.add(taskButton);

                taskPanel.add(Box.createRigidArea(new Dimension(0, 5)));

            }
        }
    }
    
    public void closeGUI()
    {
        window.dispose();
    }

    private class BackListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            closeGUI();
            new ListOfLists();
            
        }
       
    }

}
