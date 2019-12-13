package selenium.selenium.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.selenium.page.App;
import selenium.selenium.page.BasePage;

import java.util.concurrent.TimeUnit;

public class Login extends BasePage {

    private String wwrtx_sid="3xJ8ihtvb-ytUa9X_-5TLPJoorDuFt5sJulyVElvHhjkOCb6IWmOsbMBgqLVA6JV";


    public App loginWithCookie(){
        String url="https://work.weixin.qq.com";
        //初始化一个谷歌浏览器实例，实例名称叫driver
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("企业登录")).click();
        driver.manage().deleteCookieNamed("wwrtx.sid");
        driver.manage().addCookie(new Cookie("wwrtx.sid",wwrtx_sid));
        driver.navigate().refresh();
        return new App(driver);

    }

}
