package Controllers;

import Models.Order;
import Models.Product;
import Services.OrderServices;
import Services.ProductServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.Normalizer;
import java.util.ArrayList;

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
            if(!numberField.getText().equals("")&&!dateField.getText().equals("")&&!cvvField.getText().equals("")) {
                ArrayList<Order> orders = OrderServices.getOrders();
                Order o = new Order(LoginController.getId(), "pending", ShopPageController.getSelected().getName(), BuyPageController.getQuantity(), FormController.getName(), FormController.getAddress(), FormController.getDate(), FormController.getPayment(), numberField.getText(), dateField.getText(), cvvField.getText());
                orders.add(o);
                OrderServices.writeOrders();

                Product p = ShopPageController.getSelected();
                p.setQuantity(p.getQuantity() - BuyPageController.getQuantity());
                ProductServices.writeProducts();

                try {
                    Stage primaryStage = (Stage) numberField.getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("done.fxml"));
                    primaryStage.setTitle("Order Placed");
                    primaryStage.setScene(new Scene(root, 600, 500));
                    primaryStage.show();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }else{
                    alertLabel.setText("One or more fields are empty");
            }
        }
    }
}

