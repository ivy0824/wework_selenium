package selenium.selenium.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import selenium.selenium.page.App;
import selenium.selenium.page.Login;

public class TestAddReport {

    public static Login login=new Login();
    public static App app;
    static String phone="12300000013";


    @BeforeClass
    public static void beforeAll(){
        app=login.loginWithCookie();
    }

    @Test
    public void testDailyReport(){
        app.toReportMessage().addDailyReport("每日工作报告","今日已完成","明日计划工作","遇到的问题")
        .addTemplateRules();
    }
}
