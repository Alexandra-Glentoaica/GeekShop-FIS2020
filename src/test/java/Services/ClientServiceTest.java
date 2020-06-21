package Services;

import Models.Client;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class ClientServiceTest extends ApplicationTest {
    @BeforeClass
    public static void setupClass(){
        ClientServices.setPath("src/test/resources/users.json");
        ClientServices.loadClients();
    }

    @Before
    public void setUp(){
        ClientServices.loadClients();
    }

    @Test
    public void loadWriteTest(){
        ClientServices.getClients().clear();
        ClientServices.getClients().add(new Client("user","pass","Customer"));
        ClientServices.writeClients();
        ClientServices.getClients().clear();
        ClientServices.loadClients();

        assertEquals(1, ClientServices.getClients().size());
    }

    @AfterClass
    public static void clean(){
        ClientServices.getClients().clear();
        ClientServices.writeClients();
    }
}
