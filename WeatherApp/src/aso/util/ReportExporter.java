package aso.util;

import javafx.stage.Stage;
import javafx.stage.DirectoryChooser;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class ReportExporter {

    private static TextField textFld;
    private static final String titleTxt = "Summary File Exporter";
    static private File saveFile;

    public static Stage reportDialogue() {
        Stage reportStage = new Stage();
        reportStage.setTitle(titleTxt);

        // Text field and directory chooser
        Label txtLbl = new Label("Directory:");
        txtLbl.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));
        textFld = new TextField();
        textFld.setMinHeight(30.0);
        textFld.setPromptText("Please select a directory");
        textFld.setPrefColumnCount(15);
        Button selectBtn = new Button("Select");

        // Get picture from filesystem, using fileChooser
        final DirectoryChooser directoryChooser = new DirectoryChooser();
        ConfigureDirectoryChooser.configure(directoryChooser);

        selectBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                saveFile = directoryChooser.showDialog(reportStage);
                if (saveFile != null) {
                    textFld.setText(saveFile.getAbsolutePath() + File.separator +"WÆTHERSummary.txt");
                }
            }
        });

        HBox buttonHb = new HBox(10);

        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.getChildren().addAll(txtLbl, textFld, selectBtn);

        // Action Buttons
        Button infobtn = new Button("Info");
        infobtn.setOnAction(new InfoButtonListener());
        Button savebtn = new Button("Save");
        savebtn.setOnAction(new SaveButtonListener());
        buttonHb.setAlignment(Pos.CENTER);
        buttonHb.getChildren().addAll(infobtn, savebtn);


        // Vbox
        VBox vbox = new VBox(30);
        vbox.setPadding(new Insets(25, 25, 25, 25));
        ;
        vbox.getChildren().addAll(hbox, buttonHb);

        // Scene
        Scene scene = new Scene(vbox, 500, 200); // w x h
        reportStage.setScene(scene);

        // Initial
        infobtn.requestFocus();

        return reportStage;
    }

    private static class InfoButtonListener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {

            // Show info alert dialog

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle(titleTxt);
            alert.setHeaderText("Information");
            String s = "This is a summary file exporter. \nPlease select a folder to save the WÆTHERsummary.txt file in.\n\n" +
                    "The summary file will contain information for each weather station regarding:\n\n(Highest) The month/year with the highest tmax, \n"+
                    "(Lowest) The month/year with the lowest tmin,\n(Average annual af) The average days of air frost per year and \n" +
                    "(Average annual rainfall) The average annual rainfall in mm";
            alert.setContentText(s);

            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add("file:src/aso/css/Style.css");
            dialogPane.getStyleClass().add("dialog-pane");

            alert.show();
        }
    }

    private static class SaveButtonListener implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {

            // Show error alert dialog
            String path;
            path = textFld.getText().trim();
            boolean valid = true;

            if ((path.isEmpty())){
                valid = false;
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle(titleTxt);
                String s = "Please choose a folder";
                alert.setContentText(s);

                alert.showAndWait();
            }

            if (!valid){
                textFld.requestFocus();
            }

            if (valid){
                SaveFile(path);
            }
        }
    }

    private static void SaveFile(String path) {

        ArrayList<String> report = ReportCreator.createReport();

        // writer
        try (FileWriter writer = new FileWriter(path)) {
            // data
            for (String line : report) {
                writer.write(line);
                writer.write("\n");
                writer.flush();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}