package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FormController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField adressField;
    @FXML
    private TextField dateField;
    @FXML
    private ChoiceBox choiceBox;
    @FXML
    private Label alertLabel;

    @FXML
    public void initialize(){
        choiceBox.getItems().addAll("Cash", "Credit Card");
        choiceBox.setValue("Cash");
    }

    @FXML
    public void backButton(){
        try{
            Stage primaryStage = (Stage)choiceBox.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("buyPage.fxml"));
            primaryStage.setTitle("Buy Page");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void buyButton(){
        String date = dateField.getText();
        if(date.length()>4) {
            if (Integer.parseInt(date.substring(date.length() - 4)) < 2002) {
                if (choiceBox.getSelectionModel().getSelectedItem().toString().equals("Cash")) {
                    try{
                        Stage primaryStage = (Stage)dateField.getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("done.fxml"));
                        primaryStage.setTitle("Order Placed");
                        primaryStage.setScene(new Scene(root,600,500));
                        primaryStage.show();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                } else if (choiceBox.getSelectionModel().getSelectedItem().toString().equals("Credit Card")) {
                    try {
                        Stage primaryStage = (Stage) choiceBox.getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("card.fxml"));
                        primaryStage.setTitle("Card Information");
                        primaryStage.setScene(new Scene(root, 600, 500));
                        primaryStage.show();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            } else {
                alertLabel.setText("Minimum age is 18!");
            }
        }
    }
}