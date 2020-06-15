package Controllers;

import Models.Order;
import Models.Product;
import Services.OrderServices;
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

public class OrdersController {
    private static Order selected;

    @FXML
    private TableView<Order> tableView;
    @FXML
    private TableColumn<Order,String> productColumn;
    @FXML
    private TableColumn<Order,String> statusColumn;

    public void initialize(){
        OrderServices.loadOrders();
        ArrayList<Order> orders = OrderServices.getOrders();

        tableView.setItems(FXCollections.observableArrayList(orders));
        productColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("product"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("status"));
    }

    public void backButton(){
        try{
            Stage primaryStage = (Stage)tableView.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("adminPage.fxml"));
            primaryStage.setTitle("Admin Page");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void orderDetails(){
        selected = tableView.getSelectionModel().getSelectedItem();

        try{
            Stage primaryStage = (Stage)tableView.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("adminOrderDetails.fxml"));
            primaryStage.setTitle("Order Details");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void acceptButton(){

    }

    public void declineButton(){

    }

    public static Order getSelected() {
        return selected;
    }
}
