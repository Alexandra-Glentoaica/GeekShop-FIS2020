package Controllers;

import Models.Order;
import Services.OrderServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FormController {
    private static String name;
    private static String address;
    private static String date;
    private static String payment;

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
    public void initialize() {
        choiceBox.getItems().addAll("Cash", "Credit Card");
        choiceBox.setValue("Cash");
    }

    @FXML
    public void backButton() {
        try {
            Stage primaryStage = (Stage) choiceBox.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("buyPage.fxml"));
            primaryStage.setTitle("Buy Page");
            primaryStage.setScene(new Scene(root, 600, 500));
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void buyButton() {
        payment = choiceBox.getSelectionModel().getSelectedItem().toString();
        if (payment.equals("Cash")) {
            name = nameField.getText();
            address = adressField.getText();
            date = dateField.getText();

            ArrayList<Order> orders = OrderServices.getOrders();
            Order o = new Order("pending", ShopPageController.getSelected().getName(), BuyPageController.getQuantity(), name, address, date, payment);
            orders.add(o);
            OrderServices.writeOrders();

            try {
                Stage primaryStage = (Stage) dateField.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("done.fxml"));
                primaryStage.setTitle("Order Placed");
                primaryStage.setScene(new Scene(root, 600, 500));
                primaryStage.show();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (payment.equals("Credit Card")) {
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
    }
}
