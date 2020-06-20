package Controllers;

import Models.Item;
import Models.Product;
import Services.ProductServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AddItemController {
    @FXML
    TextField materialField;
    @FXML
    TextField colorField;
    @FXML
    TextField sizeField;

    public void backButton(){
        try{
            Stage primaryStage = (Stage)materialField.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addProduct.fxml"));
            primaryStage.setTitle("Add Product");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void okButton(){
        ArrayList<Product> products = ProductServices.getProducts();
        Item aux = new Item(AddProductController.getName(),AddProductController.getPrice(),AddProductController.getType(),AddProductController.getQuantity(),materialField.getText(),colorField.getText(),sizeField.getText());

        products.add(aux);
        ProductServices.writeProducts();

        try{
            Stage primaryStage = (Stage)materialField.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("adminPage.fxml"));
            primaryStage.setTitle("Admin Page");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
