package Controllers;

import Models.Client;
import Services.ClientServices;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class SignUpControllerTest extends ApplicationTest{

    private SignUpController controller;

    @Before
    public void setUp() {
        controller = new SignUpController();
        controller.idField = new TextField();
        controller.passField = new PasswordField();
        controller.role = new ChoiceBox<String>();
        controller.label1 = new Label();
        ClientServices.loadClients();
    }

    @Test
    public void usernameTaken(){
        ClientServices.getClients().add(new Client("user","pass","Customer"));
        controller.idField.setText("user");
        controller.passField.setText("pass");
        controller.role.setValue("Customer");

        controller.signUpButton();

        assertEquals("This username is already taken!", controller.label1.getText());
    }

    @After
    public void cleanup(){
        ClientServices.getClients().clear();
    }

    @Test
    public void addUser(){
        controller.idField.setText("user");
        controller.passField.setText("pass");
        controller.role.setValue("Customer");

        controller.signUpButton();

        assertEquals("", controller.label1.getText());
    }
}
