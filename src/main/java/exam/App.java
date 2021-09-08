package exam;

import exam.model.*;
import exam.presenter.*;
import exam.view.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.util.List;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        List<String> args = getParameters().getUnnamed();

        ModelFacade model = null;
        try {
            model = new ModelFacadeImpl(args);
        } catch(FileNotFoundException e) {
            System.out.println(".env file cannot be found!");
            System.exit(0);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        Presenter presenter = new PresenterImpl(model);
        View view = new GMTBox(stage, presenter);

        /** Window Settings */
        stage.setTitle("IP Geolocation => Pastebin");
        stage.setResizable(false);
        /** Closing the main window will terminate all the sub-windows as well. */
        stage.setOnHidden(e -> Platform.exit());
        stage.show();
    }
}
