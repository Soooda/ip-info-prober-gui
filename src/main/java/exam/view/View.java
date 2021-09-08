package exam.view;

import javafx.scene.Scene;
import javafx.stage.Stage;

public interface View {
    /**
     * Gets the scene of the View.
     * @return The scene.
     */
    public Scene getScene();

    /**
     * Gets the window of the View.
     * @return The stage.
     */
    public Stage getStage();
}
