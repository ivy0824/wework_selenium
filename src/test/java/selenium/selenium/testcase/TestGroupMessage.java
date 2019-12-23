package selenium.selenium.testcase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import selenium.selenium.page.Login;
import selenium.selenium.page.App;

public class TestGroupMessage {

    public static Login login=new Login();
    public static App app;

    @BeforeClass
    public static void beforeAll(){
        app=login.loginWithCookie();
    }

    @Test
    public void send(){
        app.toGroupMessage().send("176","2","3","4","5");
    }

    @AfterClass
    public static void afterAll() throws InterruptedException {
        app.quit();
    }
}
