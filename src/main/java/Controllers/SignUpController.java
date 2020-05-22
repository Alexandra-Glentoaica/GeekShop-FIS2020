package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController {
    @FXML
    private TextField idField;
    @FXML
    private PasswordField passField;
    @FXML
    private ChoiceBox<String> role;

    @FXML
    public void initialize(){
        role.getItems().addAll("Customer", "Administrator");
        role.setValue("Customer");
    }

    @FXML
    public void signUpButton(){
        String id = idField.getText();
        String pass = passField.getText();
        String r = role.getValue();

        if(role.getValue().equals("Customer")){
            //impl add customer
        }
        else if(role.getValue().equals("Administrator")){
            //impl add administrator
        }
    }

    @FXML
    public void backButton() {
        try {
            Stage primaryStage = (Stage) idField.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
            primaryStage.setTitle("Sign Up Screen");
            primaryStage.setScene(new Scene(root, 600, 500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
