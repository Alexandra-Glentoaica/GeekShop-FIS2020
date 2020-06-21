package Controllers;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class ChangePriceControllerTest extends ApplicationTest {
    private ChangePriceController controller;


    @Before
    public void setUp() {
        controller = new ChangePriceController();
        controller.nameLabel = new Label();
        controller.priceLabel = new Label();
        controller.alertLabel = new Label();
        controller.price = new TextField();

    }

    @Test
    public void shouldBeInteger(){

        controller.price.setText("word");

        controller.okButton();

        assertEquals("Price should be integer!", controller.alertLabel.getText());
    }
}