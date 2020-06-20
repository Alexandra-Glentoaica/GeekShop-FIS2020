package Controllers;

import Models.Item;
import Models.Product;
import Services.OrderServices;
import Services.ProductServices;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import sun.util.resources.cldr.rof.CalendarData_rof_TZ;

import java.text.Normalizer;

import static org.junit.Assert.assertEquals;

public class CardControllerTest  extends ApplicationTest {
    private CardController controller;

    @Before
    public void setUp(){
        controller = new CardController();
        controller.alertLabel = new Label();
        controller.cvvField = new PasswordField();
        controller.dateField = new TextField();
        controller.numberField = new TextField();
    }

    @Test
    public void incorrectData(){
        controller.cvvField.setText("5555");

        controller.okButton();

        assertEquals("Incorrect data", controller.alertLabel.getText());
    }

    @After
    public void clear(){
        controller.alertLabel.setText("");
    }

    @Test
    public void addOrder(){
        LoginController.setId("id");
        Item i =new Item("name",10,"type", 10,"material", "color", "size");
        ShopPageController.setSelected(i);
        BuyPageController.setQuantity(10);
        FormController.setAddress("address");
        FormController.setDate("date");
        FormController.setMail("mail");
        FormController.setPayment("payment");
        FormController.setName("name");
        controller.numberField.setText("234235");
        controller.dateField.setText("12");
        controller.cvvField.setText("1");

        controller.okButton();

        assertEquals(1,OrderServices.getOrders().size());
        assertEquals(0,ShopPageController.getSelected().getQuantity());
    }

    @After
    public void clear2(){
        OrderServices.getOrders().clear();
    }

    @Test
    public void emptyFields(){
        controller.cvvField.setText("");

        controller.okButton();

        assertEquals("One or more fields are empty", controller.alertLabel.getText());
    }

}
