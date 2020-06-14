package Controllers;

import Models.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class AdminPageController {
    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<String,Product> productColumn;
    @FXML
    private TableColumn<Integer,Product> quantityColumn;

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
}
