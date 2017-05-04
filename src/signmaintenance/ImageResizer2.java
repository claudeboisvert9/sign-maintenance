/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signmaintenance;
/**
 * @author User
 */
import java.awt.image.BufferedImage;
/**
 * scale image
 * 
 * @param sbi image to scale
 * @param imageType type of image
 * @param dWidth width of destination image
 * @param dHeight height of destination image
 * @param fWidth x-factor for transformation / scaling
 * @param fHeight y-factor for transformation / scaling
 * @return scaled image
 */
/*
public static BufferedImage resizeImg2(BufferedImage sbi, int imageType, int dWidth, int dHeight, double fWidth, double fHeight) {
    BufferedImage dbi = null;
    if(sbi != null) {
        dbi = new BufferedImage(dWidth, dHeight, imageType);
        Graphics2D g = dbi.createGraphics();
        AffineTransform at = AffineTransform.getScaleInstance(fWidth, fHeight);
        g.drawRenderedImage(sbi, at);
    }
    return dbi;
}
*/