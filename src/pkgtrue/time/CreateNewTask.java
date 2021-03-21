
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
public class CreateNewTask {
    public static JFrame window;
    public static JPanel backgroundPanel;
    public static JPanel mainPanel;
    public static JPanel listPanel;
    public static JPanel placeHolder = new JPanel();
    public static JTextField name;
    public static JTextField duration;
    public static JLabel listTitle;
    
    public static ListManager manager = new ListManager();
    public static MasterTaskManager masterManager = new MasterTaskManager();
    
    public CreateNewTask(String listName){
        window = new JFrame();
        window.setTitle("True Time");
        window.setSize(325, 675);
        window.setResizable(false);
        window.setContentPane(new ImagePanel());
        
        double windowSize[][] = {{50, 100, 75, 50}, // Columns
            {100, 25, 25, 25, 25, 25, 25, 25, 200, 25}}; // Rows
        window.setLayout(new TableLayout(windowSize));
        
        JLabel pageTitle = new JLabel("Create a New Task", SwingConstants.LEFT);
        pageTitle.setFont(new Font("", Font.PLAIN, 20));
        window.add(pageTitle, "1, 1, 2, 1");
        
        listTitle = new JLabel("For List: " + listName, SwingConstants.LEFT);
        listTitle.setFont(new Font("", Font.PLAIN, 20));
        window.add(listTitle, "1, 2, 2, 2");
        
        JLabel nameLabel = new JLabel("Name of Task: ");
        name = new JTextField();
        window.add(nameLabel, "1, 4, 3");
        window.add(name, "2, 4, 3");
        
        JLabel durationLabel = new JLabel("<html>Estimated Time <br/>to Complete <br/> in Minutes: </html>");
        duration = new JTextField();
        window.add(durationLabel, "1, 6, 3, 7");
        window.add(duration, "2, 7, 3, 7");
        
        JButton plusButton = new JButton("Create Task");
        plusButton.addActionListener(new NewTaskListener());
        window.add(plusButton, "1, 9, 3");

        
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
    private class NewTaskListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String taskName = name.getText();
            String taskDuration= duration.getText();
            Double time = Double.parseDouble(taskDuration);
            
            String listText = listTitle.getText();
            
            // listText is always in this format: For List: "name"
            String listName = listText.substring(10);
            manager.addTask(listName, taskName, time);
            masterManager.addMasterTask(listText, time);
        }
    }
}
