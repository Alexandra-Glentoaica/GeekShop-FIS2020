package Controllers;

import Models.Client;
import Services.ClientServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

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
        Client c = new Client(idField.getText(), passField.getText(), role.getValue());

        ArrayList<Client> clients = ClientServices.getClients();
        clients.add(c);

        ClientServices.writeClients();
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
