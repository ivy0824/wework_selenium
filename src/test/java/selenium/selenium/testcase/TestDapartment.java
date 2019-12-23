package selenium.selenium.testcase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import selenium.selenium.page.Login;
import selenium.selenium.page.App;

public class TestDapartment {

    public static Login login=new Login();
    public static App app;
    private static String departmentName="UI";
    private static String secondDepartmentName="UI4";
    public static String enterprise="欣欣向荣企业";

    @BeforeClass
    public static void beforeAll(){
        app=login.loginWithCookie();
    }

    @Test
    //添加一级部门
    public void testAdd(){
        app.toContact()
              .addDepartmant(enterprise,departmentName);
    }

    @Test
    //添加二级部门
    public void testAdd2(){
        app.toContact()
                .addDepartmant(departmentName,secondDepartmentName);
    }

    @AfterClass
    public static void afterAll() throws InterruptedException {
        app.toContact().deleteDepartment2(departmentName,secondDepartmentName);
        app.toContact().deleteDepartment(departmentName);
        app.quit();
    }
}
