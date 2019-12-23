package selenium.selenium.testcase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import selenium.selenium.page.Login;
import selenium.selenium.page.App;

public class TestWeWork {

    public static Login login=new Login();
    public static App app;
    static String phone="12300000011";


    @BeforeClass
    public static void beforeAll(){
        app=login.loginWithCookie();
    }

    @Test
    public void testAdd(){
        app.toMemberAdd().add(phone,phone,phone);
    }

    @Test
    public void testDelect(){
        String phone="12300000002";
        app.toMemberAdd().add(phone,phone,phone).delete(phone);
    }

//    @Test
//    public void testDelectCurrentPage(){
//        app.toMemberAdd().delectCurrentPage();
//    }

    @AfterClass
    public static void afterAll() throws InterruptedException {
        app.toContact().delete(phone);
        app.quit();
    }


}
