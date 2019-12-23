package selenium.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;

    public WebElement findElement(By by){
        return driver.findElement(by);
    }
    public void click(WebElement element){
        try {
            if(element.isEnabled()){
                element.click();
                driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
                System.out.println("Element is clicked "+ element);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void doubleClick(WebElement element){
        try {
            if(element.isEnabled()){
                Actions actions=new Actions(driver);
                actions.doubleClick(element);
                driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
                System.out.println("Element is clicked "+ element);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public ExpectedCondition getPageLoadCondition(WebElement element) {
        return  ExpectedConditions.visibilityOf(element);
    }

    protected void sendKeys(WebElement element,String text){
        try{
            if(element.isDisplayed()){
                element.sendKeys(text);
            }
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

//    protected List<WebElement> findElements(WebElement element){
//        try{
//            if(element.isDisplayed()){
//                element.
//            }
//        }
//    }

    //等待元素可以被点击
    public void waitClickable(By by,int timeout){
        new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(by));
    }
    //等待元素出现，等待元素可以点击
    public WebElement waitClickable(By by){
        try{
            new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(by));
            new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(by));
        }catch (Exception e){
            System.out.println("not find"+by);
        }
        return driver.findElement(by);
    }

    //等待元素出现
    public void waitDisplay(By by){
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void quit() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }

}
