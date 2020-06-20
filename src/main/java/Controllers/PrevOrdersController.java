package Controllers;

import Models.Order;
import Models.Product;
import Services.OrderServices;
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

public class PrevOrdersController {
    private static Order selected;

    @FXML
    private TableView<Order> tableView;
    @FXML
    private TableColumn<Order,String> tableColumn;

    @FXML
    public void initialize(){
        ArrayList<Order> orders = OrderServices.getOrders();
        ArrayList<Order> sortedOrders = new ArrayList<>();

        for(Order o:orders){
            if(o.getId().equals(LoginController.getId())){
                sortedOrders.add(o);
            }
        }

        tableView.setItems(FXCollections.observableArrayList(sortedOrders));
        tableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("product"));
        tableView.getSelectionModel().select(0);
    }

    @FXML
    public void backButton(){
        try{
            Stage primaryStage = (Stage)tableView.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("shopPage.fxml"));
            primaryStage.setTitle("Shop Page");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void showButton(){
        selected = tableView.getSelectionModel().getSelectedItem();

        try{
            Stage primaryStage = (Stage)tableView.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("orderDetails.fxml"));
            primaryStage.setTitle("Order Details");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static Order getSelected() {
        return selected;
    }
}
