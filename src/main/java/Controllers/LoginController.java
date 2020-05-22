package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField idEntry;
    @FXML
    private PasswordField passEntry;

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

}
