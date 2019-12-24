package selenium.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Login extends BasePage {

    private String wwrtx_sid="3xJ8ihtvb-ytUa9X_-5TLJaIT11gNCpUtFiUE5qWePldvemeQAjH8AHhreAh8owc";

    private String url="https://work.weixin.qq.com";

    public  App loginWithCookie(){
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
