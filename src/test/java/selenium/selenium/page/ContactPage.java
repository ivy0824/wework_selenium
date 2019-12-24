package selenium.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactPage extends BasePage {

    @FindBy(linkText = "添加成员")
    WebElement addMemberButton;

    @FindBy(id = "username")
    WebElement usernameValue;

    @FindBy(id = "memberAdd_acctid")
    WebElement acctIdValue;

    @FindBy(id = "memberAdd_phone")
    WebElement phoneValue;

    @FindBy(linkText = "保存")
    WebElement save;

    @FindBy(id = "memberSearchInput")
    WebElement searchTextValue;

    @FindBys({
            @FindBy(css = ".ww_dialog_body"),
            @FindBy(id = "memberSearchInput")})
    WebElement dialogSearchTextValue;

    @FindBy(linkText = "删除")
    WebElement delete;

    @FindAll({
            @FindBy(linkText = "确定"),
            @FindBy(linkText = "确认")})
    WebElement confirm;

    @FindBy(css = ".ww_checkbox")
    WebElement checkbox;

    @FindBys({
            @FindBy(xpath = "//li[@aria-selected='true']"),
            @FindBy(css = ".jstree-contextmenu-hover")})
    WebElement hamburger;

    @FindBy(linkText = "添加子部门")
    WebElement addNextDepartment;

    @FindBy(name = "name")
    WebElement newDepartmentName;

    @FindBys({
            @FindBy(xpath = "//li[@aria-selected='true']"),
            @FindBy(css = ".jstree-ocl")})
    WebElement folderClick;

    @FindBy(css = ".member_colRight_memberTable_th_Checkbox")
    WebElement checkAll;

    @FindBy(linkText = "设置所在部门")
    WebElement setDepartmentButton;

    @FindBy(css = ".ww_searchResult_item_Curr")
    WebElement currentDepartment;

    @FindBy(css = ".ww_searchResult_title_peopleName")
    WebElement searchPeople;


    //构造函数
    public ContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    //添加成员
    public ContactPage add(String username, String acctId, String phone){
        click(addMemberButton);
        sendKeys(usernameValue,username);
        sendKeys(acctIdValue,acctId);
        sendKeys(phoneValue,phone);
        click(save);
        return this;
    }
    //删除成员
    public ContactPage delete(String keywork){
        sendKeys(searchTextValue,keywork);
        click(delete);
        click(confirm);
        return this;
    }

    //清理数据
    // todo 以后尽量通过接口或者数据库清理数据
    //删除所有成员
    public ContactPage delectCurrentPage(){
        click(checkbox);
//        List<WebElement> elements=
//        waitClickable(By.cssSelector(".ww_checkbox"));
        List<WebElement> elements=driver.findElements(By.cssSelector(".ww_checkbox"));
        for(int i=0;i<elements.size();i++){
            System.out.println(i);
            elements.get(i).click();
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        findElement(By.linkText("删除")).click();
        findElement(By.linkText("确认")).click();
        return this;
    }

    //批量导入
    public ContactPage importFromFile(String path){
        findElement(By.partialLinkText("批量导入/导出")).click();
        findElement(By.linkText("文件导入")).click();
        findElement(By.id("js_upload_file_input")).sendKeys(path);
        findElement(By.id("submit_csv")).click();
        findElement(By.linkText("完成")).click();
        return this;
    }

    //添加部门
    public ContactPage addDepartmant(String departmentName, String name){
        click(findElement(By.linkText(departmentName)));
        click(hamburger);
        click(addNextDepartment);
        sendKeys(newDepartmentName,name);
        click(confirm);
        return this;
    }

    //删除一级部门
    public ContactPage deleteDepartment(String departmentName){
        click(findElement(By.linkText(departmentName)));
        click(hamburger);
        click(delete);
        click(confirm);
        return this;
    }

    //删除二极部门
    public ContactPage deleteDepartment2(String departmentName,String secondDepartmentName){
        click(findElement(By.linkText(departmentName)));
        click(folderClick);
        click(findElement(By.linkText(secondDepartmentName)));
        click(hamburger);
        click(delete);
        click(confirm);
        return this;
    }

    //设置所有用户到一个部门
    public ContactPage setdepartmant(String departmentName){
        click(checkAll);
        click(setDepartmentButton);
        sendKeys(dialogSearchTextValue,departmentName);
        click(currentDepartment);
        click(confirm);
        return this;
    }

    //判断用户是否存在
    public void getUsername(String name){
        sendKeys(searchTextValue,name);
        if(display(searchPeople).equals(name)){
            System.out.println("find name" +name+ "Test Pass");
        }
        else {
            System.out.println("not find name" +name+ "Test Failed");
        }
    }

    public HashMap<String, String> getUserName1(String keyword){
        //todo:
        return new HashMap<>();
    }
}
