package Controllers;

import Models.Item;
import Models.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ViewItemController {
    @FXML
    private Label nameLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Label materialLabel;
    @FXML
    private Label colorLabel;
    @FXML
    private Label sizeLabel;

    @FXML
    public void backButton(){
        try{
            Stage primaryStage = (Stage)sizeLabel.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("shopPage.fxml"));
            primaryStage.setTitle("Shop Page");
            primaryStage.setScene(new Scene(root,600,500));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void initialize(){
        Product selected = ShopPageController.getSelected();

        nameLabel.setText(selected.getName());
        priceLabel.setText(String.valueOf(selected.getPrice()));
        typeLabel.setText(selected.getType());
        sizeLabel.setText(((Item)selected).getSize());
        colorLabel.setText(((Item)selected).getColor());
        materialLabel.setText(((Item)selected).getMaterial());
    }
}
