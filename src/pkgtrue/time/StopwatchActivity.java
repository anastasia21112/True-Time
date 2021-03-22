/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtrue.time;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import layout.TableLayout;

/**
 *
 * @author fifiteklemedhin
 */
public class StopwatchActivity extends JFrame 
{
    private static Clock clock;
    
    public static JFrame window;
    public static JPanel backgroundPanel;
    public static JPanel mainPanel;
    public static JPanel listPanel;
    public static JPanel placeHolder = new JPanel();
    
    public static JLabel timeLabel;
    public static JButton startButton;
    public static JButton stopButton;
    public static JButton resetButton;
    public static JButton saveButton;
        
    public boolean timerOn = false;
    
    public StopwatchActivity(String taskName)
    {
        clock = Clock.systemDefaultZone();
        window = new JFrame();
        window.setTitle("True Time");
        window.setSize(325, 675);
        window.setResizable(false);
        window.setContentPane(new ImagePanel());
        
        double windowSize[][] = {{20,50,25,150,50,20}, // Columns
            {85, 25, 1, 75,1, 50, 25,50,25, 50, 25,50, 25,50}}; // Rows
        window.setLayout(new TableLayout(windowSize));
        
        JButton backButton = new JButton("Back");
        window.add(backButton,"1, 1,2,1");
        
        JLabel taskNameLabel = new JLabel("Timing Task: " + taskName);
        taskNameLabel.setFont(new Font("", Font.PLAIN, 20));
        window.add(taskNameLabel, "1,3,4,3");
        
        timeLabel = new JLabel("00 : 00 : 00");
        timeLabel.setFont(new Font("Arial Bold", Font.ITALIC, 35));
        window.add(timeLabel,"2, 5, 4,5");
        
        startButton = new JButton("START");
        window.add(startButton,"2, 7, 3, 7");
        stopButton = new JButton("STOP");
        window.add(stopButton,"2, 9, 3, 9");
        resetButton = new JButton("RESET");
        window.add(resetButton,"2, 11, 3, 11");
        saveButton = new JButton("SAVE TIME");
        window.add(saveButton,"2, 13, 3, 13");
        
        
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        stopButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                stopButton.getModel().setPressed(true);
                timerOn = false; 
                System.out.println("pressed");
                
            }
        });
        
        resetButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                timerOn = false; 
                timeLabel.setText("00 : 00 : 00");
            }
        });
        startButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                long startTime = System.currentTimeMillis();//gets time in miliseconds
                stopButton.getModel().setPressed(false);
                while(!stopButton.getModel().isPressed())
                {
                       
                       long elapsedTime = System.currentTimeMillis() - startTime;
                       long elapsedSeconds = elapsedTime / 1000;
                       long elapsedMinutes = elapsedSeconds / 60;
                       long elapsedHours = elapsedMinutes / 60;


                       timeLabel.setText(formatTime(elapsedHours) + " : " + formatTime(elapsedMinutes) + " : " + formatTime(elapsedSeconds));

                       timeLabel.paintImmediately(timeLabel.getVisibleRect());
                       //System.out.println(elapsedHours + " : " + elapsedMinutes + " : " + elapsedSeconds);
                }

            }
        });
        
        
      
        
    }
    
    String formatTime(long s)
    {
        if(s < 10)
            return "0" + s;
        return s + "";
    }
    
 
   
    
}
