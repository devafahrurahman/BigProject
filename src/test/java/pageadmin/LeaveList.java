package pageadmin;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LeaveList {
    WebDriver driver;

    public LeaveList(WebDriver driver){
        this.driver=driver;
    }

    By linkleave = By.id("menu_leave_viewLeaveModule");
    By linkleavelist = By.id("menu_leave_viewLeaveList");

    By fromdate = By.id("calFromDate");
    By todate = By.id("calToDate");

    By statusall = By.id("leaveList_chkSearchFilter_checkboxgroup_allcheck");
    By statuspending = By.id("leaveList_chkSearchFilter_1");
    By employeename = By.id("leaveList_txtEmployee_empName");
    By selectsubunit = By.id("leaveList_cmbSubunit");

    By btnsearch = By.id("btnSearch");
    By btnReset = By.id("btnReset");


    By selectaction = By.xpath("//*[@id=\"select_leave_action_33\"]");
    By btnsave = By.id("btnSave");


    By vemptyfromdate = By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[1]/a");
    By vemptytodate = By.xpath("//*[@id=\"resultTable\"]/tbody/tr[15]/td[1]/a");


    By vtodateinvalid = By.xpath("//*[@id=\"frmFilterLeave\"]/fieldset/ol/li[2]/span");
    By vfromdateinvalid = By.xpath("//*[@id=\"frmFilterLeave\"]/fieldset/ol/li[1]/span");

    By vnotfound = By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td");
    By vstatuscancelled = By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[6]/a");


    By vemployeename= By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]/a");
    By vsubunit= By.xpath("//*[@id=\"frmEmpCustomFields\"]/ol/li/label");

    By vstatusapproval1= By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[6]/a");
    By vstatusapproval2= By.xpath("//*[@id=\"resultTable\"]/tbody/tr[5]/td[6]/a");
    By vstatusapproval3= By.xpath("//*[@id=\"resultTable\"]/tbody/tr[8]/td[6]");


    public WebElement VstatusApproval1(){
        return driver.findElement(vstatusapproval1);
    }
    public WebElement VstatusApproval2(){
        return driver.findElement(vstatusapproval2);
    }
    public WebElement VstatusApproval3(){
        return driver.findElement(vstatusapproval3);
    }
    public WebElement VsubUnit(){
        return driver.findElement(vsubunit);
    }
    public WebElement VemployeeName(){
        return driver.findElement(vemployeename);
    }
    public WebElement VnotFound(){
        return driver.findElement(vnotfound);
    }
    public WebElement VstatusCancelled(){
        return driver.findElement(vstatuscancelled);
    }
    public WebElement VtoDateInvalid(){
        return driver.findElement(vtodateinvalid);
    }
    public WebElement VfromDateInvalid(){
        return driver.findElement(vfromdateinvalid);
    }
    public WebElement VemptyFromDate(){
        return driver.findElement(vemptyfromdate);
    }
    public WebElement VemptyToDate(){
        return driver.findElement(vemptytodate);
    }
    public WebElement SelectAction(){
        return driver.findElement(selectaction);
    }
    public WebElement BtnSave(){
        return driver.findElement(btnsave);
    }
    public WebElement BtnSearch(){
        return driver.findElement(btnsearch);
    }
    public WebElement BtnReset(){
        return driver.findElement(btnReset);
    }
    public WebElement SelectSubUnit(){
        return driver.findElement(selectsubunit);
    }
    public WebElement EmployeeName(){
        return driver.findElement(employeename);
    }
    public WebElement StatusPending(){
        return driver.findElement(statuspending);
    }
    public WebElement StatusAll(){
        return driver.findElement(statusall);
    }
    public WebElement FromDate(){
        return driver.findElement(fromdate);
    }
    public WebElement ToDate(){
        return driver.findElement(todate);
    }

    public void OpenLeaveList(){
        WebElement Leave = driver.findElement(linkleave);
        Actions action = new Actions(driver);
        action.moveToElement(Leave).perform();
        driver.findElement(linkleavelist).click();
    }




}
