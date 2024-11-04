import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage escenario) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(".\\vista\\vista.fxml"));

        escenario.setTitle("juego Bola");
        escenario.setScene(new Scene(root, 800, 600));
        escenario.setResizable(false);

        escenario.show();
    }
}
