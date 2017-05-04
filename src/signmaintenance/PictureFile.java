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
public class PictureFile {

    public String fileName;
    public String fileType;
    public String fileNo;
    public String fileDate;
    //private int fileSize;
    //public String[] latitude;
    //public String[] longitude;
    public String latitude;
    public String longitude;

    public void setfileName(String fileName) {
		this.fileName = fileName;
	}
	public String getfileName() {
		return fileName;
	}
	
    public void setfileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getfileNo() {
		return fileNo;
	}
	
}
