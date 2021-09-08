package exam.view;

import exam.presenter.Presenter;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class RootView implements View {
    private final int WIDTH = 400;
    private final int HEIGHT = 200;
    private final Scene scene;
    private final Stage stage;

    public RootView(Stage stage, Presenter presenter) {
        this.scene = new Scene(mainLayout(presenter), WIDTH, HEIGHT);
        this.stage = stage;
        this.stage.setScene(this.scene);
    }

    @Override
    public Scene getScene() {
        return this.scene;
    }

    @Override
    public Stage getStage() {
        return this.stage;
    }

    /** 
     * This method organises the layout for main program windows.
     */
    private VBox mainLayout(Presenter presenter) {
        VBox vbox = new VBox();

        /** Config */
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);

        /** Assets */
        Text title = new Text("Please input an IP address!");
        title.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        vbox.getChildren().add(title);

        TextField ip = new TextField("166.171.248.255");
        ip.setPromptText("IPv4 or IPv6");
        vbox.getChildren().add(ip);

        Button locate = new Button("LOCATE");
        locate.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                presenter.confirm(ip.getText());
                /** Clear the input text after clicking the button */
                ip.clear();
            }
        });
        vbox.getChildren().add(locate);

        Text message1 = new Text("Every query will take up one sub-window.");
        Text message2 = new Text("You can spawn as many as you want.");
        // message.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        vbox.getChildren().add(message1);
        vbox.getChildren().add(message2);

        return vbox;
    }
}
