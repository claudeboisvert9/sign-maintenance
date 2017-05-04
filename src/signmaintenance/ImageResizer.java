/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signmaintenance;
//package net.codejava.graphic;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * This program demonstrates how to resize an image.
 *
 * @author www.codejava.net
 *
 */
public class ImageResizer {

    /**
     * Resizes an image to a absolute width and height (the image may not be
     * proportional)
     *
     * @param inputImagePath Path of the original image
     * @param outputImagePath Path to save the resized image
     * @param scaledWidth absolute width in pixels
     * @param scaledHeight absolute height in pixels
     * @throws IOException
     */
    public static void resize(String inputImagePath,
            String outputImagePath, int scaledWidth, int scaledHeight)
            throws IOException {
        // reads input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);

        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());

        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        // extracts extension of output file
        String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);

        // writes to output file
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
    }

    /**
     * Resizes an image by a percentage of original size (proportional).
     *
     * @param inputImagePath Path of the original image
     * @param outputImagePath Path to save the resized image
     * @param percent a double number specifies percentage of the output image
     * over the input image.
     * @throws IOException
     */
    public static void resize(String inputImagePath,
            String outputImagePath, double percent) throws IOException {
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
        int scaledWidth = (int) (inputImage.getWidth() * percent);
        int scaledHeight = (int) (inputImage.getHeight() * percent);
        resize(inputImagePath, outputImagePath, scaledWidth, scaledHeight);
    }

    // resize & return image
    /*
    public static BufferedImage resize(String inputImagePath,
            String outputImagePath, double percent) throws IOException {
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
        int scaledWidth = (int) (inputImage.getWidth() * percent);
        int scaledHeight = (int) (inputImage.getHeight() * percent);
        resize(inputImagePath, outputImagePath, scaledWidth, scaledHeight);
    }
    */
    
	/* alternative resizing code	
    private static BufferedImage resizeMe(BufferedImage startingImage) {
        try {
            BufferedImage masterImage = ImageIO.read(startingImage);
            BufferedImage thumbImage = new BufferedImage(THUMB_SIDE, THUMB_SIDE, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = thumbImage.createGraphics();
            g2d.drawImage(masterImage.getScaledInstance(THUMB_SIDE, THUMB_SIDE, Image.SCALE_SMOOTH), 0, 0, THUMB_SIDE, THUMB_SIDE, null);
            g2d.dispose();
            String thumb_path = path.substring(0, path.indexOf(".png")) + "_thumb.png";
            ImageIO.write(thumbImage, "png", new File(thumb_path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	*/
	
    /**
     * Test resizing images
     * @param args
     */
    public static void main(String[] args) {
        String relPathText = "C:\\Users\\User\\Pictures\\Parking Signs\\Test\\images";
        String inputImagePath = relPathText + "\\sign-pic9.jpg";
        String outputImagePath1 = relPathText + "\\sign-pic9_Fixed.jpg";
        String outputImagePath2 = relPathText + "\\sign-pic9_Smaller.jpg";
        String outputImagePath3 = relPathText + "\\sign-pic9_TestSize.jpg";

        try {
            // resize to a fixed width (not proportional)
            int scaledWidth = 1024;
            int scaledHeight = 768;
            ImageResizer.resize(inputImagePath, outputImagePath1, scaledWidth, scaledHeight);

            // resize smaller by 50%
            double percent = 0.5;
            ImageResizer.resize(inputImagePath, outputImagePath2, percent);

            // resize TestSize 
            percent = 0.2;
            ImageResizer.resize(inputImagePath, outputImagePath3, percent);

        } catch (IOException ex) {
            System.out.println("Error resizing the image.");
            ex.printStackTrace();
        }
    }

}
