package app.page;

import org.openqa.selenium.By;

public class SearchPage extends BasePage {
    private By inputBox= By.id("com.xueqiu.android:id/search_input_text");

    public SearchPage search(String keyword){
        driver.findElement(inputBox).sendKeys(keyword);
        return this;
    }

    public Object getCurrentPrice(){
        findElement("");
        return this;
    }

}
