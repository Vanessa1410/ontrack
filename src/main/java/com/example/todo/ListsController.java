package com.example.todo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class ListsController {

    @FXML
    private Button lists;


    @FXML
    private RadioButton personal;

    @FXML
    private RadioButton grocery;

    @FXML
    private RadioButton work;

    @FXML
    public  void switchTolists(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("lists.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }


    @FXML
    public  void switchTolistspersonal(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("listspersonal.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    public  void switchTolistsgrocerys(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("listsgrocerys.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    public  void switchTolistswork(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("listswork.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
