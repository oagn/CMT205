import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class DrawSchoolBus extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 400, 400);
        
        // Start by drawing the body of the bus
        // Rectangle (100, 120) - (260, 240)
        Rectangle body1 = new Rectangle();
        body1.setX(100);
        body1.setY(120);
        body1.setWidth(160);
        body1.setHeight(120);
        body1.setArcHeight(10);
        body1.setArcWidth(10);
        body1.setStroke(Color.BLACK);
        body1.setFill(Color.YELLOW);
        root.getChildren().add(body1);
        
        // Rectangle (260, 180) - (300, 240)
        Rectangle body2 = new Rectangle();
        body2.setX(260);
        body2.setY(180);
        body2.setWidth(40);
        body2.setHeight(60);
        body2.setStroke(Color.BLACK);
        body2.setFill(Color.YELLOW);
        root.getChildren().add(body2);
        
        // Fix outline
        Line line = new Line();
        line.setStartX(260);
        line.setStartY(181);
        line.setEndX(260);
        line.setEndY(240);
        line.setStroke(Color.YELLOW);
        root.getChildren().add(line);
        
        // Add windows and a door
        // Rectangle (110, 140) - (160, 180)
        Rectangle window1 = new Rectangle();
        window1.setX(110);
        window1.setY(140);
        window1.setWidth(50);
        window1.setHeight(40);
        window1.setStroke(Color.BLACK);
        window1.setFill(Color.WHITE);
        root.getChildren().add(window1);
        
        // Rectangle (220, 140) - (250, 180)
        Rectangle window2 = new Rectangle();
        window2.setX(220);
        window2.setY(140);
        window2.setWidth(30);
        window2.setHeight(40);
        window2.setStroke(Color.BLACK);
        window2.setFill(Color.WHITE);
        root.getChildren().add(window2);
        
        // Rectangle (180, 140) - (210, 240)
        Rectangle door1 = new Rectangle();
        door1.setX(180);
        door1.setY(140);
        door1.setWidth(30);
        door1.setHeight(100);
        door1.setStroke(Color.BLACK);
        door1.setFill(Color.FIREBRICK);
        root.getChildren().add(door1);
        
        // Add wheels 
        Circle wheel1 = new Circle();
        wheel1.setCenterX(140);
        wheel1.setCenterY(240);
        wheel1.setRadius(20);
        wheel1.setStroke(Color.BLACK);
        wheel1.setFill(Color.GRAY);
        root.getChildren().add(wheel1);
        
        Circle wheel2 = new Circle();
        wheel2.setCenterX(140);
        wheel2.setCenterY(240);
        wheel2.setRadius(10);
        wheel2.setStroke(Color.BLACK);
        wheel2.setFill(Color.BLACK);
        root.getChildren().add(wheel2);
        
        Circle wheel3 = new Circle();
        wheel3.setCenterX(260);
        wheel3.setCenterY(240);
        wheel3.setRadius(20);
        wheel3.setStroke(Color.BLACK);
        wheel3.setFill(Color.GRAY);
        root.getChildren().add(wheel3);
        
        Circle wheel4 = new Circle();
        wheel4.setCenterX(260);
        wheel4.setCenterY(240);
        wheel4.setRadius(10);
        wheel4.setStroke(Color.BLACK);
        wheel4.setFill(Color.BLACK);
        root.getChildren().add(wheel4);
        
        // Add "School bus" writing
        Text t = new Text(140, 135, "SCHOOL BUS");
        t.setFont(Font.font("Comic Sans", FontWeight.BOLD, 14));
        root.getChildren().add(t);
        
        // Make the bus all shiny
        Circle shine = new Circle();
        shine.setCenterX(108);
        shine.setCenterY(128);
        shine.setRadius(3);
        shine.setStroke(Color.WHITE);
        shine.setFill(Color.WHITE);
        root.getChildren().add(shine);
        
        Circle shineWheel1 = new Circle();
        shineWheel1.setCenterX(130);
        shineWheel1.setCenterY(230);
        shineWheel1.setRadius(2.5);
        shineWheel1.setStroke(Color.WHITE);
        shineWheel1.setFill(Color.WHITE);
        root.getChildren().add(shineWheel1);
        
        Circle shineWheel2 = new Circle();
        shineWheel2.setCenterX(250);
        shineWheel2.setCenterY(230);
        shineWheel2.setRadius(2.5);
        shineWheel2.setStroke(Color.WHITE);
        shineWheel2.setFill(Color.WHITE);
        root.getChildren().add(shineWheel2);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("School bus");
        primaryStage.show();
    }
}