package Controllers;

import Models.Item;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class BuyPageControllerTest extends ApplicationTest {
    private BuyPageController controller;

    @Before
    public void setUp(){
        controller = new BuyPageController();
        controller.textField = new TextField();
        controller.label = new Label();
        controller.alertLabel = new Label();
    }

    @Test
    public void insufficientStock(){
        Item i = new Item("name",10,"type", 10,"material", "color", "size");
        ShopPageController.setSelected(i);
        controller.textField.setText("20");

        controller.formButton();

        assertEquals("Not enough stock!", controller.alertLabel.getText());
    }
}
