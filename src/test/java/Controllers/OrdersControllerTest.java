package Controllers;

import Models.Order;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class OrdersControllerTest extends ApplicationTest {
    private OrdersController controller;

    @Before
    public void setUp(){
        controller = new OrdersController();
        controller.tableView = new TableView<>();
        controller.productColumn = new TableColumn<>();
        controller.statusColumn = new TableColumn<>();
    }

    @Test
    public void acceptOrder(){
        Order o = new Order("id","pending","product",10,"name","address","date","payment","mail");
        controller.tableView.getSelectionModel().select(o);

        controller.acceptButton();

        assertEquals("accepted", o.getStatus());
    }

    @Test
    public void declineOrder(){
        Order o = new Order("id","pending","product",10,"name","address","date","payment","mail");
        controller.tableView.getSelectionModel().select(o);

        controller.declineButton();

        assertEquals("declined", o.getStatus());
    }
}
