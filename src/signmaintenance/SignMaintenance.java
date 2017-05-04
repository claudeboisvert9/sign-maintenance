/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signmaintenance;

import IDE.MainGUI;
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
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
//import java.util.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;

//import java.lang.Runnable;
import javax.swing.*;

/**
 *
 * @author User
 */
public class SignMaintenance {

    private static final String REL_PATH_TEXT = "C:\\Users\\User\\Pictures\\Parking Signs\\Test";
    private static String imgRelPathText;
    private static String locRelPathText;
    private static JFrame window;
    private static JPanel wPanel;

    private static MongoClient mongoClient;
    private static MongoDatabase database;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        window = new JFrame("GUI Test");
        wPanel = new JPanel();
        //MainGUI.startGUI(window, wPanel);

        Runnable task1 = new Runnable() {

            @Override
            public void run() {
                System.out.println("Task #1 is running");
                MainGUI.startGUI(window, wPanel);

                // Directly connect to a single MongoDB server
                // (this will not auto-discover the primary even if it's a member of a replica set)
                //MongoClient mongoClient;
                //MongoDatabase database;
                try {
                    // Connect to mongodb server
                    mongoClient = new MongoClient("localhost", 27017);
                    database = mongoClient.getDatabase("parking");
                } catch (Exception e) {
                    System.err.println(e.getClass().getName() + ": " + e.getMessage());
                }

                // Set data directories to process
                imgRelPathText = REL_PATH_TEXT + "\\images";
                locRelPathText = REL_PATH_TEXT + "\\location";

                File path = new File(imgRelPathText);
                File[] files = path.listFiles();

                // if files, process first one
                if (files[0].isFile()) { //loop.. this line weeds out other directories/folders
                    processFile(files, 0);
                }
                /*
                // process other files
                for (int i = 1; i < files.length; i++) {
                    if (files[i].isFile()) { //this line weeds out other directories/folders
                    processFile(files, i);
                    }
                } // next file (image)
                 */
            }
        };
        Thread thread1 = new Thread(task1);
        thread1.start(); // wait Save event
    } // main

    public static void processFile(File[] files, int index) {
        System.out.println(files[index]);
        // Loop on files
        String srcFileName = files[index].getName();
        //resize image                 
        String inputImagePath = imgRelPathText + "\\" + srcFileName;
        String outputImagePath = REL_PATH_TEXT + "\\" + "resizeTemp.jpg";

        try {
            // resize image 
            double percent = 0.2;
            ImageResizer.resize(inputImagePath, outputImagePath, percent);
        } catch (IOException ex) {
            System.out.println("Error resizing image: " + inputImagePath);
            ex.printStackTrace();
        }

        //DisplayImg.main(outputImagePath);
        // Set location file name (signLocation123) then read
        String locationFileName = "signLocation";
        String fileNumber = srcFileName.replaceAll("\\D+", "");
        locationFileName = locationFileName + fileNumber;
        String locationFilePath = locRelPathText + "\\" + locationFileName;
        File locationFile = new File(locationFilePath);

        List<String> records = new ArrayList<String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(locationFilePath));
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
            reader.close();
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", locationFilePath);
            e.printStackTrace();
        }

        // display locations in GUI
        MainGUI.showLocations(window, wPanel, records);

        //check exist in mongo?
        //allow input of fields: type, hours...
        //validate and save to mongo 
        // Close files                   
        /*      // test if object exist then close server connection
        if (mongoClient.equals(null)) {
            System.out.println("The mongoClient object is null");
        } else {
            mongoClient.close();
        }
         */
    }

    public static void saveToMongo() {
        MongoCollection<Document> collection = database.getCollection("signs");
        Document doc = new Document("name", "SaveToMongo")
                .append("type", "test")
                .append("count", 2)
                .append("info", new Document("x", 199).append("y", 200));
        collection.insertOne(doc);
        // next file... ??
    }
}

/*
            String user = "admin";        // the user name
            String database = "admin";    // the name of the database in which the user is defined
            char[] password = { 'm', 'o', 't', 'p', 'a', 's', 's', 'e' };    // the password as a character array

            MongoCredential credential = 
                    MongoCredential.createCredential(user, database, password);
            // Now connect to your databases
 */
