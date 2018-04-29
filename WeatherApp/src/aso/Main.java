// Student number: c1767198

package aso;

import aso.gui.SummaryTab;
import aso.gui.DetailedTab;
import aso.gui.AppMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

/**
 * Main Application class.
 * This is the class to compile and run to start the WÆTHER application.
 * It sets up the main layout and calls the AppMenu, DetailTab and SummaryTab classes.
 *
 */
public class Main extends Application {

    @Override
    public void start(Stage window){

        Group root = new Group();
        Scene startScene = new Scene(root, 1024, 600);

        // Styling
        window.setTitle("WÆTHER");

        // Use a border pane to allow for consistent and easy placement of menu and main layout
        BorderPane border = new BorderPane();
        border.maxHeight(Double.MAX_VALUE);
        border.prefHeight(900.0);
        border.prefWidth(600.0);

        // Use tab pane to separate application content into summary and detailed
        TabPane tabs = new TabPane();
        tabs.setMaxHeight(600.0);

        // Create default Summary Tab
        Tab summaryTab = SummaryTab.create();

        // Create default Detail Tab
        Tab detailTab = DetailedTab.create();

        tabs.getTabs().addAll( summaryTab, detailTab);
        border.setCenter(tabs);

        // Create an application menu
        AppMenu.create(window, startScene, border);

        root.getChildren().add(border);

        startScene.getStylesheets().add("file:src/aso/css/Style.css");
        window.setScene(startScene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
