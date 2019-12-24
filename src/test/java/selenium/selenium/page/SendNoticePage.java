package selenium.selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendNoticePage extends BasePage {

    @FindBy(linkText = "选择需要发消息的应用")
    WebElement selectObject;

    @FindBy(css = ".ww_icon_AppNotice")
    WebElement bubble_title;

    @FindAll({
            @FindBy(linkText = "确定"),
            @FindBy(linkText = "确认")})
    WebElement confirm;

    @FindBy(linkText = "选择发送范围")
    WebElement selectRange;

    @FindBy(id = "memberSearchInput")
    WebElement searchTextValue;

    @FindBy(css = ".ww_searchResult_title_peopleName")
    WebElement selectPeople;

    @FindBy(css = ".ww_compatibleTxt_ipt")
    WebElement titleFiled;

    @FindBy(css = ".msg_noticeEditor_frameBody")
    WebElement contextFiled;

    @FindBy(css = ".js_amrd_sendName")
    WebElement sendNameFiled;

    public SendNoticePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public SendNoticePage send(String name, String title, String context, String sendName){
        click(selectObject);
        click(bubble_title);
        click(confirm);
        click(selectRange);
        sendKeys(searchTextValue,name);
        click(selectPeople);
        click(confirm);
        sendKeys(titleFiled,title);
        driver.switchTo().frame(0);
        sendKeys(contextFiled,context);
        driver.switchTo().defaultContent();
        sendKeys(sendNameFiled,sendName);

        return this;
    }
}
