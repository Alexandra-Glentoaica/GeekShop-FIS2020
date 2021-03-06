import Models.Product;
import Services.ClientServices;
import Services.OrderServices;
import Services.ProductServices;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ClientServices.setPath("src/main/resources/users.json");
        OrderServices.setPath("src/main/resources/orders.json");
        ProductServices.setPath("src/main/resources/products.json");

        OrderServices.loadOrders();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        primaryStage.setTitle("Login Screen");
        primaryStage.setScene(new Scene(root,600,500));
        primaryStage.show();
    }
}
