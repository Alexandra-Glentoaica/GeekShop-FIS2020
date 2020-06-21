package Services;

import Models.Client;
import Models.Item;
import Models.Product;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class ProductServiceTest extends ApplicationTest {
    @BeforeClass
    public static void setupClass(){
        ProductServices.setPath("src/test/resources/products.json");
        ProductServices.loadProducts();
    }

    @Before
    public void setUp(){
        ProductServices.loadProducts();
    }

    @Test
    public void loadWriteTest(){
        ProductServices.getProducts().clear();
        Item i = new Item("name",10,"type", 10,"material", "color", "size");
        ProductServices.getProducts().add(i);
        ProductServices.writeProducts();
        ProductServices.getProducts().clear();
        ProductServices.loadProducts();

        assertEquals(1, ProductServices.getProducts().size());
    }

    @AfterClass
    public static void clean(){
        ProductServices.getProducts().clear();
        ProductServices.writeProducts();
    }
}
