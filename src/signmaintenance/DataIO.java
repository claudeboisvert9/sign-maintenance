/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signmaintenance;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

import java.awt.image.BufferedImage;

import org.bson.Document;

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

    private static String dataSourceAbsPath = null; //user selectable
    private static String imagesAbsPath;
    private static String locationsAbsPath;

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

    //public static final int iMonday = 0;
//    public enum Day {
//        SUNDAY(0), MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6)
//    }
    public enum Month {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE,
        JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }

    public void DataIO() {
        // Constructeur        
        //getImgFiles(); //files to process
        // if (nbFiles > 1) { openDB(); }
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

    public void selectSourceDir() {
        dataSourceAbsPath = null;
        imagesAbsPath = null;
        locationsAbsPath = null;

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("C:\\Users\\User\\Pictures\\Parking Signs"));
        chooser.setDialogTitle("Select Source Directory");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
           System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
           System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
            dataSourceAbsPath = chooser.getSelectedFile().toString();
            imagesAbsPath = dataSourceAbsPath + "\\images";
            locationsAbsPath = dataSourceAbsPath + "\\location";
  
        } else {
            System.out.println("No Selection ");
        }
    }

    public File[] getImgFiles() {

        // Set data directories to process
        //imgRelPathText = REL_PATH_TEXT + "\\images";
        //locRelPathText = REL_PATH_TEXT + "\\location";
        selectSourceDir();
        File path = new File(imagesAbsPath);
        files = path.listFiles();
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
            File image2 = new File(imagesAbsPath + "\\" + srcImgFileName);
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
        String locationFilePath = locationsAbsPath + "\\" + locationFileName;
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

    public void getMongoDoc(CitySign sign) {
        MongoCollection<Document> collection = database.getCollection("signs");
        
        String docKey = fileNumber + "_" + latitude + "_" + longitude;
        Document myDoc = collection.find(eq("Key", docKey)).first();
        System.out.println(myDoc.toJson());
        sign.type = myDoc.getString("signType");
        //return sign;
    }

    public void saveToMongo(CitySign sign) {
        MongoCollection<Document> collection = database.getCollection("signs");
        
        Document doc = new Document("Key", fileNumber + "_" + latitude + "_" + longitude)
                .append("city", sign.city)
                .append("signType", sign.type)
                .append("timeFrom", sign.timeFrom)
                .append("timeTo", sign.timeTo)
                .append("maxTime", sign.maxTime)
                .append("days", new Document("sunday", sign.days[0]))
                .append("monday", sign.days[1])
                .append("tuesday", sign.days[2])
                .append("wednesday", sign.days[3])
                .append("thursday", sign.days[4])
                .append("friday", sign.days[5])
                .append("saturday", sign.days[6])
                .append("dateFrom", sign.dateFrom)
                .append("dateTo", sign.dateTo);
        collection.insertOne(doc);
    }
    
    public String getDataSourcePath() {
        return dataSourceAbsPath;
    }
}
