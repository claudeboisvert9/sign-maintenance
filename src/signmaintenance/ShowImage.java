/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signmaintenance;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class ShowImage {   
    
    File img;
    private JPanel parent;

    public void ShowImage(JPanel parent) {
        this.parent = parent;

    }

    public void paintComponent(Graphics g) {
        Image image;
        String nomImg;

        img = new File("C:\\Users\\User\\Pictures\\Parking Signs\\Test\\resizeTemp.jpg");
        String name = img.getName();

        image = Toolkit.getDefaultToolkit().getImage(name);
        parent.getGraphics().drawImage(image, 10, 10, 50, 50, parent);
        parent.repaint();

    }
}