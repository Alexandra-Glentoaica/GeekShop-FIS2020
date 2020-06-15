package Controllers;

import Models.Book;
import Models.Product;
import Services.ProductServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AddBookController {
    @FXML
    private TextField authorField;
    @FXML
    private TextField languageField;
    @FXML
    private TextField publisherField;

    public void backButton(){
        try{
            Stage primaryStage = (Stage)authorField.getScene().getWindow();
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
        Book aux = new Book(AddProductController.getName(),AddProductController.getPrice(),AddProductController.getType(),AddProductController.getQuantity(),authorField.getText(),languageField.getText(),publisherField.getText());
        products.add(aux);
        ProductServices.writeProducts();

        try{
            Stage primaryStage = (Stage)authorField.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("adminPage.fxml"));
            primaryStage.setTitle("Admin Page");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
