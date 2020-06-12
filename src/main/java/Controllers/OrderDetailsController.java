package Controllers;

import Models.Order;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OrderDetailsController {
    @FXML
    private TextField status;
    @FXML
    private TextField product;
    @FXML
    private TextField quantity;
    @FXML
    private TextField name;
    @FXML
    private TextField address;
    @FXML
    private TextField date;
    @FXML
    private TextField payment;

    @FXML
    public void initialize(){
        Order selected = PrevOrdersController.getSelected();

        status.setText(selected.getStatus());
        product.setText(selected.getProduct());
        quantity.setText(String.valueOf(selected.getQuantity()));
        name.setText(selected.getName());
        address.setText(selected.getAddress());
        date.setText(selected.getDate());
        payment.setText(selected.getPayment());
    }

    @FXML
    public void backButton(){
        try{
            Stage primaryStage = (Stage)status.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("prevOrders.fxml"));
            primaryStage.setTitle("Previous Orders");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
