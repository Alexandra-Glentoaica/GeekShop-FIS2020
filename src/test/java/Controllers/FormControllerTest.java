package Controllers;

import Models.Item;
import Services.OrderServices;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class FormControllerTest extends ApplicationTest{

    private FormController controller;

    @Before
    public void setUp() {
        controller = new FormController();
        controller.nameField = new TextField();
        controller.mailField = new TextField();
        controller.adressField = new TextField();
        controller.dateField = new TextField();
        controller.choiceBox = new ChoiceBox();
        controller.alertLabel = new Label();
    }

    @Test
    public void emptyFields(){
        controller.choiceBox.setValue("Cash");

        controller.buyButton();

        assertEquals("One or more fields are empty", controller.alertLabel.getText());
    }

    @Test
    public void addButton(){
        controller.nameField.setText("name");
        controller.adressField.setText("address");
        controller.dateField.setText("date");
        controller.mailField.setText("mail");
        controller.choiceBox.setValue("Cash");
        LoginController.setId("id");
        Item i = new Item("name",10,"type", 10,"material", "color", "size");
        ShopPageController.setSelected(i);
        BuyPageController.setQuantity(10);

        controller.buyButton();

        assertEquals(1, OrderServices.getOrders().size());
        assertEquals( 0, ShopPageController.getSelected().getQuantity());
    }
}