package Controllers;

import Services.ProductServices;
import javafx.scene.control.TextField;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class AddItemControllerTest extends ApplicationTest {
    private AddItemController controller;

    @Before
    public void setUp(){
        controller = new AddItemController();
        controller.sizeField = new TextField();
        controller.colorField = new TextField();
        controller.materialField = new TextField();
    }

    @Test
    public void addItem(){
        AddProductController.setPrice(10);
        AddProductController.setName("item");
        AddProductController.setQuantity(10);
        controller.materialField.setText("material");
        controller.colorField.setText("color");
        controller.sizeField.setText("size");

        controller.okButton();

        assertEquals(1, ProductServices.getProducts().size());
    }

    @After
    public void clearProducts(){
        ProductServices.getProducts().clear();
    }
}
