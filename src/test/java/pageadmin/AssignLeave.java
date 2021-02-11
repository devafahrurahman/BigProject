package pageadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AssignLeave {
    WebDriver driver;

    public AssignLeave(WebDriver driver){
        this.driver=driver;
    }

    By linkleave= By.id("menu_leave_viewLeaveModule");
    By linkassignleave= By.id("menu_leave_assignLeave");

    By employeename= By.id("assignleave_txtEmployee_empName");
    By selecttype= By.id("assignleave_txtLeaveType");
    By fromdate= By.id("assignleave_txtFromDate");
    By todate= By.id("assignleave_txtToDate");
    By comment= By.id("assignleave_txtComment");
    By duration= By.id("assignleave_duration_duration");

    By btnassign= By.id("assignBtn");
    By btnconfirm= By.id("confirmOkButton");


    By verrormessage= By.className("validation-error");

    By vemptyemployeename= By.xpath("//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[1]/span");
    By vleavetype= By.xpath("//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[2]/span");
    By vinvalidfromdate= By.xpath("//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[4]/span");
    By vinvalidtodate= By.xpath("//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[5]/span");

    public WebElement BtnConfirm(){
        return driver.findElement(btnconfirm);
    }
    public WebElement Duration(){
        return driver.findElement(duration);
    }
    public WebElement VinvalidToDate(){
        return driver.findElement(vinvalidtodate);
    }
    public WebElement VinvalidFromDate(){
        return driver.findElement(vinvalidfromdate);
    }
    public WebElement VleaveType(){
        return driver.findElement(vleavetype);
    }
    public WebElement VemptyEmployeename(){
        return driver.findElement(vemptyemployeename);
    }
    public WebElement VerrorMessage(){
        return driver.findElement(verrormessage);
    }
    public WebElement BtnAssign(){
        return driver.findElement(btnassign);
    }
    public WebElement Comment(){
        return driver.findElement(comment);
    }
    public WebElement Todate(){
        return driver.findElement(todate);
    }
    public WebElement FromData(){
        return driver.findElement(fromdate);
    }
    public WebElement SelectType(){
        return driver.findElement(selecttype);
    }
    public WebElement EmployeeName(){
        return driver.findElement(employeename);
    }

    public void OpenAssignLeave(){
        WebElement Leave = driver.findElement(linkleave);
        Actions action = new Actions(driver);
        action.moveToElement(Leave).perform();
        driver.findElement(linkassignleave).click();
    }


}
