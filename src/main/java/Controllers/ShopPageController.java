package Controllers;

import Models.Product;
import Services.ProductServices;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ShopPageController {
    private ArrayList<Product> products = new ArrayList<>();

    @FXML
    private ChoiceBox choiceBox;
    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<Product,String> nameColumn;

    @FXML
    public void initialize(){
        ProductServices.loadProducts();
        products = ProductServices.getProducts();

        choiceBox.getItems().addAll("Books", "Funko-Pop Figurines", "Geek Accessories", "Stationery", "Board Games");
        choiceBox.setValue("Books");
    }

    @FXML
    public void logoutButton(){
        try{
            Stage primaryStage = (Stage)choiceBox.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
            primaryStage.setTitle("Login Screen");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void afisare(){
        ArrayList<Product> sortedProducts = new ArrayList<>();

        for(Product i:products){
            if(i.getType().equals(choiceBox.getValue())){
                sortedProducts.add(i);
            }
        }

        tableView.setItems(FXCollections.observableArrayList(sortedProducts));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
    }

    @FXML
    public void afisareDetalii(){

    }
}
