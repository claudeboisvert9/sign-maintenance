/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signmaintenance;

import java.util.ArrayList;
import java.util.Date;
import javafx.scene.control.DatePicker;

/**
 *
 * @author User
 */
public class CitySign {

    // Document KEY fields with pf.fileNo
    String mongoId;
    String latitude;
    String longitude;
    String city;
    String type;
    String icon;
    boolean typeAlways;
    boolean leftDirection;
    boolean rightDirection;
    boolean allDays;
    boolean[] days = new boolean[7]; // Monday to Sunday
    String timeFrom;
    String timeTo;
    String maxTime;
    String dateFrom;
    String dateTo;

    PictureFile pf = new PictureFile();

//does not work 
//    public void CitySign() {
//        pf = new PictureFile();
//    }

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
