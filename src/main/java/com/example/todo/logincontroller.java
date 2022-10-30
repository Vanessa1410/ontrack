package com.example.todo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.example.todo.HelloController.setUsername;


    public class logincontroller extends NullPointerException{

        @FXML
        private PasswordField password;
        @FXML
        private TextField username;



        @FXML
        private Label errorpassword;

        @FXML
        private Label errorusername;


        private Parent root;
        private Stage stage;
        private Scene scene;



        public void onLoginButtonClick(ActionEvent event) throws IOException {
            if (!username.getText().isBlank() && !password.getText().isBlank()){
                validateLogin(event);
            }
            else if (username.getText().isBlank() && password.getText().length()==0) {
                errorusername.setText("⚠ Please enter username!");
                username.setStyle("-fx-border-color: #00ffff; -fx-border-width: 2px");
                errorpassword.setText("⚠ Please enter password!");
                password.setStyle("-fx-border-color: #00ffff; -fx-border-width: 2px");
            }
            else if (username.getText().length()==0) {
                errorusername.setText("⚠ Please enter username!");
                username.setStyle("-fx-border-color: #00ffff; -fx-border-width: 2px");
                errorpassword.setText("");
                password.setStyle("");
            }
            else if (password.getText().length()==0) {
                errorusername.setText("");
                username.setStyle("");
                errorpassword.setText("⚠ Please enter password!");
                password.setStyle("-fx-border-color: #00ffff; -fx-border-width: 2px");
            }
        }

        private void validateLogin(ActionEvent event) {
            DBConnect connectnow = new DBConnect();
            Connection connectdb = connectnow.getConnection();
            String verifylogin = "select count(1) from ontrackdb_1.user_details where username = '" + username.getText() + "' and password = '" + password.getText() + "'";

            Statement statement = null;
            try {
                statement = connectdb.createStatement();
                ResultSet queryResult = statement.executeQuery(verifylogin);
                while(queryResult.next()){
                    if (queryResult.getInt(1)==1){
                        try {
                            String u = (username.getText());
                            root = FXMLLoader.load(getClass().getResource("home.fxml")); //pass scene name here
                            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                            System.out.println(u);
                            setUsername(String.valueOf(u));

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                    else {
                        errorusername.setText("");
                        username.setStyle("-fx-border-color: #00ffff; -fx-border-width: 2px");
                        username.setText("");
                        errorpassword.setText("⚠ Invalid User!");
                        password.setStyle("-fx-border-color: #00ffff; -fx-border-width: 2px");
                        password.setText("");
                    }

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        /*
        public void switchToForgotPassword(ActionEvent event) throws IOException {
            root = FXMLLoader.load(getClass().getResource("forgot_password.fxml")); //pass scene name here
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.show();
            stage.setScene(scene);
            stage.show();
        }
        */
        @FXML
        public void switchTosignup(ActionEvent event) throws IOException {
            root = FXMLLoader.load(getClass().getResource("signup.fxml")); //pass scene name here
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


    }




