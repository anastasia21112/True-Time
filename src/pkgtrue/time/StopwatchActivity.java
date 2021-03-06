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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import layout.TableLayout;

/**
 *
 * @author fifiteklemedhin
 */
public class StopwatchActivity extends JFrame 
{
    private static Clock clock;
    private boolean buttonClicked;
    private boolean buttonGainFocus;
    private static long stopwatchStartTime;
    
    private boolean stopwatchRunning;
    private boolean shutdown;
    
    public static JFrame window;
    public static JPanel backgroundPanel;
    public static JPanel mainPanel;
    public static JPanel listPanel;
    public static JPanel placeHolder = new JPanel();
    
    public static JLabel timeLabel;
    public static JButton backButton;
    public static JButton startButton;
    public static JButton stopButton;
    public static JButton resetButton;
    public static JButton saveButton;
    
    public static Stopwatch stopwatchThread;
        
    public boolean timerOn = false;
    
    public static MasterTaskManager masterManager = new MasterTaskManager();
    public static ListManager manager = new ListManager();
    
    public StopwatchActivity(String taskName, String listName)
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
        
        backButton = new JButton("Back");
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
        
        stopwatchThread = new Stopwatch(this);
        setShutdown(false);
        
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        
        startButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                stopwatchThread = newStopwatch(newStopwatch(stopwatchThread));
                setStopwatchRunning(true);
                stopwatchThread.startThread();
                stopwatchStartTime = System.currentTimeMillis();
                
            }
        });
        
        stopButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setStopwatchRunning(false);
                stopwatchThread.stopThread();
                
            }
        });
        
        resetButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                timeLabel.setText("00 : 00 : 00");
            }
        });
        
        backButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setShutdown(true);
                
            }
        });
        
        saveButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setShutdown(true);
                String elapsedTime = timeLabel.getText();
                
                int indexComma1 = elapsedTime.indexOf(":");
                int indexComma2 = elapsedTime.indexOf(":", indexComma1 + 1);
                
                String hour = elapsedTime.substring(0, indexComma1);
                String minute = elapsedTime.substring(indexComma1 + 2, indexComma2 - 1);
                String second = elapsedTime.substring(indexComma2 + 2);
                
                double hourMinute = Double.parseDouble(hour) * 60;
                double secondMinute = (Double.parseDouble(second) / 60);
                
                double taskTime = hourMinute + Double.parseDouble(minute) + secondMinute;

                
                
                
                //add to master map get name from the label at the top with task name

                masterManager.addMasterTask(taskName, taskTime);
                manager.updateTask(listName, taskName);
                window.dispose();
                new SingleListActivity(listName);

         }
        });
                
    }
    
    private String formatTime(long s)
    {
        if(s < 10)
            return "0" + s;
        return s + "";
    }
    
    public void updateStopwatchTime()
    {
        ArrayList<Integer> elapsedTime = stopwatchThread.getTime();
        String time = formatTime(elapsedTime.get(0)) + " : " + formatTime(elapsedTime.get(1)) + " : " + formatTime(elapsedTime.get(2));
        
        timeLabel.setText(time);
        timeLabel.paintImmediately(timeLabel.getVisibleRect());

        
    }

    public boolean isShutdown() {
        return shutdown;
    }

    public void setShutdown(boolean shutdown) {
        this.shutdown = shutdown;
    }

    public boolean isStopwatchRunning() {
        return stopwatchRunning;
    }

    public void setStopwatchRunning(boolean stopwatchRunning) {
        this.stopwatchRunning = stopwatchRunning;
    }
    
    public Stopwatch newStopwatch(Stopwatch previousWatch)
    {
        return new Stopwatch(this, previousWatch.getStartTime());
    }
    
        
        
   
    
}

