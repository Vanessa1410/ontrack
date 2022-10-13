package com.example.todo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class homecontroller extends NullPointerException {
    @FXML
    private MenuButton list;
    @FXML
    private MenuButton tag;

    public String listChoice = "Personal";
    public String tagChoice = "Personal";

    public void Personal(ActionEvent event){
        list.setText("Personal");
        listChoice = "Personal";
    }
    public void Personal1(ActionEvent event){
        tag.setText("Personal");
        tagChoice = "Personal";
    }

    private String listChoice2 = "Grocery";

    @FXML
    private void Grocery(ActionEvent event){
        list.setText("Grocery");
        listChoice2 = "Grocery";
    }
    private String listChoice3 = "Work";

    @FXML
    private void Work(ActionEvent event){
        list.setText("Work");
        listChoice3 = "Work";
    }

    private String tagChoice2 = "Important";

    @FXML
    private void Important(ActionEvent event){
        tag.setText("Important");
        tagChoice2 = "Important";
    }
    private String tagChoice3 = "Work";

    @FXML
    private void Work1(ActionEvent event){
        tag.setText("Work");
        tagChoice3 = "Work";
    }


    @FXML
    private TextField title;

    @FXML
    private Label errortitle;


    @FXML
    private TextField description;


    public void onCreatetaskButtonClick(ActionEvent event) throws IOException{

        System.out.println("Button clicked!");
        //if ( !title.getText().isBlank()){
            //validateSignUp(event);

            if(title.getText().isBlank()){
                errortitle.setText("⚠ Please enter task!");
                title.setStyle("-fx-background-color: #CCFFFF; -fx-border-width: 2px");
            }
            else {
                errortitle.setText(null);
                title.setStyle(null);
            }

    }


    @FXML
    public  void switchTohome(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public  void switchTolists(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("lists.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    public  void switchToprofile(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("profile.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
