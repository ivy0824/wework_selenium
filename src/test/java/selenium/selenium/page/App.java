package selenium.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class App extends BasePage{


    public App loginWithCookie(){
        String url="https://work.weixin.qq.com";
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();

        driver.findElement(By.linkText("企业登录")).click();

        driver.manage().addCookie(new Cookie("wwrtx.refid","3594200378536973"));
//        driver.manage().addCookie(new Cookie("wwrtx.sid","3xJ8ihtvb-ytUa9X_-5TLHZJs9yhNBsYzbvM4rGcqQouPaOvEHYw4m2S3mq43Va4"));
//        driver.manage().addCookie(new Cookie("wwrtx.vid","1688850729473457"));
//        driver.manage().addCookie(new Cookie("eas_sid","f115A6V8h2m8j197T3v2A2J7k5"));

        //打印cookies
        System.out.println(driver.manage().getCookies());
        driver.navigate().refresh();
        return this;

    }

    public ContactPage toContact(){
        findElement(By.linkText("通讯录")).click();
        return new ContactPage();
    }

    public ContactPage toMemberAdd(){
        //find click
        findElement(By.linkText("添加成员")).click();
        return new ContactPage();
    }

    public BroadcastPage toGroupMessage(){
        findElement(By.linkText("管理工具")).click();
        findElement(By.cssSelector(".ww_icon_AppGroupMessageBig")).click();
        return new BroadcastPage();
    }
}
