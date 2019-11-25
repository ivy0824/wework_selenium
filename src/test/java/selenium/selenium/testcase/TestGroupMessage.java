package selenium.selenium.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import selenium.selenium.page.App;

public class TestGroupMessage {

    public static App app;

    @BeforeClass
    public static void beforeAll(){
        app=new App();
        app.loginWithCookie();
    }

    @Test
    public void send(){
        app.toGroupMessage().send("");
    }
}
