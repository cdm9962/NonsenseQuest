package gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
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

    // Constant string values
    public static final String TITLE = "Nonsense Quest";

    /**
     * Constructor for the game interface.
     */
    public GameInterface(){
        this.model = new GameModel();
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(TITLE);
        primaryStage.setScene(new Scene(makeBorder()));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    /**
     * Method to create the scene of the application.
     * @return BorderPane representing the elements of the scene
     */
    private BorderPane makeBorder(){
        BorderPane border = new BorderPane();
        border.setTop(makeTopLabel());
        return border;
    }

    /**
     * Method to create the title bar for the application.
     * @return Pane representing the top element of the border pane
     */
    private Pane makeTopLabel(){
        Label label = new Label("Welcome to Nonsense Quest!");
        label.setFont(new Font(30));
        label.setTextFill(javafx.scene.paint.Paint.valueOf("blue"));
        label.setAlignment(Pos.CENTER);
        Pane pane = new Pane(label);
        return pane;
    }
}
