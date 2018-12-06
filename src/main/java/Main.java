import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
//    private double xOffset = 0;
//    private double yOffset = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/MainPage.fxml"));
//        primaryStage.initStyle(null);
        Scene scene = new Scene(root,1193, 713);

//        root.setOnMousePressed(event -> {
//            xOffset = event.getSceneX();
//            yOffset = event.getSceneY();
//        });
//
//        root.setOnMouseDragged(event -> {
//            primaryStage.setX(event.getScreenX() - xOffset);
//            primaryStage.setY(event.getScreenY() - yOffset);
//        });
        primaryStage.getIcons().addAll(new Image("/pics/panda.png"));
        primaryStage.setTitle(" DataMining Homework");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
