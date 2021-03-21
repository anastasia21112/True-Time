/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtrue.time;

import java.awt.BorderLayout;
import java.awt.Font;
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
    public static JFrame window;
    public static JPanel backgroundPanel;
    public static JPanel mainPanel;
    public static JPanel listPanel;
    public static JPanel placeHolder = new JPanel();
    
    public StopwatchActivity()
    {
        window = new JFrame();
        window.setTitle("True Time");
        window.setSize(325, 675);
        window.setResizable(false);
        window.setContentPane(new ImagePanel());
        
        double windowSize[][] = {{20,45,200}, // Columns
            {85, 45, 40, 100, 75, 75, 75}}; // Rows
        window.setLayout(new TableLayout(windowSize));
        
        JButton backButton = new JButton("Back");
        window.add(backButton,"1, 1");
        
        JLabel pageTitle = new JLabel("00 : 00 : 00");
        pageTitle.setFont(new Font("Arial Bold", Font.ITALIC, 35));
        window.add(pageTitle,"2, 3");
        
        JButton startButton = new JButton("START");
        window.add(startButton,"2, 4");
        JButton stopButton = new JButton("STOP");
        window.add(stopButton,"2, 5");
        JButton resetButton = new JButton("RESET");
        window.add(resetButton,"2, 6");
        
        
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    
}
