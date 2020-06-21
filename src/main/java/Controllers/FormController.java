package Controllers;

import Models.Order;
import Models.Product;
import Services.OrderServices;
import Services.ProductServices;
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
    private static String mail;

    @FXML
    TextField nameField;
    @FXML
    TextField mailField;
    @FXML
    TextField adressField;
    @FXML
    TextField dateField;
    @FXML
    ChoiceBox choiceBox;
    @FXML
    Label alertLabel;

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
        name = nameField.getText();
        address = adressField.getText();
        date = dateField.getText();
        mail = mailField.getText();

        if(!nameField.getText().equals("")&&!adressField.getText().equals("")&&!dateField.getText().equals("")&&!mailField.getText().equals("")) {
            if (payment.equals("Cash")) {
                ArrayList<Order> orders = OrderServices.getOrders();
                Order o = new Order(LoginController.getId(), "pending", ShopPageController.getSelected().getName(), BuyPageController.getQuantity(), name, address, date, payment,mail);
                orders.add(o);
                OrderServices.writeOrders();

                Product p = ShopPageController.getSelected();
                p.setQuantity(p.getQuantity() - BuyPageController.getQuantity());
                ProductServices.writeProducts();

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
        }else{
            alertLabel.setText("One or more fields are empty");
        }
    }

    public static String getName() {
        return name;
    }

    public static String getAddress() {
        return address;
    }

    public static String getDate() {
        return date;
    }

    public static String getPayment() {
        return payment;
    }

    public static String getMail() {
        return mail;
    }

    public static void setName(String name) {
        FormController.name = name;
    }

    public static void setAddress(String address) {
        FormController.address = address;
    }

    public static void setDate(String date) {
        FormController.date = date;
    }

    public static void setPayment(String payment) {
        FormController.payment = payment;
    }

    public static void setMail(String mail) {
        FormController.mail = mail;
    }
}
