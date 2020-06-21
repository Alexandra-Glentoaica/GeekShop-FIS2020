package Controllers;

import Models.Product;
import Services.ProductServices;
import javafx.scene.control.TextField;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class AddBookControllerTest extends ApplicationTest {
    private AddBookController controller;

    @Before
    public void setUp(){
        controller = new AddBookController();
        controller.authorField = new TextField();
        controller.publisherField = new TextField();
        controller.languageField = new TextField();
    }

    @Test
    public void addBook(){
        AddProductController.setPrice(10);
        AddProductController.setName("book");
        AddProductController.setQuantity(10);
        controller.authorField.setText("author");
        controller.languageField.setText("language");
        controller.publisherField.setText("publisher");

        controller.okButton();

        assertEquals(1,ProductServices.getProducts().size());
    }

    @After
    public void clearProducts(){
        ProductServices.getProducts().clear();
    }
}
