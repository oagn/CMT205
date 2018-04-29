// Student number: c1767198

package aso.gui;

import aso.util.ReportExporter;
import aso.model.WeatherDataMap;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Menu;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Toggle;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.input.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.application.Platform;

import java.util.List;

/**
 * Class for creation, layout and controll of the WÆTHER application menu.
 * The menu bar has two menus:
 * File and View;
 * The File menu can open the Summary File Exporter or close the application.
 * The View menu provides functionality to change the year of the data displayed in the Summary Tab.
 *
 */
public class AppMenu {

    /**
     * Method to create the menu bar, menus and define control of each item.
     * @param primaryStage the primary stage of the application
     * @param scene the initial scene of the application
     * @param root the border pane to insert the app menu into
     */
    public static void create( Stage primaryStage, Scene scene, BorderPane root) {

        final StringProperty statusProperty = new SimpleStringProperty();

        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty()
                .bind(primaryStage.widthProperty());
        root.setTop(menuBar);

        // File menu, export report and exit application
        Menu fileMenu = new Menu("_File");
        fileMenu.setMnemonicParsing(true);
        menuBar.getMenus().add(fileMenu);

        MenuItem exportItem = new MenuItem("_Export report");
        exportItem.setMnemonicParsing(true);

        exportItem.setAccelerator(new KeyCodeCombination(KeyCode.E,
                KeyCombination.SHORTCUT_DOWN));
        exportItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Stage exportStage = ReportExporter.reportDialogue();
                exportStage.show();
           }
        });
        fileMenu.getItems().add(exportItem);

        fileMenu.getItems().add(new SeparatorMenuItem());

        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setAccelerator(new KeyCodeCombination(KeyCode.X,
                KeyCombination.SHORTCUT_DOWN));
        exitItem.setOnAction(actionEvent -> {
            statusProperty.set("Ctrl-X");
            Platform.exit();
        });

        scene.getAccelerators().put(
                new KeyCodeCombination(KeyCode.E,
                        KeyCombination.SHORTCUT_DOWN,
                        KeyCombination.SHIFT_DOWN),
                () -> statusProperty.set("Ctrl-Shift-E")
        );

        fileMenu.getItems().add(exitItem);

        ContextMenu contextFileMenu = new ContextMenu(exitItem);

        primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
            if (me.getButton() == MouseButton.SECONDARY) {
                contextFileMenu.show(root, me.getScreenX(), me.getScreenY());
            } else {
                contextFileMenu.hide();
            }
        });

        // View menu, Summary Year choice
        Menu viewMenu = new Menu("_View");
        menuBar.getMenus().add(viewMenu);

        // Get station data from summary tab
        WeatherDataMap allWeather = SummaryTab.allStations;
        List<Integer> years = allWeather.getYears();

        Menu summaryItem = new Menu("_Summary Year");
        summaryItem.setMnemonicParsing(true);

        summaryItem.setAccelerator(new KeyCodeCombination(KeyCode.Y,
                KeyCombination.SHORTCUT_DOWN));

        viewMenu.getItems().add(summaryItem);

        // Create Year selector
        // Submenu for choice of year in summary tab
        final ToggleGroup allYears = new ToggleGroup();

        for ( int year : years) {
            RadioMenuItem yearItem = new RadioMenuItem(String.valueOf(year));
            yearItem.setToggleGroup(allYears);
            yearItem.setUserData(year);
            summaryItem.getItems().add(yearItem);
        }

        //Processing summary menu item selection
        allYears.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                if (allYears.getSelectedToggle() != null) {
                    int year = (int) allYears.getSelectedToggle().getUserData();
                    SummaryTab.updateGrid(year);
                }
            }
        });

    }

}
