package WordleProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Wordle extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/WordleProject/WordleView.fxml"));
        VBox root = loader.load();
        Scene scene = new Scene(root, 600, 700);

        scene.getStylesheets().add(getClass().getResource("/WordleProject/wordle.css").toExternalForm());

        primaryStage.setTitle("Wordle Game");

        Image appIcon = new Image(getClass().getResource("/WordleProject/WordleLogo2.png").toExternalForm());

        primaryStage.getIcons().add(appIcon);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
