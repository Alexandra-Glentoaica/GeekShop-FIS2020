package Controllers;

import Models.Client;
import Services.ClientServices;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class LoginControllerTest extends ApplicationTest{
    private LoginController controller;

    @Before
    public void setUp() {
        ClientServices.loadClients();

        controller = new LoginController();
        controller.label = new Label();
        controller.idEntry = new TextField();
        controller.passEntry = new PasswordField();
    }

    @Test
    public void invalidElements(){
        controller.loginButton();

        assertEquals("One of the identifying elements is invalid! Please try again!", controller.label.getText());
    }

    @Test
    public void loginUser(){
        ClientServices.getClients().clear();
        ClientServices.getClients().add(new Client("user",ClientServices.encodePassword("pass"), "Customer"));
        controller.idEntry.setText("user");
        controller.passEntry.setText("pass");

        controller.loginButton();

        assertEquals("", controller.label.getText());
    }

}