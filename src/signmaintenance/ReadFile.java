/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signmaintenance;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;

/**
 *
 * @author User
 */
public class ReadFile {
    /**
     * Open and read a file, and return the lines in the file as a list of
     * Strings. (Demonstrates Java FileReader, BufferedReader, and Java5.)
     */
    private List<String> readFile(String filename) {
        List<String> records = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
            reader.close();
            return records;
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
            return null;
        }
    }

}