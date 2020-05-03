import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
    Scene scene1; //Scena pentru login
    Scene scene2; //Scena pentru pagina clientului;
    Scene scene3; //Scena pentru pagina administratorului;
    Scene scene4; //Scena pentru pagina cu produse vazuta de client;
    Scene scene5; //Scena pentru pagina cu stocuri vazuta de administrator;
    Button login_button;
    // Button signup_button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");

        //For the login form we will use a GridPane;
        GridPane grid= new GridPane();
        grid.setAlignment(Pos.CENTER); //Changes the default position of the grid from the top left of the scene to the center;
        //The gap properties manage the spacing between the rows and columns;
        grid.setHgap(10); //Horizontal gap;
        grid.setVgap(10); //Vertical gap;
        //the padding property manages the space around the edges of the grid pane.
        grid.setPadding(new Insets(25,25,25,25));

        //Add Text,Labels, and Text Fields;
        Text sceneTitle= new Text("Welcome to GeekShop!");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD,20));
        grid.add(sceneTitle, 0, 0, 2,1); //Adding the "welcome!" text to the grid;

        Label userName = new Label("User Name:");
        grid.add(userName, 0 ,1); //Adding the username label to the grid;

        TextField userTextField = new TextField("ag.alle");
        grid.add(userTextField,1,1); //Adding the text field for the username to the grid;

        Label password = new Label("Password:");
        grid.add(password,0,2); //Adding the password Label to the grid;

        PasswordField passField = new PasswordField(); // Setam din start un "passwordField" in loc de un simplu "TextField" pentru a aparea acele cerculete atunci cand introducem parola;
        passField.setPromptText("password");
        grid.add(passField,1,2); ///Adding the password field to the project;

        //Setting the login button
        login_button=new Button("login");
        grid.add(login_button,0,3);
        //Setting the scene
        scene1=new Scene(grid, 300,275);

        primaryStage.setScene(scene1);
        primaryStage.show();
    }
}
