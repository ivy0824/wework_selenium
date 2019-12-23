package selenium.selenium.testcase;

import org.junit.AfterClass;
import org.junit.Test;
import selenium.selenium.page.Login;

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
