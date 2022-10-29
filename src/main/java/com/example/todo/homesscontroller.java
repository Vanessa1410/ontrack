package com.example.todo;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class homesscontroller extends NullPointerException {
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
    private TextField description;

    @FXML
    private DatePicker startdate;

    @FXML
    private DatePicker enddate;


    public void onCreatetaskButtonClick(ActionEvent event) throws IOException {
        String title = this.title.getText();
        LocalDate startdateValue = this.startdate.getValue();
        System.out.println(startdateValue);
        LocalDate enddateValue = this.enddate.getValue();
        System.out.println(enddateValue);
        String list = this.list.getText();
        String tag = this.tag.getText();
        String description = this.description.getText();


        DBConnect connectnow = new DBConnect();
        Connection connectdb = connectnow.getConnection();
        Statement statement = null;
        // PreparedStatement String;
        PreparedStatement pinsert = null;
        PreparedStatement pscheck = null;
        ResultSet resultSet = null;

        Alert alert;
        if (this.title.getText().isBlank()
            /*&& this.list.getText().isBlank() && this.tag.getText().isBlank() && this.description.getText().isBlank()*/
        ) {
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate title");
            alert.setHeaderText((String) null);
            alert.setContentText("Please Enter Details!");
            alert.showAndWait();
        } else if (this.validatetitle()
            /*&& this.validatebookid() && this.validateisbn() && this.validateauthor() && this.validategenre() && this.validatenoofcopies()*/
        ) {
            try {
                /*pscheck = connectdb.prepareStatement("select * from addbook where BookID= ?");
                pscheck.setString(1, BookId);
                resultSet = pscheck.executeQuery();
                if (resultSet.isBeforeFirst()) {
                    System.out.println("There Exists Already A Book With The Given ID");
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("BookID Already Exists");
                    alert.show();
                } else {*/
                PreparedStatement psinsert = connectdb.prepareStatement("INSERT INTO ontrackdb_1.task_details VALUES (?,?,?,?,?,?)");
                psinsert.setString(1, title);
                psinsert.setDate(2, Date.valueOf(startdateValue));
                psinsert.setDate(3, Date.valueOf(enddateValue));
                psinsert.setString(4, list);
                psinsert.setString(5, tag);
                psinsert.setString(6, description);
                psinsert.executeUpdate();
                    /*this.AddBookLabel.setText("Book Added Successfully!");
                    this.title.clear();
                    this.startdate.clear();
                    this.enddate.clear();
                    this.list.clear();
                    this.tag.clear();
                    this.description.clear();
                    */

            } catch (SQLException e) {
                throw new RuntimeException(e);
                //Logger.getLogger(AddBrandController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }







    private boolean validatetitle() {
        if (this.title.getText().length() > 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate title");
            alert.setHeaderText((String) null);
            alert.setContentText("PLease enter valid title");
            alert.showAndWait();
            return false;
        }
    }


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

