package selenium.selenium.testcase;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import selenium.selenium.framework.Login;

public class TestLogin {

    public static Login login = new Login();

    @Test
    public void testLogin(){
        login.loginWithCookie();
    }

    @AfterClass
    public static void afterAll() throws InterruptedException {
        login.quit();
    }
}
