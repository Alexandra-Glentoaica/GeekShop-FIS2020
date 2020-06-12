package Controllers;

import Exceptions.IncorrectDataException;
import Models.Client;
import Services.ClientServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class LoginController {
    private static String id;

    @FXML
    private TextField idEntry;
    @FXML
    private PasswordField passEntry;
    @FXML
    private Label label;

    @FXML
    public void initialize(){
        ClientServices.loadClients();
        label.setText("");
    }

    @FXML
    public void signUpButton(){
        try{
            Stage primaryStage = (Stage)idEntry.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("signup.fxml"));
            primaryStage.setTitle("Sign Up Screen");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void loginButton(){
        ArrayList<Client> clients = ClientServices.getClients();
        boolean flag = false;
        String r = null;

        id = idEntry.getText();

        for(Client i:clients){
            if(idEntry.getText().equals(i.getUsername())&&ClientServices.encodePassword(passEntry.getText()).equals(i.getPassword())){
                flag = true;
                r = i.getRole();
            }
        }

        try{
            if(flag){
                if(r.equals("Customer")){
                    try{
                        Stage primaryStage = (Stage)idEntry.getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("shopPage.fxml"));
                        primaryStage.setTitle("Shop Page");
                        primaryStage.setScene(new Scene(root,600,500));
                        primaryStage.show();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                }else{
                    System.out.println("te duce la admin page");
                }
            }else{
                throw new IncorrectDataException();
            }
        }catch (Exception e){
            label.setText("One of the identifying elements is invalid! Please try again!");
        }
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        LoginController.id = id;
    }
}
