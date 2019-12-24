package selenium.selenium.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import selenium.selenium.page.App;
import selenium.selenium.page.Login;

public class TestSendNotice {

    public static Login login=new Login();
    public static App app;

    @BeforeClass
    public static void beforeAll(){
        app=login.loginWithCookie();
    }

    @Test
    public void testSendNotice(){
        app.toGroupMessage1().send("12300000002","111","222","333");

    }
}

