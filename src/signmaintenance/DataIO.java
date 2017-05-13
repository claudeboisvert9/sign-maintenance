/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signmaintenance;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.Block;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.model.UpdateOptions;
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
import org.bson.conversions.Bson;

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
        if (fileIndex < dirFiles.length) { // last file
            fileIndex += 1;
        }
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

        //getMongoDoc(sign);
        // si type not null set type previous type
        // set default fields or set to empty
        // Close fileS
        //PUT IN DECONSTRUCTOR  (finalize)  mongoClient.close();
        return sign;
    }

    public boolean getMongoDoc(CitySign sign) {
        MongoCollection<Document> collection = database.getCollection("signs");

        String docKey = fileNumber + "_" + latitude + "_" + longitude;
        Document myDoc = collection.find(eq("Key", docKey)).first();

        if (myDoc != null) {
            //use sign.setFieldname()?
            System.out.println(myDoc.toJson());
            sign.mongoId = myDoc.get("_id").toString();
            sign.type = myDoc.getString("signType");
            sign.icon = myDoc.getString("icon");
            sign.typeAlways = myDoc.getBoolean("typeAlways");
            sign.leftDirection = myDoc.getBoolean("leftDirection");
            sign.rightDirection = myDoc.getBoolean("rightDirection");
            sign.city = myDoc.getString("city");
            sign.allDays = myDoc.getBoolean("allDays");

            Document daysDoc = (Document) myDoc.get("days");
            sign.days[0] = daysDoc.getBoolean("sunday");
            sign.days[1] = daysDoc.getBoolean("monday");
            sign.days[2] = daysDoc.getBoolean("tuesday");
            sign.days[3] = daysDoc.getBoolean("wednesday");
            sign.days[4] = daysDoc.getBoolean("thursday");
            sign.days[5] = daysDoc.getBoolean("friday");
            sign.days[6] = daysDoc.getBoolean("saturday");

            sign.timeFrom = myDoc.getString("timeFrom");
            sign.timeTo = myDoc.getString("timeTo");
            sign.maxTime = myDoc.getString("maxTime");
            sign.dateFrom = myDoc.getString("dateFrom");
            sign.dateTo = myDoc.getString("dateTo");
            return true;
        } else {
            return false;
        }
    }

    public void saveToMongo(CitySign sign) {
        MongoCollection<Document> collection = database.getCollection("signs");
        String docKey = fileNumber + "_" + latitude + "_" + longitude;
        //TODO use _id to delete
        //collection.deleteOne(new Document("_id", new ObjectId(sign.mongoId))); //prevent duplicates
        //collection.deleteOne(new Document("Key", docKey)); //prevent duplicates        
        // TODO use .replace not deleteOne 
        
        Document doc = new Document("Key", docKey)
                .append("signType", sign.type)
                .append("city", sign.city)
                .append("icon", sign.icon)
                .append("typeAlways", sign.typeAlways)
                .append("leftDirection", sign.leftDirection)
                .append("rightDirection", sign.leftDirection)
                .append("allDays", sign.allDays)
                .append("days", new Document("sunday", sign.days[0])
                        .append("monday", sign.days[1])
                        .append("tuesday", sign.days[2])
                        .append("wednesday", sign.days[3])
                        .append("thursday", sign.days[4])
                        .append("friday", sign.days[5])
                        .append("saturday", sign.days[6]))
                .append("timeFrom", sign.timeFrom)
                .append("timeTo", sign.timeTo)
                .append("maxTime", sign.maxTime)
                .append("dateFrom", sign.dateFrom)
                .append("dateTo", sign.dateTo);
        collection.insertOne(doc);
    }

    // update does not work...
    private void updateMongo() {
        BasicDBObject newDocument = new BasicDBObject();
        //newDocument.put("Key", docKey);
        newDocument.put("signType", sign.type);
        newDocument.put("city", sign.city);
        newDocument.put("icon", sign.icon);
        newDocument.put("typeAlways", sign.typeAlways);
        newDocument.put("leftDirection", sign.leftDirection);
        newDocument.put("rightDirection", sign.rightDirection);
        newDocument.put("allDays", sign.allDays);

        BasicDBObject daysSubDoc = new BasicDBObject();
        daysSubDoc.put("sunday", sign.days[0]);
        daysSubDoc.put("monday", sign.days[1]);
        daysSubDoc.put("tuesday", sign.days[2]);
        daysSubDoc.put("wednesday", sign.days[3]);
        daysSubDoc.put("thursday", sign.days[4]);
        daysSubDoc.put("friday", sign.days[5]);
        daysSubDoc.put("saturday", sign.days[6]);
        newDocument.put("days", daysSubDoc);

        newDocument.put("timeFrom", sign.timeFrom);
        newDocument.put("timeTo", sign.timeTo);
        newDocument.put("maxTime", sign.maxTime);
        newDocument.put("dateFrom", sign.dateFrom);
        newDocument.put("dateTo", sign.dateTo);

        //Bson filter = Filters.eq("Key", docKey);
        //UpdateOptions options = new UpdateOptions().upsert(true);
        //UpdateResult c1 = collection.updateOne(filter, newDocument, options);
    }

    public String getDataSourcePath() {
        return dataSourceAbsPath;
    }
}
