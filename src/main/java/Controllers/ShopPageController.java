package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class ShopPageController {
    @FXML
    private ChoiceBox choiceBox;

    @FXML
    public void initialize(){
        choiceBox.getItems().addAll("Carti", "Figurine Funko Pop", "Accesorii Geek", "Produse de papetarie", "Board Games");
        choiceBox.setValue("Carti");
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

    }

    @FXML
    public void afisareDetalii(){

    }
}
