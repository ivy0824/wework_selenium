package selenium.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReportPage extends BasePage {


    @FindBy(linkText = "添加模板")
    WebElement addTemplate;

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
    WebElement searchedPeople;

    @FindAll({
            @FindBy(linkText = "确定"),
            @FindBy(linkText = "确认"),
            @FindBy(linkText = "保存")})
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

    @FindBy(linkText = "按日")
    WebElement byDaily;

    @FindBys({
            @FindBy(css = ".js-remindrules-type"),
            @FindBy(css = ".ww_btn_Dropdown_arrow")
    })
    WebElement remindWay;

    @FindBy(linkText = "提醒")
    WebElement warmingButton;

    @FindBy(css = ".app_card:nth-child(9) .app_card_delete")
    WebElement getDeleteButton;


    @FindAll(@FindBy(linkText = "删除"))
    WebElement deleteButton;

    //构造函数
    public ReportPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //添加模版
    public ReportPage addDailyReport(String templateName,String firstName,String secondName,String thirdName){
        click(addTemplate);
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

    //修改模版规则
    public ReportPage addTemplateRules(){
        click(addReportPersonButton);
        click(somebody);
        System.out.println(searchTextValue);
        sendKeys(searchTextValue,"12300000002");
        click(searchedPeople);
        click(confirm);
        click(addbutton);
        sendKeys(searchTextValue,"12300000002");
        click(searchedPeople);
        click(confirm);
        click(reportWay);
        click(byDaily);
        click(remindWay);
        click(warmingButton);
        click(confirm);
        return this;
    }

    //判断模版存在
    public void testTemplateNamesExist(String name){
        String[] strings=getTexts(By.cssSelector(".app_card_head_title"));
        int j=strings.length;
        for(int i=0;i<j;i++){
            if(strings[i].equals(name)){
                System.out.println("Test Pass");
                break;
            }
            if(i==j-1){
                System.out.println("Test Failed");
            }
        }
    }

    //判断模版不存在
    public void testTemplateNamesNotExist(String name){
        String[] strings=getTexts(By.cssSelector(".app_card_head_title"));
        int j=strings.length;
        for(int i=0;i<j;i++){
            if(strings[i].equals(name)){
                System.out.println("Test Failed");
                break;
            }
            if(i==j-1){
                System.out.println("Test Pass");
            }
        }
    }

    //删除模版
    public ReportPage deleteReportTemplate(String name){
        By cardTitle=By.cssSelector(".app_card_head_title");
        List<WebElement> list=findElements(cardTitle);
        Actions action = new Actions(driver);
        int i=0;
        for (WebElement element : list){
            i++;
            if(element.getText().equals(name)){
                i++;
                System.out.println(element.getText());
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                action.moveToElement(element).perform();
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                click(".app_card:nth-child("+i+") .app_card_delete");
                click(deleteButton);
                break;
            }
        }
        return this;
    }

}
