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
    private static ArrayList<Product> products = new ArrayList<>();
    private static Product selected = null;

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
        this.afisare();
    }

    @FXML
    public void logoutButton(){
        LoginController.setId(null);

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
        tableView.getSelectionModel().select(0);
    }

    @FXML
    public void afisareDetalii(){
        selected = tableView.getSelectionModel().getSelectedItem();

        if(selected.getType().equals("Books")){
            try{
                Stage primaryStage = (Stage)choiceBox.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("viewBook.fxml"));
                primaryStage.setTitle("Book Details");
                primaryStage.setScene(new Scene(root,600,500));
                primaryStage.show();
            }catch (Exception e){
                System.out.println(e);
            }
        }else{
            try{
                Stage primaryStage = (Stage)choiceBox.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("viewItem.fxml"));
                primaryStage.setTitle("Item Details");
                primaryStage.setScene(new Scene(root,600,500));
                primaryStage.show();
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    @FXML
    public void buyButton(){
        selected = tableView.getSelectionModel().getSelectedItem();
        try{
            Stage primaryStage = (Stage)choiceBox.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("buyPage.fxml"));
            primaryStage.setTitle("Buy Page");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void prevOrders(){
        try{
            Stage primaryStage = (Stage)choiceBox.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("prevOrders.fxml"));
            primaryStage.setTitle("Previous Orders");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static Product getSelected() {
        return selected;
    }

    public static void setSelected(Product selected) {
        ShopPageController.selected = selected;
    }
}
