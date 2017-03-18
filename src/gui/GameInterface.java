package gui;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.GameModel;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * The graphical user interface for the game. Displays the game data.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class GameInterface extends Application implements Observer {
    // The game model for the graphical user interface
    private GameModel model;

    // The application stage
    private Stage primaryStage;

    // Custom Font values
    public static final Font PIXEL_FONT_LARGE = Font.loadFont(GameInterface.class.getResource("pixelfont.ttf").toExternalForm(), 50);
    public static final Font PIXEL_FONT_MEDIUM = Font.loadFont(GameInterface.class.getResource("pixelfont.ttf").toExternalForm(), 30);
    public static final Font PIXEL_FONT_SMALE = Font.loadFont(GameInterface.class.getResource("pixelfont.ttf").toExternalForm(), 20);

    // Constant string values
    public static final String TITLE = "Nonsense Quest";

    /**
     * Constructor for the game interface.
     */
    public GameInterface(){
        this.model = null;
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(TITLE);
        primaryStage.setScene(new Scene(makeSplash()));
        primaryStage.setHeight(900);
        primaryStage.setWidth(900);
        primaryStage.show();
        this.primaryStage = primaryStage;
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    /**
     * Method to create the title bar for the application.
     * @return Pane representing the top element of the border pane
     */
    private BorderPane makeSplash(){
        // Create the border pane
        BorderPane border = new BorderPane();
        border.setPadding(new Insets(50.0));
        border.setStyle("-fx-background-color: GRAY;");

        // Create the top title label
        Label label = new Label("Welcome to Nonsense Quest!");
        label.setPadding(new Insets(30.0));
        label.setFont(PIXEL_FONT_LARGE);
        label.setTextFill(javafx.scene.paint.Paint.valueOf("blue"));
        label.setAlignment(Pos.CENTER);
        Pane pane = new Pane(label);
        border.setTop(pane);

        // Create the launch button
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(30.0));
        Button start = new Button("Start Adventure!");
        // Launches opening scene
        start.setOnAction(event -> {
            OpeningScene openingScene = new OpeningScene(this.model, this.primaryStage);
            openingScene.startScene();
        });
        grid.add(start, 0, 0);

        // Adds button to the scene
        border.setCenter(start);

        return border;
    }

}
