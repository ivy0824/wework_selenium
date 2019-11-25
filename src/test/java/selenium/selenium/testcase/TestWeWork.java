package selenium.selenium.testcase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import selenium.selenium.page.App;

public class TestWeWork {

    public static App app;

    @BeforeClass
    public static void beforeAll(){
        app=new App();
        app.loginWithCookie();
        String phone="12300000001";
        app.toContact().delect(phone);
    }

    @Test
    public void testAdd(){
        String phone="12300000001";
        app.toMemberAdd().add(phone,phone,phone);
    }

    @Test
    public void testDelect(){
        String phone="12300000001";
        app.toMemberAdd().add(phone,phone,phone).delect(phone);
    }

    @Test
    public void testDelectCurrentPage(){
        app.toMemberAdd().delectCurrentPage();
    }

    @AfterClass
    public static void afterAll() throws InterruptedException {
        app.quit();
    }


}
