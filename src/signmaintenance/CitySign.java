/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signmaintenance;

import java.util.ArrayList;
import java.util.Date;
import javafx.scene.control.DatePicker;
import org.bson.types.ObjectId;

/**
 *
 * @author User
 */
public class CitySign implements Cloneable {

    //Document KEY fields with pf.fileNo
    String mongoId;
    String latitude;
    String longitude;
    //Integer signNo in pf
	
    String city;
    String type;
    String icon;
    boolean typeAlways;
    boolean leftDirection;
    boolean rightDirection;
    boolean allDays;
    boolean[] days = new boolean[7]; // Sunday to Saturday 
    String timeFrom;
    String timeTo;
    String timeFrom2;
    String timeTo2;
    String timeFrom3;
    String timeTo3;
    String maxTime;
    String dateFrom;
    String dateTo;

    PictureFile pf = new PictureFile();

//does not work 
//    public void CitySign() {
//        pf = new PictureFile();
//    }
    @Override
    public CitySign clone() {
        CitySign copy = null;
        try {
            // On récupère l'instance à renvoyer par l'appel de la 
            // méthode super.clone()
            copy = (CitySign) super.clone();
        } catch (CloneNotSupportedException cnse) {
            // Ne devrait jamais arriver car nous implémentons 
            // l'interface Cloneable
            cnse.printStackTrace(System.err);
        }
        // on renvoie le clone
        return copy;
    }

    public void settype(String type) {
        this.type = type;
    }

    public String gettype() {
        return type;
    }

    public void setlatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getlatitude() {
        return latitude;
    }

    public void setlongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getlongitude() {
        return longitude;
    }

}
