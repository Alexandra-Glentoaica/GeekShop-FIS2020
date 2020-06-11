package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CardController {
    @FXML
    private TextField numberField;
    @FXML
    private TextField dateField;
    @FXML
    private PasswordField cvvField;
    @FXML
    private Label alertLabel;

    @FXML
    public void backButton(){
        try{
            Stage primaryStage = (Stage)dateField.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("form.fxml"));
            primaryStage.setTitle("Form Page");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void okButton(){
        if(numberField.getText().length()>19||dateField.getText().length()>10||cvvField.getLength()>3){
            alertLabel.setText("Incorrect data");
        }
        else{
            //done
        }
    }
}
