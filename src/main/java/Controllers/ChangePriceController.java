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
    Label nameLabel;
    @FXML
    TextField price;
    @FXML
    Label priceLabel;
    @FXML
    Label alertLabel;

    public void initialize(){
        alertLabel.setText("");
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
        try {
            p.setPrice(Integer.parseInt(price.getText()));
            ProductServices.writeProducts();

            this.initialize();
        }catch (Exception e){
            alertLabel.setText("Price should be integer!");
        }
    }



    public Label getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(Label nameLabel) {
        this.nameLabel = nameLabel;
    }

    public TextField getPrice() {
        return price;
    }

    public void setPrice(TextField price) {
        this.price = price;
    }

    public Label getPriceLabel() {
        return priceLabel;
    }

    public void setPriceLabel(Label priceLabel) {
        this.priceLabel = priceLabel;
    }

    public Label getAlertLabel() {
        return alertLabel;
    }

    public void setAlertLabel(Label alertLabel) {
        this.alertLabel = alertLabel;
    }
}
