package selenium.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;

    public WebElement findElement(By by){
        return driver.findElement(by);
    }

    //获取所有定位的element
    public List<WebElement> findElements(By by){
        return driver.findElements(by);
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
    //
    public void click(String string){
        try {
            By by=By.cssSelector(string);
            findElement(by).click();
            System.out.println("Element is clicked "+ findElement(by));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    //获取所有定位元素的内容
    public String[] getTexts(By by){
        List<WebElement> list=findElements(by);
        String[] strings=new String[list.size()];
        try {
            for(int i=0;i<list.size();i++){
                strings[i]=list.get(i).getText();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return strings;
    }



    public String display(WebElement element){
        try {
            if (element.isDisplayed()) {
                System.out.println("Element is displayed "+ element);
            }
        }catch(Exception e){
            System.out.println("Test Fail"+e.getMessage());
        }
        System.out.println(element.getText());
        return element.getText();
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

    public void sendKeys(WebElement element,String text){
        try{
            if(element.isDisplayed()){
                element.clear();
                element.sendKeys(text);
                System.out.println("Element is input "+ element);
            }
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void sendKeysAndEnter(WebElement element,String text){
        try{
            if(element.isDisplayed()){
                System.out.println("1");
                element.clear();
                element.click();
                System.out.println("2");
                element.sendKeys(text, Keys.ENTER);
                System.out.println("3");
                System.out.println("Element is input "+ element);
            }
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void selectCheckbox(WebElement element){
        try{
            if(element.isSelected()){
                element.sendKeys(Keys.SPACE);
            }
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void uncheckCheckbox(WebElement element){
        try{
            if(element.isSelected()){
            }
            else {
                element.sendKeys(Keys.SPACE);
            }
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


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
