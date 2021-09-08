package exam.view;

import exam.presenter.Presenter;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GMTBox implements View {
    private final int WIDTH = 400;
    private final int HEIGHT = 80;
    private final Stage stage;
    private final Scene scene;

    public GMTBox(Stage stage, Presenter presenter) {
        ObservableList<Integer> options = FXCollections.observableArrayList(
                -12,
                -11,
                -10,
                -9,
                -8,
                -7,
                -6,
                -5,
                -4,
                -3,
                -2,
                -1,
                0,
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10,
                11,
                12);
        ComboBox<Integer> gmt = new ComboBox<>(options);
        gmt.setPromptText("Select a GMT offset");

        Button confirm = new Button("Confirm");
        confirm.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                try {
                    presenter.setGMT(gmt.getValue());
                } catch(IllegalArgumentException e) {
                    presenter.error(e.getMessage());
                }
                View view = new RootView(stage, presenter);
            };
        });

        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(gmt);
        vbox.getChildren().add(confirm);

        this.scene = new Scene(vbox, WIDTH, HEIGHT);
        this.stage = stage;
        this.stage.setScene(scene);
    }

    @Override
    public Scene getScene() {
        return this.scene;
    }

    @Override
    public Stage getStage() {
        return this.stage;
    }
}
