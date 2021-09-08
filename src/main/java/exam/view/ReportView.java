package exam.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/** 
 * This class provides the view of a pop up box for displaying pastebin link.
 */
public class ReportView implements URLView {
    private final int WIDTH = 400;
    private final int HEIGHT = 60;
    private final Stage stage;
    private final Scene scene;
    private final TextField URL;

    public ReportView() {
        this.URL = new TextField();
        this.URL.setEditable(false);

        VBox vbox = new VBox();

        /** Config */
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(this.URL);

        this.scene = new Scene(vbox, WIDTH, HEIGHT);
        this.stage = new Stage();
        this.stage.setScene(this.scene);
        this.stage.setResizable(false);
        this.stage.setTitle("Loading");
        this.stage.show();
    }

    @Override
    public Stage getStage() {
        return this.stage;
    }

    @Override
    public Scene getScene() {
        return this.scene;
    }

    @Override
    public void update(String url) {
        this.stage.setTitle(url);

        this.URL.setText(url);
    }
}
