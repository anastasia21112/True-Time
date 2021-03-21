
package pkgtrue.time;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import layout.TableLayout;
import java.awt.Font;

public class ListOfLists 
{
    public static JFrame window;
    public static JPanel backgroundPanel;
    public static JPanel mainPanel;
    public static JPanel listPanel;
    public static JPanel placeHolder = new JPanel();
    
    public ListOfLists()
    {
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

        JPanel listPanel = new JPanel();
        window.add(listPanel,"1,5, 3, 5");
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
