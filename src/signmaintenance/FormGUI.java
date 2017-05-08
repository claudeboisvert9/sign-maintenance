package signmaintenance;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import java.awt.Frame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFileChooser;

/**
 *
 * @author User
 */
public class FormGUI extends javax.swing.JFrame {

    public DataIO io;
    public static File[] dirFiles;
    public CitySign sign;

    // Set data directories to processC:\Users\User\Pictures\Parking Signs\Test\images
    //private static final String REL_PATH_TEXT = "C:\\Users\\User\\Pictures\\Parking Signs\\Test";
    String dataSourceAbsPath;
    String imagesAbsPath;
    String locationsAbsPath = dataSourceAbsPath;

    // Form data fields
    public static String fileName, fileNo, lati, longi;

    /**
     * Creates new form FormGUI
     */
    public FormGUI() {
        initComponents();

        io = new DataIO();
        dirFiles = io.getImgFiles(); //file list
        dataSourceAbsPath = io.getDataSourcePath();
        imagesAbsPath = dataSourceAbsPath + "\\images";
        locationsAbsPath = dataSourceAbsPath + "\\location";
        if (dirFiles.length > 0) {
            io.openDB();
        } //files selected
        nextBtn.doClick();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calendarPanel1 = new com.github.lgooddatepicker.components.CalendarPanel();
        exitBtn = new javax.swing.JButton();
        SignTypeLbl = new javax.swing.JLabel();
        dateFromLbl = new javax.swing.JLabel();
        daysLbl = new javax.swing.JLabel();
        timeFromLbl = new javax.swing.JLabel();
        picNoTField = new javax.swing.JTextField();
        latitudeTField = new javax.swing.JTextField();
        longitudeTField = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        pictureNoLbl = new javax.swing.JLabel();
        latitudeLbl = new javax.swing.JLabel();
        nextBtn = new javax.swing.JButton();
        longitudeLbl = new javax.swing.JLabel();
        previousBtn = new javax.swing.JButton();
        imageLbl = new javax.swing.JLabel();
        timeToLbl = new javax.swing.JLabel();
        signTypeCBox = new javax.swing.JComboBox<>();
        maxTimeLbl = new javax.swing.JLabel();
        dateToLbl = new javax.swing.JLabel();
        dateFromPicker = new com.github.lgooddatepicker.components.DatePicker();
        dateToPicker = new com.github.lgooddatepicker.components.DatePicker();
        maxTimePicker = new com.github.lgooddatepicker.components.TimePicker();
        daysPanel = new javax.swing.JPanel();
        dayMondayCBox = new javax.swing.JCheckBox();
        dayThursdayCBox = new javax.swing.JCheckBox();
        daySundayCBox = new javax.swing.JCheckBox();
        dayTuesdayCBox = new javax.swing.JCheckBox();
        dayWednesdayCBox = new javax.swing.JCheckBox();
        dayFridayCBox = new javax.swing.JCheckBox();
        daySaturdayCBox = new javax.swing.JCheckBox();
        timeFromPicker = new com.github.lgooddatepicker.components.TimePicker();
        timeToPicker = new com.github.lgooddatepicker.components.TimePicker();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign Maintenance");
        setLocation(new java.awt.Point(500, 0));

        exitBtn.setText("Exit");
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtnMouseClicked(evt);
            }
        });
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        SignTypeLbl.setText("Sign Type:");

        dateFromLbl.setText("Date From:");

        daysLbl.setText("Days:");

        timeFromLbl.setText("Time From:");

        picNoTField.setEditable(false);

        saveBtn.setText("Save");
        saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveBtnMouseClicked(evt);
            }
        });
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        pictureNoLbl.setText("Picture Nb:");

        latitudeLbl.setText("Latitude:");

        nextBtn.setText("Next");
        nextBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextBtnMouseClicked(evt);
            }
        });
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        longitudeLbl.setText("Longitude:");

        previousBtn.setText("Previous");
        previousBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousBtnActionPerformed(evt);
            }
        });

        imageLbl.setToolTipText("");

        timeToLbl.setText("To:");

        signTypeCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Parking Time", "No Parking Always", "Parking Time", "Parking Always" }));
        signTypeCBox.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                signTypeCBoxCaretPositionChanged(evt);
            }
        });

        maxTimeLbl.setText("Max. Time:");

        dateToLbl.setText("To:");

        dayMondayCBox.setText("Monday");

        dayThursdayCBox.setText("Thursday");
        dayThursdayCBox.setMaximumSize(new java.awt.Dimension(67, 23));
        dayThursdayCBox.setMinimumSize(new java.awt.Dimension(67, 23));
        dayThursdayCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayThursdayCBoxActionPerformed(evt);
            }
        });

        daySundayCBox.setText("Sunday");
        daySundayCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daySundayCBoxActionPerformed(evt);
            }
        });

        dayTuesdayCBox.setText("Tuesday");
        dayTuesdayCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayTuesdayCBoxActionPerformed(evt);
            }
        });

        dayWednesdayCBox.setText("Wednesday");
        dayWednesdayCBox.setMaximumSize(new java.awt.Dimension(67, 23));
        dayWednesdayCBox.setMinimumSize(new java.awt.Dimension(67, 23));
        dayWednesdayCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayWednesdayCBoxActionPerformed(evt);
            }
        });

        dayFridayCBox.setText("Friday");
        dayFridayCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayFridayCBoxActionPerformed(evt);
            }
        });

        daySaturdayCBox.setText("Saturday");
        daySaturdayCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daySaturdayCBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout daysPanelLayout = new javax.swing.GroupLayout(daysPanel);
        daysPanel.setLayout(daysPanelLayout);
        daysPanelLayout.setHorizontalGroup(
            daysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(daysPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(daysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dayThursdayCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayFridayCBox)
                    .addComponent(dayWednesdayCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(daysPanelLayout.createSequentialGroup()
                        .addGroup(daysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dayMondayCBox)
                            .addComponent(dayTuesdayCBox))
                        .addGap(36, 36, 36)
                        .addGroup(daysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(daySundayCBox)
                            .addComponent(daySaturdayCBox))))
                .addContainerGap())
        );

        daysPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dayFridayCBox, dayMondayCBox, daySaturdayCBox, daySundayCBox, dayThursdayCBox, dayTuesdayCBox, dayWednesdayCBox});

        daysPanelLayout.setVerticalGroup(
            daysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(daysPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(daysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dayMondayCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(daySaturdayCBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(daysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(daySundayCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayTuesdayCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(dayWednesdayCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dayThursdayCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dayFridayCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        daysPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dayFridayCBox, dayMondayCBox, daySaturdayCBox, daySundayCBox, dayThursdayCBox, dayTuesdayCBox, dayWednesdayCBox});

        timeFromPicker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                timeFromPickerMouseExited(evt);
            }
        });
        timeFromPicker.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                timeFromPickerCaretPositionChanged(evt);
            }
        });
        timeFromPicker.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                timeFromPickerPropertyChange(evt);
            }
        });

        timeToPicker.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                timeToPickerCaretPositionChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pictureNoLbl)
                                    .addComponent(latitudeLbl)
                                    .addComponent(longitudeLbl))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(longitudeTField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(latitudeTField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(picNoTField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dateFromLbl)
                                    .addComponent(dateToLbl))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateToPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateFromPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(SignTypeLbl)
                                        .addGap(18, 18, 18)
                                        .addComponent(signTypeCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(timeFromLbl)
                                            .addComponent(maxTimeLbl)
                                            .addComponent(daysLbl))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(timeFromPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(timeToLbl)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(timeToPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(maxTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(daysPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(previousBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nextBtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitBtn)
                .addGap(34, 34, 34))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {nextBtn, previousBtn});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pictureNoLbl)
                            .addComponent(picNoTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(latitudeLbl)
                            .addComponent(latitudeTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(longitudeLbl)
                            .addComponent(longitudeTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SignTypeLbl)
                            .addComponent(signTypeCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timeFromLbl)
                            .addComponent(timeToLbl)
                            .addComponent(timeFromPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeToPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maxTimeLbl)
                            .addComponent(maxTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(daysPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(daysLbl)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateFromLbl)
                            .addComponent(dateFromPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateToLbl)
                            .addComponent(dateToPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(exitBtn)
                    .addComponent(previousBtn)
                    .addComponent(nextBtn))
                .addGap(43, 43, 43))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {maxTimeLbl, maxTimePicker, timeFromLbl});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void processImgFile(String curImgFileName) {

        sign = io.getImageInfo(curImgFileName);
        //resize image
        String inputImagePath = imagesAbsPath + "\\" + curImgFileName;
        String outputImagePath = dataSourceAbsPath + "\\" + "resizeTemp.jpg";
        try {
            double percent = 0.2;
            ImageResizer.resize(inputImagePath, outputImagePath, percent);
        } catch (IOException ex) {
            System.out.println("Error resizing image: " + inputImagePath);
        }
        // update image on screen using ImageIO
        try {
            imageLbl.setIcon(new ImageIcon(ImageIO.read(new File(outputImagePath))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // update screen for mongo Key Fields
        picNoTField.setText(sign.pf.fileNo);
        latitudeTField.setText(sign.latitude);
        longitudeTField.setText(sign.longitude);
        // check if exist in mongo
        //io.getMongoDoc(sign);
        // update regular screen fields
    }


    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        // TODO add your handling code here:
        //DataIO.closeDB();
        //System.exit(0);
    }//GEN-LAST:event_exitBtnMouseClicked

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
        DataIO.closeDB();
        System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void saveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseClicked
        // validate fields
        // Save mongo document
        //DataIO.saveToMongo();
        // load next file or quit app
    }//GEN-LAST:event_saveBtnMouseClicked

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // validate fields

        // set Sign data
        sign.type = signTypeCBox.getSelectedItem().toString(); //set default value
        sign.timeFrom = timeFromPicker.getTimeStringOrEmptyString();
        sign.timeTo = timeToPicker.getTimeStringOrEmptyString();
        sign.maxTime = maxTimePicker.getTimeStringOrEmptyString();
        sign.dateFrom = dateFromPicker.getDateStringOrEmptyString();
        sign.dateTo = dateToPicker.getDateStringOrEmptyString();

        // Save mongo document
        io.saveToMongo(sign);
    }//GEN-LAST:event_saveBtnActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        // TO DO reset previous values of TFields
        // get next sign image
        processImgFile(io.getNextImg(dirFiles));
    }//GEN-LAST:event_nextBtnActionPerformed

    private void nextBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextBtnMouseClicked
        // TO DO check for data fields change and confirm loss to go next
    }//GEN-LAST:event_nextBtnMouseClicked

    private void dayTuesdayCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayTuesdayCBoxActionPerformed
        // TODO add your handling code here:
        sign.days[1] = true;
    }//GEN-LAST:event_dayTuesdayCBoxActionPerformed

    private void dayWednesdayCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayWednesdayCBoxActionPerformed
        // TODO add your handling code here:
        sign.days[2] = true;
    }//GEN-LAST:event_dayWednesdayCBoxActionPerformed

    private void dayFridayCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayFridayCBoxActionPerformed
        // TODO add your handling code here:
        sign.days[4] = true;
    }//GEN-LAST:event_dayFridayCBoxActionPerformed

    private void daySundayCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daySundayCBoxActionPerformed
        // TODO add your handling code here:
        sign.days[6] = true;
    }//GEN-LAST:event_daySundayCBoxActionPerformed

    private void dayThursdayCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayThursdayCBoxActionPerformed
        // TODO add your handling code here:
        sign.days[3] = true;
    }//GEN-LAST:event_dayThursdayCBoxActionPerformed

    private void daySaturdayCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daySaturdayCBoxActionPerformed
        // TODO add your handling code here:
        sign.days[5] = true;
    }//GEN-LAST:event_daySaturdayCBoxActionPerformed

    private void previousBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousBtnActionPerformed
        // TO DO check for data fields change and confirm loss to go next
        // TO DO reset previous values of TFields
        // get revious sign image
        processImgFile(io.getPreviousImg(dirFiles));
    }//GEN-LAST:event_previousBtnActionPerformed

    private void signTypeCBoxCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_signTypeCBoxCaretPositionChanged
        // TODO add your handling code here:
        sign.type = signTypeCBox.getSelectedItem().toString();
    }//GEN-LAST:event_signTypeCBoxCaretPositionChanged

    private void timeFromPickerCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_timeFromPickerCaretPositionChanged
        // TODO add your handling code here:
        //.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        sign.timeFrom = timeFromPicker.getText();
    }//GEN-LAST:event_timeFromPickerCaretPositionChanged

    private void timeFromPickerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeFromPickerMouseExited
        // TODO add your handling code here:
        //sign.timeFrom = timeFromPicker.toString();
    }//GEN-LAST:event_timeFromPickerMouseExited

    private void timeFromPickerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_timeFromPickerPropertyChange
        // TODO add your handling code here:
        //sign.timeFrom = timeFromPicker.toString();
    }//GEN-LAST:event_timeFromPickerPropertyChange

    private void timeToPickerCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_timeToPickerCaretPositionChanged
        // TODO add your handling code here:
        sign.timeTo = timeToPicker.getText();
    }//GEN-LAST:event_timeToPickerCaretPositionChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SignTypeLbl;
    private com.github.lgooddatepicker.components.CalendarPanel calendarPanel1;
    private javax.swing.JLabel dateFromLbl;
    private com.github.lgooddatepicker.components.DatePicker dateFromPicker;
    private javax.swing.JLabel dateToLbl;
    private com.github.lgooddatepicker.components.DatePicker dateToPicker;
    private javax.swing.JCheckBox dayFridayCBox;
    private javax.swing.JCheckBox dayMondayCBox;
    private javax.swing.JCheckBox daySaturdayCBox;
    private javax.swing.JCheckBox daySundayCBox;
    private javax.swing.JCheckBox dayThursdayCBox;
    private javax.swing.JCheckBox dayTuesdayCBox;
    private javax.swing.JCheckBox dayWednesdayCBox;
    private javax.swing.JLabel daysLbl;
    private javax.swing.JPanel daysPanel;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel imageLbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel latitudeLbl;
    private javax.swing.JTextField latitudeTField;
    private javax.swing.JLabel longitudeLbl;
    private javax.swing.JTextField longitudeTField;
    private javax.swing.JLabel maxTimeLbl;
    private com.github.lgooddatepicker.components.TimePicker maxTimePicker;
    private javax.swing.JButton nextBtn;
    private javax.swing.JTextField picNoTField;
    private javax.swing.JLabel pictureNoLbl;
    private javax.swing.JButton previousBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JComboBox<String> signTypeCBox;
    private javax.swing.JLabel timeFromLbl;
    private com.github.lgooddatepicker.components.TimePicker timeFromPicker;
    private javax.swing.JLabel timeToLbl;
    private com.github.lgooddatepicker.components.TimePicker timeToPicker;
    // End of variables declaration//GEN-END:variables
}
