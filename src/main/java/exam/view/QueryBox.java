package exam.view;

import exam.presenter.Presenter;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class QueryBox implements View {
    private final int WIDTH = 400;
    private final int HEIGHT = 80;
    private final Stage stage;
    private final Scene scene;

    public QueryBox(String ipAddress, Presenter presenter) {
        Text text1 = new Text(ipAddress + " is in the cache database.");
        Text text2 = new Text("Would you like to use the cached data?");
        Button yes = new Button("Yes");
        yes.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                presenter.getCache(ipAddress);
                /** Close the window */
                ((Stage) yes.getScene().getWindow()).close();
            };
        });
        Button no = new Button("No");
        no.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                presenter.locate(ipAddress);
                /** Close the window */
                ((Stage) yes.getScene().getWindow()).close();
            };
        });

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);

        pane.add(text1, 0, 0, 2, 1);
        pane.add(text2, 0, 1, 2, 1);
        pane.add(no, 0, 2);
        pane.add(yes, 2, 2);

        this.scene = new Scene(pane, WIDTH, HEIGHT);
        this.stage = new Stage();
        this.stage.setScene(this.scene);
        this.stage.setResizable(false);
        this.stage.setTitle("Confirmation!");
        this.stage.show();
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
