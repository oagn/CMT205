// Student number: c1767198

package aso.util;

import javafx.stage.DirectoryChooser;
import java.io.File;

/**
 * Class for configuration of
 */
public class ConfigureDirectoryChooser {

    /**
     * Method to configure the directoryChooser name and setting start directory.
     * @param directoryChooser the FileChooser instance to configure
     */
    public static void configure(DirectoryChooser directoryChooser) {
        // Set Initial Directory
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        // Set title
        directoryChooser.setTitle("Select export directory");
    }
}
