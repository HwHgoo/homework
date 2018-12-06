package controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    protected TabPane tabPane;

    @FXML
    public ArrayList openDBFile(){
        ArrayList list = new ArrayList();
        list.add("test");
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/OpenDBFile.fxml"));
            Stage stage = new Stage();
            stage.setTitle("open from database");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @FXML
    public void addTab(String tableName){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/OpenDBFile.fxml"));
            loader.load();
            OpenDBFileController controller = loader.getController();
            Tab tab = new Tab(tableName);
            tab.setContent(controller.formTable(tableName));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tabPane.addEventHandler(Event.ANY, event -> {
            if (!event.getSource().equals("test"))
                System.out.println("fkkk");
            else
                System.out.println("yoooou");
        });
    }
}
