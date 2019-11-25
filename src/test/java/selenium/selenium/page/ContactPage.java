package selenium.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactPage extends BasePage {

    public ContactPage add(String usernmae, String acctid, String phone){
        findElement(By.id("username")).sendKeys(usernmae);
        findElement(By.id("memberAdd_english_name")).sendKeys(acctid);
        findElement(By.id("memberAdd_phone")).sendKeys(phone);
        return this;
    }

    public ContactPage delect(String keywork){
        findElement(By.id("memberSearchInput")).sendKeys(keywork);
        try{
            waitClickable(By.linkText("删除"), 5);
        }catch (Exception e){
            System.out.println("not found");
            return this;
        }
        findElement(By.linkText("删除"));
        findElement(By.linkText("确认"));
        findElement(By.id("clearMemberSearchInput")).click();
        return this;
    }

    //清理数据
    // todo 以后尽量通过接口或者数据库清理数据
    public ContactPage delectCurrentPage(){
        waitClickable(By.cssSelector(".ww_checkbox"));
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

    public void list(){

    }
}
