package selenium.selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class App extends BasePage{

    private String wwrtx_sid="3xJ8ihtvb-ytUa9X_-5TLPJoorDuFt5sJulyVElvHhjkOCb6IWmOsbMBgqLVA6JV";

    @FindBy(linkText = "通讯录")
    WebElement addressList;

    @FindBy(linkText = "添加成员")
    WebElement addMember;

    @FindBy(linkText = "管理工具")
    WebElement managerTool;

    @FindBy(css=".ww_icon_AppGroupMessageBig")
    WebElement broad;

    @FindBy(linkText = "应用管理")
    WebElement applicationManagement;

    @FindBy(xpath = "//div[@url='#worknote_v2']")
    WebElement worknoteButton;

    @FindBy(linkText = "添加模板")
    WebElement addTemplate;

    public App(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public ContactPage toContact(){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        click(addressList);
        return new ContactPage(driver);
    }

    public ContactPage toMemberAdd(){
        click(addMember);
        return new ContactPage(driver);
    }

    public BroadcastPage toGroupMessage(){
        click(managerTool);
        click(broad);
        return new BroadcastPage();
    }

    public SendNoticePage toGroupMessage1(){
        click(managerTool);
        click(broad);
        return new SendNoticePage(driver);
    }

    public ReportPage toReportMessage(){
        click(applicationManagement);
        click(worknoteButton);
        click(addTemplate);
        return new ReportPage(driver);
    }
}

