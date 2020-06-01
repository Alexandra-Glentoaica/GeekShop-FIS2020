package Controllers;

import Models.Book;
import Models.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ViewBookController {
    @FXML
    private Label nameLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Label authorLabel;
    @FXML
    private Label languageLabel;
    @FXML
    private Label publisherLabel;

    @FXML
    public void backButton(){
        try{
            Stage primaryStage = (Stage) publisherLabel.getScene().getWindow();
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
        publisherLabel.setText(((Book)selected).getPublisher());
        languageLabel.setText(((Book)selected).getLanguage());
        authorLabel.setText(((Book)selected).getAuthor());
    }
}
