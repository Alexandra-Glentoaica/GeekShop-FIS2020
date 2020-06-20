package Controllers;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class AdminPageControllerTest extends ApplicationTest {
    private AdminPageController controller;

    @Before
    public void setUp(){
        controller = new AdminPageController();
        controller.tableView = new TableView<>();
        controller.productColumn = new TableColumn<>();
        controller.quantityColumn = new TableColumn<>();
    }

    @Test
    public void logOut(){
        LoginController.setId("id");

        controller.logOutButton();

        assertEquals(null, LoginController.getId());
    }
}
