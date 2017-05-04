/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signmaintenance;

/**
 *
 * @author User
 */
public class CitySign {

    String latitude;
    String longitude;
    String type;
    String dateFrom;
    String dateTo;
    //String[] days;
    //String[] times;
    String days;
    String times;

    PictureFile pf = new PictureFile();
/*
    public void CitySign() {
       pf = new PictureFile();
    }
*/   
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
