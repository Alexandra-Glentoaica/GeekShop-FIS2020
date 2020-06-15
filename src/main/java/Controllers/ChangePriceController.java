package Controllers;

import Models.Product;
import Services.ProductServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChangePriceController {
    private Product p;

    @FXML
    private Label nameLabel;
    @FXML
    private TextField price;
    @FXML
    private Label priceLabel;

    public void initialize(){
        p = AdminPageController.getSelected();

        nameLabel.setText(p.getName());
        priceLabel.setText(String.valueOf(p.getPrice()));
    }

    public void backButton(){
        try{
            Stage primaryStage = (Stage)price.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("adminPage.fxml"));
            primaryStage.setTitle("Admin Page");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void okButton(){
        p.setPrice(Integer.parseInt(price.getText()));

        ProductServices.writeProducts();

        this.initialize();
    }
}
