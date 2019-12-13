package selenium.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;

public class ContactPage extends BasePage {

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

    @FindBy(linkText = "删除")
    WebElement delete;

    @FindBy(linkText = "确认")
    WebElement confirm;

    @FindBy(css = ".ww_checkbox")
    WebElement checkbox;

    public ContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public ContactPage add(String username, String acctId, String phone){
        sendKeys(usernameValue,username);
        sendKeys(acctIdValue,acctId);
        sendKeys(phoneValue,phone);
        click(save);
        return this;
    }

    public ContactPage delete(String keywork){
        sendKeys(searchTextValue,keywork);
        click(delete);
        click(confirm);
        return this;
    }

    //清理数据
    // todo 以后尽量通过接口或者数据库清理数据
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

    public ContactPage importFromFile(String path){
        findElement(By.partialLinkText("批量导入/导出")).click();
        findElement(By.linkText("文件导入")).click();
        findElement(By.id("js_upload_file_input")).sendKeys(path);
        findElement(By.id("submit_csv")).click();
        findElement(By.linkText("完成")).click();
        return this;
    }

    public ContactPage addDepartmant(String name){
        findElement(By.xpath("//a[@id='1688850729473458_anchor']/span")).click();
        findElement(By.linkText("添加子部门")).click();
        findElement(By.name("name")).sendKeys(name);
        findElement(By.linkText("确定")).click();
        return this;
    }

    public ContactPage deleteDepartment(String name){
        findElement(By.linkText(name)).click();
        click(delete);
        click(confirm);
        return this;
    }

    public void list(){

    }

    public HashMap<String, String> getUserInfo(String keyword){
        //todo:
        return new HashMap<>();
    }
}
