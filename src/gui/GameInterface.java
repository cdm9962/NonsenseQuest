package gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
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

    private Stage primaryStage;

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
        primaryStage.setResizable(true);
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
        BorderPane border = new BorderPane();

        Label label = new Label("Welcome to Nonsense Quest!");
        label.setFont(new Font(30));
        label.setTextFill(javafx.scene.paint.Paint.valueOf("blue"));
        label.setAlignment(Pos.CENTER);
        Pane pane = new Pane(label);
        border.setCenter(pane);

        GridPane grid = new GridPane();
        Button start = new Button("Start Adventure!");
        start.setOnAction(event -> {
            OpeningScene openingScene = new OpeningScene(this.model, this.primaryStage);
            openingScene.startScene();
        });
        grid.add(start, 0, 0);

        border.setBottom(start);

        return border;
    }

}
