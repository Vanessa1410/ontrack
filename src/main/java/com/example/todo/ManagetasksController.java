package com.example.todo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManagetasksController {


    @FXML
    private Button deletebutton;

    @FXML
    private Button editbutton;

    @FXML
    private Button profile;

    @FXML
    private Button home;

    @FXML
    private Button lists;

    @FXML
    private Button trash;

    @FXML
    private Button managetasks;

    @FXML
    private Label statuslabel;

    @FXML
    private TextField title;

    @FXML
    private TextField startdate;

    @FXML
    private TextField enddate;

    @FXML
    private TextField list;

    @FXML
    private TextField searchtitle;

    @FXML
    private TextField tag;

    @FXML
    private TextField description;


    public ManagetasksController() {
    }

    public void button(ActionEvent event) {
        if (event.getSource() == this.editbutton) {
            this.EditTaskDetails();
        } else if (event.getSource() == this.deletebutton) {
            this.DeleteTaskDetails();
        }

    }

    @FXML
    private void search(ActionEvent event) {
        DBConnect connection = new DBConnect();
        Connection connectDB = connection.getConnection();
        String getename = "SELECT * FROM task_details where title='" + this.searchtitle.getText() +"'";
        System.out.println(getename);

        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(getename);
            System.out.println("search query works");

            while (resultSet.next()) {

                this.title.setText(resultSet.getString("title"));
                this.startdate.setText(resultSet.getString("startdate"));
                this.enddate.setText(resultSet.getString("enddate"));
                this.list.setText(resultSet.getString("list"));
                this.tag.setText(resultSet.getString("tag"));
                this.description.setText(resultSet.getString("description"));
                System.out.println("search works?");
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }

    private void EditTaskDetails() {
        DBConnect connectnow = new DBConnect();
        Connection connectdb = connectnow.getConnection();
        String var10000 = this.searchtitle.getText();
        String query = "UPDATE task_details SET title ='"+var10000+"' , startdate ='"+this.startdate.getText()+"', enddate ='"+this.enddate.getText()+"', list ='"+this.list.getText()+"', description ='"+this.description.getText()+"' WHERE title ='"+this.searchtitle.getText()+"'";
        System.out.println(query);
        this.executeQuery(query);
        System.out.println("edit query works");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.title.setText("");
        this.startdate.setText("");
        this.enddate.setText("");
        this.list.setText("");
        this.tag.setText("");
        this.description.setText("");
        //this.statuslabel.setText("");
        this.searchtitle.setText("");
        this.statuslabel.setText("Updated Successfully");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.statuslabel.setText("");




    }

    private void executeQuery(String query) {
        DBConnect connectnow = new DBConnect();
        Connection connectdb = connectnow.getConnection();

        try {
            Statement statement = connectdb.createStatement();
            statement.executeUpdate(query);
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }

    private void DeleteTaskDetails() {
        DBConnect connectnow = new DBConnect();
        Connection connectdb = connectnow.getConnection();
       // String query = "Delete from task_details where title ='"+this.searchtitle.getText()+"'";
        String query = "UPDATE task_details SET isDeleted = '1' WHERE title ='"+this.searchtitle.getText()+"'";
        System.out.println(query);
        this.executeQuery(query);
        this.statuslabel.setText("Deleted Successfully");

        this.title.setText("");
        this.startdate.setText("");
        this.enddate.setText("");
        this.list.setText("");
        this.tag.setText("");
        this.description.setText("");
        //this.statuslabel.setText("");
        this.searchtitle.setText("");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.statuslabel.setText("");


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
