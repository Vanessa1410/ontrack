package com.example.todo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class ListsPersonalController implements Initializable {
        @FXML
        private TableView<TaskDetailsinfo> table;
        @FXML
        private TableColumn<TaskDetailsinfo, String> description;
        @FXML
        private TableColumn<TaskDetailsinfo, String> title;
        @FXML
        private TableColumn<TaskDetailsinfo, String> startdate;
        @FXML
        private TableColumn<TaskDetailsinfo, String> enddate;
        @FXML
        private TableColumn<TaskDetailsinfo, String> list;
        @FXML
        private TableColumn<TaskDetailsinfo, String> tag;
        final ObservableList<TaskDetailsinfo> listview = FXCollections.observableArrayList();

        public ListsPersonalController() {
        }

        public void initialize(URL url, ResourceBundle rb) {
            this.title.setCellValueFactory(new PropertyValueFactory("title"));
            this.startdate.setCellValueFactory(new PropertyValueFactory("startdate"));
            this.enddate.setCellValueFactory(new PropertyValueFactory("enddate"));
            this.list.setCellValueFactory(new PropertyValueFactory("list"));
            this.tag.setCellValueFactory(new PropertyValueFactory("tag"));
            this.description.setCellValueFactory(new PropertyValueFactory("description"));
            System.out.println("initialize done");
            try {
                DBConnect connectnow = new DBConnect();
                Connection connectdb = connectnow.getConnection();
                String sql = "SELECT * FROM ontrackdb_1.task_details where list='Personal' and isDeleted =0";
                Statement s = connectdb.createStatement();
                ResultSet resultSet = s.executeQuery(sql);
                System.out.println("query working");
                while (resultSet.next()) {
                    this.listview.add(new TaskDetailsinfo(resultSet.getString("title"), resultSet.getString("startdate"), resultSet.getString("enddate"), resultSet.getString("list"), resultSet.getString("tag"), resultSet.getString("description")));
                }

                this.table.setItems(this.listview);
            } catch (Exception var8) {
                var8.printStackTrace();
            }

        }


    /*protected void OnPersonalClick(ActionEvent e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("listspersonal.fxml"));
            ((Node)e.getSource()).getScene().getWindow().hide();
            Parent root1 = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }*/

        @FXML
        private Button lists;

        @FXML
        private Button trash;




        @FXML
        public void switchTolists(ActionEvent event) throws IOException {

            Parent root = FXMLLoader.load(getClass().getResource("lists.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }


        @FXML
        public void OnPersonalClick(ActionEvent event) throws IOException {

            Parent root = FXMLLoader.load(getClass().getResource("listspersonal.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }

        @FXML
        public void switchTolistsgrocerys(ActionEvent event) throws IOException {

            Parent root = FXMLLoader.load(getClass().getResource("listsgrocerys.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }

        @FXML
        public void switchTolistswork(ActionEvent event) throws IOException {

            Parent root = FXMLLoader.load(getClass().getResource("listswork.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }
    @FXML
    public  void switchTohome(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    @FXML
    public  void switchToprofile(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("profile.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    @FXML
    public void switchTotrash(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("trash.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    @FXML
    public void switchTomanagetasks(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("managetasks.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}

