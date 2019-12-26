package selenium.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ReportPage extends BasePage {

    @FindBys({
            @FindBy(css = ".approval_general_item"),
            @FindBy(linkText = "日报")
    })
    WebElement dailyReportButton;

    @FindBy(css = ".js_template_name")
    WebElement templateNameInputBox;

    @FindBy(css = ".js_add_icon")
    WebElement addIconButton;

    @FindBy(xpath = "//div[@data-id='1']")
    WebElement iconButton;

    @FindBy(css = ".js_title")
    WebElement controlName;

    @FindBy(css = ".js_validate")
    WebElement checkbox;

    @FindBy(linkText = "下一步")
    WebElement nextStep;

    @FindBy(linkText = "添加")
    WebElement addbutton;

    @FindBy(id = "memberSearchInput")
    WebElement searchTextValue;

    @FindBy(css = ".ww_searchResult_title_peopleName")
    WebElement searchPeople;

    @FindAll({
            @FindBy(linkText = "确定"),
            @FindBy(linkText = "确认")})
    WebElement confirm;

    @FindBy(css = ".ww_icon_AddBtnGray")
    WebElement addReportPersonButton;

    @FindBy(xpath = "//span[text()=\"具体成员\"]")
    WebElement somebody;

    @FindBys({
            @FindBy(css = ".js-remind-type"),
            @FindBy(css = ".ww_btn_Dropdown_arrow")
    })
    WebElement reportWay;

    @FindBy(linkText = "按周")
    WebElement byDaily;

    @FindBys({
            @FindBy(css = ".js-remindrules-type"),
            @FindBy(css = ".ww_btn_Dropdown_arrow")
    })
    WebElement remindWay;



    public ReportPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public ReportPage addDailyReport(String templateName,String firstName,String secondName,String thirdName){
        click(dailyReportButton);
        //修改模版名称和图标
        sendKeys(templateNameInputBox,templateName);
        click(addIconButton);
        click(iconButton);
        //获取所有的selector
        List<WebElement> list=findElements(By.cssSelector(".drapSelector"));
        //修改今日计划
        click(list.get(0));
        sendKeys(controlName,firstName);
        selectCheckbox(checkbox);
        //修改明日计划
        click(list.get(1));
        sendKeys(controlName,secondName);
        selectCheckbox(checkbox);
        //修改其他事项
        click(list.get(2));
        sendKeys(controlName,thirdName);
        uncheckCheckbox(checkbox);
        click(nextStep);
        return this;
    }

    public ReportPage addTemplateRules(){
        click(addbutton);
        sendKeys(searchTextValue,"12300000002");
        click(searchPeople);
        click(confirm);
        click(addReportPersonButton);
        click(somebody);
        sendKeys(searchTextValue,"12300000012");
        click(searchPeople);
        click(confirm);
        click(reportWay);
        click(byDaily);
        return this;
    }

}
