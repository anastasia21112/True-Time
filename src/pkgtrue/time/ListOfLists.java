
package pkgtrue.time;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import layout.TableLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

public class ListOfLists 
{
    public static ListManager manager = new ListManager();
    
    public static JFrame window;
    public static JPanel backgroundPanel;
    public static JScrollPane listScroll;
    public static JPanel listPanel;
    
    public ListOfLists()
    {
        listPanel = new JPanel();
        listScroll = new JScrollPane(listPanel);
        
        window = new JFrame();
        window.setTitle("True Time");
        window.setSize(325, 675);
        window.setResizable(false);
        window.setContentPane(new ImagePanel());
        
        double windowSize[][] = {{40,75,25,145,40}, // Columns
            {75,25,25, 25, 25, 325, 25, 25}}; // Rows
        window.setLayout(new TableLayout(windowSize));
        
        JButton backButton = new JButton("Back");
        window.add(backButton,"1,1");
        
        JLabel pageTitle = new JLabel("Anastasia's Lists", SwingConstants.CENTER);
        pageTitle.setFont(new Font("", Font.PLAIN, 20));
        window.add(pageTitle, "1,3, 3, 3");
        
        JButton plusButton = new JButton("+ Add New List");
        window.add(plusButton, "1,7, 3, 7");

        window.add(listScroll,"1,5, 3, 5");
        
        // Adds Listeners to Buttons
        plusButton.addActionListener(new ListListener());
        
        
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void refresh()
    {
        listPanel.removeAll();
        createListLabels();
        listScroll.validate();
        listScroll.repaint();
    }
    
    public void createListLabels()
    {
        ArrayList temp = manager.keySet();
        
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        
        
        for(int i = 0; i < temp.size(); i++)
        {
            String name = (String) temp.get(i);
            JButton nameButton = new JButton(name);
            listPanel.add(nameButton);
            nameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            listPanel.add(Box.createRigidArea(new Dimension(0,5)));
        }
    }
    
    private class ListListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JPanel newListPanel = new JPanel();
            
            double newListSize[][] = {{150}, // Columns
            {25,25}}; // Rows
            newListPanel.setLayout(new TableLayout(newListSize));
            
            JLabel listLabel = new JLabel("Enter New List Name:");
            JTextArea nameArea = new JTextArea();
            nameArea.setBorder(new LineBorder(Color.BLACK, 1));
            
            newListPanel.add(listLabel, "0,0");
            newListPanel.add(nameArea, "0,1");
            
            
            int result = JOptionPane.showConfirmDialog(window, newListPanel,
                "New List", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) 
            {
                String listName = nameArea.getText();
                manager.addList(listName);
                refresh();
            }
        }
    }
}
