/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDE;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import signmaintenance.SignMaintenance;

public class MainGUI {

    public static void showLocations(JFrame window, JPanel wPanel,
            List<String> fileLines) {

        List<String> lines = fileLines;
        //int mysize = lines.size();
        String locationsList = lines.get(1);
        JLabel locationsData = new JLabel(locationsList);
        wPanel.add(locationsData, BorderLayout.EAST);
        window.setContentPane(wPanel);
    }

    private static class HelloWorldDisplay extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString("Hello SignMaintenance!", 20, 50);
        }
    }

    private static class SaveButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //System.exit(0);
            // Save mongo document
            SignMaintenance.saveToMongo();
            // next file... ??             
        }
    }

    public static void startGUI(JFrame window, JPanel wPanel) {

        //HelloWorldDisplay displayPanel = new HelloWorldDisplay();

        JLabel locationsLabel = new JLabel("Sign Locations");

        JButton saveButton = new JButton("Save To Mongo");
        SaveButtonHandler saveListener = new SaveButtonHandler();
        saveButton.addActionListener(saveListener);

        wPanel.setLayout(new BorderLayout());
        //wPanel.add(displayPanel, BorderLayout.CENTER);
        wPanel.add(locationsLabel, BorderLayout.PAGE_START);
        wPanel.add(saveButton, BorderLayout.SOUTH);

        window.setContentPane(wPanel);
        window.setSize(1000, 500);
        window.setLocation(100, 100);
        window.setVisible(true);
    }

}
