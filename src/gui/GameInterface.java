package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import model.GameModel;

/**
 * The graphical user interface for the game. Displays the game data.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class GameInterface extends Application {
    // The game model for the graphical user interface
    private GameModel model;

    // The application stage
    private Stage primaryStage;

    // Custom resources values
    public static final Font PIXEL_FONT_LARGE = Font.loadFont(GameInterface.class.getResource("/images/uiResources/pixelfont.ttf").toExternalForm(), 40);
    public static final Font PIXEL_FONT_MEDIUM = Font.loadFont(GameInterface.class.getResource("/images/uiResources/pixelfont.ttf").toExternalForm(), 30);
    public static final Font PIXEL_FONT_SMALL = Font.loadFont(GameInterface.class.getResource("/images/uiResources/pixelfont.ttf").toExternalForm(), 20);
    public static final String SPLASH_FILE = "/images/uiResources/splash.png";
    public static final String WOOD_BUTTON_FILE = "/images/uiResources/woodbutton.png";
    public static final String SPLASH_SONG = "/audio/testtheme.wav";

    // Constant String values
    public static final String TITLE = "Nonsense Quest";
    public static final String INTRO_LABEL = "Welcome to Nonsense Quest!";
    public static final String INTRO_BUTTON_LABEL = "Start Adventure!";

    // Constant number values
    public static final double DEFAULT_INSETS = 50.0;
    public static final double NO_INSETS = 0.0;
    public static final double CENTER_INSETS = 800.0;
    public static final double BUTTON_INSETS = 3.0;
    public static final int STAGE_HEIGHT = 900;
    public static final int STAGE_WIDTH = 1600;

    // JavaFx color values
    public static final String COLOR_GRAY = "-fx-background-color: gray;";
    public static final String PAINT_BLUE = "blue";

    /**
     * Constructor for the game interface.
     */
    public GameInterface(){
        model = null;
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(TITLE);
        primaryStage.setScene(new Scene(makeSplash(), STAGE_WIDTH, STAGE_HEIGHT));
        primaryStage.setHeight(STAGE_HEIGHT);
        primaryStage.setWidth(STAGE_WIDTH);
        primaryStage.setResizable(false);
        primaryStage.show();
        this.primaryStage = primaryStage;
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    /**
     * Method to create the title screen for the application.
     * @return Pane representing the top element of the border pane
     */
    private BorderPane makeSplash(){
        // Create the border pane
        BorderPane border = new BorderPane();
        border.setPadding(new Insets(DEFAULT_INSETS));

        // Create the background image
        BackgroundImage splash = new BackgroundImage(new Image(getClass().getResource(SPLASH_FILE).toExternalForm(), 1600, 900, false, false),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        border.setBackground(new Background(splash));

        // Create the launch button
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(DEFAULT_INSETS));
        Button start = new Button(INTRO_BUTTON_LABEL);
        start.setFont(PIXEL_FONT_SMALL);
        start.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource(WOOD_BUTTON_FILE).toExternalForm()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

        // Launches opening scene
        start.setOnAction(event -> {
            OpeningScene openingScene = new OpeningScene(model, primaryStage);
            openingScene.startScene();
        });
        grid.add(start, 0, 0);

        // Adds button to the scene
        AnchorPane anchor = new AnchorPane(grid);
        AnchorPane.setBottomAnchor(grid, 10.0);
        AnchorPane.setRightAnchor(grid, 575.0);
        border.setBottom(anchor);

        // Adds theme music to the game scene
        AudioClip audio = new AudioClip(getClass().getResource(SPLASH_SONG).toExternalForm());
        audio.setVolume(0.5f);
        audio.setRate(2.0);
        audio.setCycleCount(AudioClip.INDEFINITE);
        audio.play();

        return border;
    }
}