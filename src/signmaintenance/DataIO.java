/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signmaintenance;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import java.awt.image.BufferedImage;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.*;

/**
 *
 * @author User
 */
public class DataIO {

    private static final String REL_PATH_TEXT = "C:\\Users\\User\\Pictures\\Parking Signs\\Test";
    private static String imgRelPathText;
    private static String locRelPathText;

    public static MongoClient mongoClient;
    public static MongoDatabase database;

    public static File[] files;
    private static int fileIndex = -1;
    private static int nbFiles = 0;

    public CitySign sign;
    public String fileName;
    public String fileNumber;
    public String latitude;
    public String longitude;

    public void DataIO() {
        // Constructeur
        getImgFiles(); //files to process
    }

    public static void openDB() {

        try {
            // Directly connect to a single MongoDB server
            // (this will not auto-discover the primary even if it's a member of a replica set)
            mongoClient = new MongoClient("localhost", 27017);
            database = mongoClient.getDatabase("parking");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.err.println("Could not connect to MongoDB");
        }
    }

    public static void closeDB() {
        mongoClient.close();
    }

    public File[] getImgFiles() {

        // Set data directories to process
        imgRelPathText = REL_PATH_TEXT + "\\images";
        locRelPathText = REL_PATH_TEXT + "\\location";

        File path = new File(imgRelPathText);
        File[] files = path.listFiles();
        nbFiles = files.length;
        fileIndex = -1;
        return files;
    }

    public String getPreviousImg(File[] dirFiles) {
        if (fileIndex > 0) { // first file
            fileIndex -= 1;
        }
        for (int i = fileIndex; i > 0; i--) {
            if (dirFiles[i].isFile()) { //this line weeds out other directories/folders
                fileIndex = i;
                return dirFiles[i].getName();
            }
        }
        return dirFiles[0].getName();
    }

    public String getNextImg(File[] dirFiles) {

        fileIndex = fileIndex + 1;
        for (int i = fileIndex; i < nbFiles; i++) {
            if (dirFiles[i].isFile()) { //this line weeds out other directories/folders
                fileIndex = i;
                return dirFiles[i].getName();
            }
        }
        return null; //no more image files ADD NULL TEST TO CALLER
    }

    public BufferedImage getSignImage(String srcImgFileName) {
        BufferedImage image = null;
        try {
            File image2 = new File(imgRelPathText + "\\" + srcImgFileName);
            image = ImageIO.read(image2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        //resize image
        String inputImagePath = imgRelPathText + "\\" + srcImgFileName;
        String outputImagePath = REL_PATH_TEXT + "\\" + "resizeTemp.jpg";
        try {
            // resize image
            double percent = 0.2;
            ImageResizer.resize(inputImagePath, outputImagePath, percent);
        } catch (IOException ex) {
            System.out.println("Error resizing image: " + inputImagePath);
            ex.printStackTrace();
        }
         */
        return image;
    }

    public CitySign getImageInfo(String srcImgFileName) {

        System.out.println("Processing file: " + srcImgFileName);

        // Set location file name (signLocation123) then read
        String locationFileName = "signLocation";
        fileNumber = srcImgFileName.replaceAll("\\D+", "");
        locationFileName = locationFileName + fileNumber;
        String locationFilePath = locRelPathText + "\\" + locationFileName;
        File locationFile = new File(locationFilePath);

        List<String> records = new ArrayList<String>(); // file content
        String geopos = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(locationFilePath));
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
                geopos = line;
            }
            int pos = geopos.indexOf(95);
            latitude = geopos.substring(0, pos - 1);
            longitude = geopos.substring(pos + 1, geopos.length());
            reader.close();
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", locationFilePath);
            e.printStackTrace();
        }

        //ADD DATA TO SIGN OBJECT
        sign = new CitySign();
        sign.pf.setfileName(fileName);
        sign.pf.setfileNo(fileNumber);
        sign.setlatitude(latitude);
        sign.setlongitude(longitude);

        // si type not null set type previous type
        // set default fields or set to empty
        // Close fileS
        //PUT IN DECONSTRUCTOR  (finalize)  mongoClient.close();
        return sign;
    }

    public void saveToMongo() {
        MongoCollection<Document> collection = database.getCollection("signs");
        Document doc = new Document("name", "SaveToMongo")
                .append("type", "test")
                .append("count", 2)
                .append("info", new Document("x", 199).append("y", 200));
        collection.insertOne(doc);
    }
}
