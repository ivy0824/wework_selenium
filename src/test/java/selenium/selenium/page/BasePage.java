package selenium.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage {
    public static WebDriver driver;
    public WebElement findElement(By by){
        return driver.findElement(by);
    }

    //等待元素可以被点击
    public void waitClickable(By by,int timeout){
        new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(by));
    }
    //等待元素出现，等待元素可以点击
    public void waitClickable(By by){
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(by));
        new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(by));
    }

    public void quit() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }

}
