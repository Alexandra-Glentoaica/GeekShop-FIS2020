package Controllers;

import Exceptions.InssuficentStock;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BuyPageController {
    private static int quantity;

    @FXML
    Label label;
    @FXML
    Label alertLabel;
    @FXML
    TextField textField;


    @FXML
    public void initialize(){
        label.setText(ShopPageController.getSelected().getName());
        alertLabel.setText("");
    }

    @FXML
    public void backButton(){
        try{
            Stage primaryStage = (Stage)label.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("shopPage.fxml"));
            primaryStage.setTitle("Shop Page");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void formButton(){
        try {
            quantity = Integer.parseInt(textField.getText());
            if (quantity <= ShopPageController.getSelected().getQuantity()) {
                try {
                    Stage primaryStage = (Stage) label.getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("form.fxml"));
                    primaryStage.setTitle("Form Page");
                    primaryStage.setScene(new Scene(root, 600, 500));
                    primaryStage.show();
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                alertLabel.setText("Not enough stock!");
                try {
                    throw new InssuficentStock();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e){
            alertLabel.setText("Quantity should be integer!");
        }


    }

    public static int getQuantity() {
        return quantity;
    }
}
