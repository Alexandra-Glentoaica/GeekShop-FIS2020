package Services;

import Models.Client;
import Models.Order;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class OrderServicesTest extends ApplicationTest {
    @BeforeClass
    public static void setupClass(){
        OrderServices.setPath("src/test/resources/orders.json");
        OrderServices.loadOrders();
    }

    @Before
    public void setUp(){
        OrderServices.loadOrders();
    }

    @Test
    public void loadWriteTest(){
        OrderServices.getOrders().clear();
        Order o = new Order("id","pending","product",10,"name","address","date","payment","mail");
        OrderServices.getOrders().add(o);
        OrderServices.writeOrders();
        OrderServices.getOrders().clear();
        OrderServices.loadOrders();

        assertEquals(1, OrderServices.getOrders().size());
    }

    @AfterClass
    public static void clean(){
        OrderServices.getOrders().clear();
        OrderServices.writeOrders();
    }
}
