package Controllers;

import Models.Item;
import Services.ProductServices;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class AddProductControllerTest extends ApplicationTest {
    private AddProductController controller;

    @Before
    public void setUp(){
        controller = new AddProductController();
        controller.nameField = new TextField();
        controller.integerLabel = new Label();
        controller.alertLabel = new Label();
        controller.priceField = new TextField();
        controller.quantityField = new TextField();
        controller.typeField = new TextField();
    }

    @Test
    public void alreadyExists(){
        ProductServices.getProducts().clear();
        ProductServices.getProducts().add(new Item("name",10,"type", 10,"material", "color", "size"));
        controller.nameField.setText("name");

        controller.okButton();

        assertEquals("Product already exists!", controller.alertLabel.getText());
    }

    @Test
    public void invalidType(){
        ProductServices.getProducts().clear();

        controller.quantityField.setText("2");
        controller.priceField.setText("2");
        controller.typeField.setText("type");

        controller.okButton();

        assertEquals("Invalid type!", controller.alertLabel.getText());
    }
}
