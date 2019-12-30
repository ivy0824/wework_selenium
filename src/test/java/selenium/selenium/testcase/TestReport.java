package selenium.selenium.testcase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import selenium.selenium.page.App;
import selenium.selenium.page.Login;

public class TestReport {

    public static Login login=new Login();
    public static App app;
    static private String templateName="每日工作报告";


    @BeforeClass
    public static void beforeAll(){
        app=login.loginWithCookie();
    }

    @Test
    public void testDailyReport(){
        app.toReportMessage()
                .addDailyReport(templateName,"今日已完成","明日计划工作","遇到的问题")
                .addTemplateRules()
                .testTemplateNamesExist(templateName);
    }

    @AfterClass
    public static void afterAll() throws InterruptedException {
        app.toReportMessage()
                .deleteReportTemplate(templateName)
                .testTemplateNamesNotExist(templateName);
        app.quit();
    }
}
