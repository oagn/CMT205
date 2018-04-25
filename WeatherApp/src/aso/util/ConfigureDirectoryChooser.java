package aso.util;

import javafx.stage.DirectoryChooser;

import java.io.File;

public class ConfigureDirectoryChooser {

    /**
     * Method to cconfigure the fileChooser name and adding filters.
     * To be used with the pictureURL field
     *
     * @param directoryChooser the FileChooser instance to configure
     */
    public static void configure(DirectoryChooser directoryChooser) {
        // Set title for FileChooser
        directoryChooser.setTitle("Select Picture");

        // Set Initial Directory
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        directoryChooser.setTitle("Select export directory");
    }
}
