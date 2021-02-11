package pageadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AttendanceAdmin {

    WebDriver driver;

    public AttendanceAdmin (WebDriver driver) {

        this.driver = driver;
    }

    By linktime = By.id("menu_time_viewTimeModule");
    By linkattendance = By.id("menu_attendance_Attendance");
    By linkpunch = By.id("menu_attendance_punchIn");

    By note = By.id("note");
    By btnpunch = By.id("btnPunch");

    By vpunchin = By.xpath("//*[@id=\"content\"]/div[2]/div[1]/h1");

    public WebElement Note(){
        return driver.findElement(note);
    }
    public WebElement BtnPunch(){
        return driver.findElement(btnpunch);
    }
    public WebElement Vpunchin(){
        return driver.findElement(vpunchin);
    }

    public void OpenPunch(){
        WebElement time = driver.findElement(linktime);
        Actions TIME = new Actions(driver);
        TIME.moveToElement(time).perform();
        WebElement atendance = driver.findElement(linkattendance);
        Actions ATTENDACE = new Actions(driver);
        ATTENDACE.moveToElement(atendance).perform();
        driver.findElement(linkpunch).click();
    }
}
