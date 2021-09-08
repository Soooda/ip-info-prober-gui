package exam.presenter;

import exam.entity.IPResponse;
import exam.model.ModelFacade;
import exam.view.*;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Alert;
import java.io.IOException;


public class PresenterImpl implements Presenter {
    private final ModelFacade model;
    private final Alert alert;

    public PresenterImpl(ModelFacade model) {
        this.model = model;
        this.alert = new Alert(Alert.AlertType.NONE);
    }

    @Override
    public void error(String message) {
        alert.setHeaderText(message);
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.showAndWait();
    }

    @Override
    public void confirm(String ipAddress) {
        /** If the IP is not in the cache */
        if(!model.isCached(ipAddress)) {
            locate(ipAddress);
        } else {
            new QueryBox(ipAddress, this);
        }
    }

    @Override
    public void locate(String ipAddress) {
        ResponseView window = new ResponseView(this);

        /** Model Thread */
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                final IPResponse response;
                try {
                    response = model.locate(ipAddress);
                } catch(IllegalArgumentException | IOException e) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            window.getStage().close();
                            error(e.getMessage());
                        };
                    });
                    return null;
                }
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        window.update(response);
                    };
                });
                return null;
            }
        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }

    @Override
    public void getCache(String ipAddress) {
        ResponseView window = new ResponseView(this);

        /** Model Thread */
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                IPResponse response = model.getCache(ipAddress);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        window.update(response);
                    }
                });
                return null;
            }
        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }

    @Override
    public void generateReport(IPResponse ipResponse) {
        ReportView window = new ReportView();

        /** Model Thread */
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                final String reply;
                try {
                    reply = model.generateReport(ipResponse);
                } catch(IllegalArgumentException | IOException e) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            window.getStage().close();
                            error(e.getMessage());
                        };
                    });
                    return null;
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        window.update(reply);
                    }
                });
                return null;
            }
        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }

    @Override
    public void setGMT(int gmt) throws IllegalArgumentException {
        model.setGMT(gmt);
    };
}
