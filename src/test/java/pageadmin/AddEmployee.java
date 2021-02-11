package pageadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class AddEmployee {

    WebDriver driver;

    public AddEmployee(WebDriver driver) {

        this.driver = driver;
    }

    By pim = By.id("menu_pim_viewPimModule");
    By linkAddEmp = By.id("menu_pim_addEmployee");
    By firstName = By.id("firstName");
    By midleName = By.id("middleName");
    By lastName = By.id("lastName");
    By employeeId = By.id("employeeId");
    By chkLogin = By.id("chkLogin");
    By btnSave = By.id("btnSave");
    By btnupload = By.id("photofile");
    By username = By.id("user_name");
    By password = By.id("user_password");
    By cpassword = By.id("re_password");
    By selectstatus = By.id("status");




    By vEmptyFN = By.xpath("//*[@id=\"frmAddEmp\"]/fieldset/ol/li[1]/ol/li[1]/span");
    By vEmptyLN = By.xpath("//*[@id=\"frmAddEmp\"]/fieldset/ol/li[1]/ol/li[3]/span");
    By vInvalidUN = By.xpath("//*[@id=\"frmAddEmp\"]/fieldset/ol/li[5]/span");
    By vInvalidPassword = By.xpath("//*[@id=\"frmAddEmp\"]/fieldset/ol/li[6]/span");
    By vdetailPassword = By.xpath("//*[@id=\"frmAddEmp\"]/fieldset/ol/li[6]/span");
    By vCpassword = By.xpath("//*[@id=\"frmAddEmp\"]/fieldset/ol/li[7]/span");
    By vAddSuccess = By.id("employee-details");



    public WebElement FirstName(){
        return driver.findElement(firstName);
    }

    public WebElement Lastname(){
        return driver.findElement(lastName);
    }

    public WebElement MidleName(){
        return driver.findElement(midleName);
    }

    public WebElement EmployeeId(){
        return driver.findElement(employeeId);
    }

    public WebElement ChckLogin(){
        return driver.findElement(chkLogin);
    }

    public WebElement BtnSave(){
        return driver.findElement(btnSave);
    }

    public WebElement VemptyFN(){
        return driver.findElement(vEmptyFN);
    }

    public WebElement VemptyLN(){
        return driver.findElement(vEmptyLN);
    }

    public WebElement Upload(){
        return driver.findElement(btnupload);
    }

    public WebElement VaddSuccess(){
        return driver.findElement(vAddSuccess);
    }

    public WebElement UserName(){
        return driver.findElement(username);
    }

    public WebElement Password(){
        return driver.findElement(password);
    }

    public WebElement Cpassword(){
        return driver.findElement(cpassword);
    }
    public WebElement SelectStatus(){
        return driver.findElement(selectstatus);
    }
    public WebElement VinvalidUN(){
        return driver.findElement(vInvalidUN);
    }

    public WebElement VinvalidPassword(){
        return driver.findElement(vInvalidPassword);
    }

    public WebElement VdetailPassword(){
        return driver.findElement(vdetailPassword);
    }

    public WebElement VcPassword(){
        return driver.findElement(vCpassword);
    }





    public void OpenAddEmployee() {
        Actions action = new Actions(driver);
        WebElement PIM = driver.findElement(pim);
        action.moveToElement(PIM).perform();
        driver.findElement(linkAddEmp).click();
    }

    public void ValidDataWithoutCreateLogin(){
        driver.findElement(firstName).sendKeys("Kadal");
        driver.findElement(midleName).sendKeys("Ini");
        driver.findElement(lastName).sendKeys("Liar");
        driver.findElement(btnupload).sendKeys("E:\\QA\\Big Project\\Foto/selenium.jpg");

    }

    public void ValidDataCreateLogin(){
        driver.findElement(firstName).sendKeys("Kadal");
        driver.findElement(midleName).sendKeys("Ini");
        driver.findElement(lastName).sendKeys("Liar");
        driver.findElement(btnupload).sendKeys("E:\\QA\\Big Project\\Foto/selenium.jpg");
        driver.findElement(chkLogin).click();

    }




}
