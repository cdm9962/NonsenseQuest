package gui;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

/**
 * Class to help create and modify button attributes.
 *
 * @author Connor D. Milligan
 */
public class ButtonHelper {
    // The button to modify
    private Button button;


    /**
     * Constructor for the ButtonHelper.
     */
    public ButtonHelper(){
        this.button = null;
    }


    /**
     * Method to create a normal sized wood button.
     * @param button Button object representing the button to modify
     */
    public void setNormalButton(Button button) {
        button.setMinSize(200, 30);
        button.setFont(GameInterface.PIXEL_FONT_SMALL);
        button.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource(GameInterface.WOOD_BUTTON_FILE).toExternalForm()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }
}
