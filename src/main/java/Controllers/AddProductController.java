package Controllers;

import Exceptions.ProductAlreadyExists;
import Models.Product;
import Services.ProductServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AddProductController {
    private static String name;
    private static int price;
    private static String type;
    private static int quantity;

    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField typeField;
    @FXML
    private TextField quantityField;
    @FXML
    private Label alertLabel;

    public void backButton(){
        try{
            Stage primaryStage = (Stage)nameField.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("adminPage.fxml"));
            primaryStage.setTitle("Admin Page");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void okButton(){
        ArrayList<Product> p = ProductServices.getProducts();

        try{
            for(Product i:p){
                if(i.getName().equals(nameField.getText())){
                    alertLabel.setText("Product already exists!");
                    throw new ProductAlreadyExists();
                }
            }

            name = nameField.getText();
            price = Integer.parseInt(priceField.getText());
            type = typeField.getText();
            quantity = Integer.parseInt(quantityField.getText());

            if(type.equals("Books")){
                try{
                    Stage primaryStage = (Stage)nameField.getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addBook.fxml"));
                    primaryStage.setTitle("Add Book");
                    primaryStage.setScene(new Scene(root,600,500));
                    primaryStage.show();
                }catch (Exception e){
                    System.out.println(e);
                }
            }else{

            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static String getName() {
        return name;
    }

    public static int getPrice() {
        return price;
    }

    public static String getType() {
        return type;
    }

    public static int getQuantity() {
        return quantity;
    }
}
