package controller;

import entities.Student;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import service.GetStudents_ServiceImpl;
import service.GetTables_ServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class OpenDBFileController implements Initializable {
    @FXML
    private TreeView treeView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TreeItem<String> rootItem = new TreeItem<>("DataMining");
        treeView.setRoot(rootItem);

        List<String> list = new GetTables_ServiceImpl().getTables();
        for (String str : list) {
            TreeItem<String> item = new TreeItem<>(str);
            rootItem.getChildren().add(item);
        }
    }

    protected TableView<Student> formTable(String tableName) {
        TableView<Student> table = new TableView<>();
        ArrayList<Student> students = new GetStudents_ServiceImpl().getStudents(tableName);
        ArrayList<TableColumn<Student, Object>> cols = new ArrayList<>();
        //add id col
        TableColumn<Student, Object> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, Object>, ObservableValue<Object>>() {
            @Override
            public ObservableValue<Object> call(TableColumn.CellDataFeatures<Student, Object> param) {
                return new SimpleObjectProperty<>(param.getValue().getId());
            }
        });
        cols.add(idCol);

        //get other col names
        HashMap<String, Object> map = students.get(1).getAttributes();
        ArrayList<String> names = new ArrayList<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            names.add(entry.getKey());
        }

        for (String colName : names) {
            TableColumn<Student, Object> column = new TableColumn<>(colName);
            column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, Object>, ObservableValue<Object>>() {
                @Override
                public ObservableValue<Object> call(TableColumn.CellDataFeatures<Student, Object> param) {
                    return new SimpleObjectProperty<>(param.getValue().getAttributes().get(colName));
                }
            });
            cols.add(column);
        }

        ObservableList<Student> items = FXCollections.observableList(students);
        table.getColumns().addAll(cols);
        table.getItems().addAll(items);

        return table;
    }
//
//    protected Tab formTab() {
//        TreeItem<String> treeItem = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();
//        if (!treeItem.isLeaf())
//            return null;
//        treeView.getScene().getWindow().hide();
//        String tableName = treeItem.getValue();
//        Tab tab = new Tab(tableName);
//        tab.setContent(formTable(tableName));
//        return tab;
//    }

    @FXML
    private void forwardInfo(MouseEvent event) {
        if (event.getClickCount() == 2) {
//            System.out.println(11);
            TabPane pane = null;
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/view/MainPage.fxml"));
                loader.load();
                MainPageController controller = loader.getController();
                pane = controller.tabPane;
            } catch (IOException e) {
                e.printStackTrace();
            }
//            MouseEvent mouseEvent = new MouseEvent(MouseEvent.MOUSE_CLICKED,
//                    0, 0, 0, 0, MouseButton.PRIMARY, 10,
//                    true, true, true, true, true,
//                    true, true, true, true, true, null);
            Event firedEvent = new Event("test",null,Event.ANY);
            Event.fireEvent(pane,firedEvent);
        }
    }

}


