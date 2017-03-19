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
    public static final Font PIXEL_FONT_SMALL = Font.loadFont(GameInterface.class.getResource("pixelfont.ttf").toExternalForm(), 20);

    // Constant values
    public static final String TITLE = "Nonsense Quest";
    public static final String INTRO_LABEL = "Welcome to Nonsense Quest!";
    public static final String INTRO_BUTTON_LABEL = "Start Adventure!";
    public static final int DEFAULT_INSETS = 50;
    public static final int STAGE_SIZE = 1000;

    // JavaFx color values
    public static final String COLOR_GRAY = "-fx-background-color: GRAY;";
    public static final String PAINT_BLUE = "blue";

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
        primaryStage.setHeight(STAGE_SIZE);
        primaryStage.setWidth(STAGE_SIZE);
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
        border.setPadding(new Insets(DEFAULT_INSETS));
        border.setStyle(COLOR_GRAY);

        // Create the top title label
        Label label = new Label(INTRO_LABEL);
        label.setPadding(new Insets(DEFAULT_INSETS));
        label.setFont(PIXEL_FONT_LARGE);
        label.setTextFill(Paint.valueOf(PAINT_BLUE));
        label.setAlignment(Pos.CENTER);
        Pane pane = new Pane(label);
        border.setTop(pane);

        // Create the launch button
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(DEFAULT_INSETS));
        Button start = new Button(INTRO_BUTTON_LABEL);
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
