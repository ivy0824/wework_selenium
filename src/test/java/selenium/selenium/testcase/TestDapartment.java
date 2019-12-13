package selenium.selenium.testcase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import selenium.selenium.framework.Login;
import selenium.selenium.page.App;

public class TestDapartment {

    public static Login login=new Login();
    public static App app;
    private static String departmentName="研发部门2";

    @BeforeClass
    public static void beforeAll(){
        app=login.loginWithCookie();
    }

    @Test
    public void testAdd(){
        app.toContact().addDepartmant(departmentName);
    }

    @AfterClass
    public static void afterAll() throws InterruptedException {
        app.toContact().deleteDepartment(departmentName);
        app.quit();
    }
}
