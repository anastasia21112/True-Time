/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtrue.time;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author daphn
 */
public class ImagePanel extends JPanel{
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon img = new ImageIcon("images/background.png");
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
    }
}
