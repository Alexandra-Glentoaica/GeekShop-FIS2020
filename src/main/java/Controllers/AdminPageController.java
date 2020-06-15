package Controllers;

import Models.Order;
import Models.Product;
import Services.ProductServices;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AdminPageController {
    private static Product selected;

    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<Product,String> productColumn;
    @FXML
    private TableColumn<Product,String> quantityColumn;

    public void initialize(){
        ProductServices.loadProducts();
        ArrayList<Product> products = ProductServices.getProducts();

        tableView.setItems(FXCollections.observableArrayList(products));
        productColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("quantity"));
    }

    public void logOutButton(){
        LoginController.setId(null);

        try{
            Stage primaryStage = (Stage)tableView.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
            primaryStage.setTitle("Login Screen");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void changePrice(){
        selected = tableView.getSelectionModel().getSelectedItem();

        try{
            Stage primaryStage = (Stage)tableView.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("changePrice.fxml"));
            primaryStage.setTitle("Change price");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void addButton(){
        try{
            Stage primaryStage = (Stage)tableView.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addProduct.fxml"));
            primaryStage.setTitle("Add Product");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static Product getSelected() {
        return selected;
    }
}
