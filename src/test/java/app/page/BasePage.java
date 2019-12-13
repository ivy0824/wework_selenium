package app.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BasePage {
    public static AndroidDriver driver;
    public static void findElement(String by){
        MobileElement el1 = (MobileElement) driver.findElementById(by);
    }
}
