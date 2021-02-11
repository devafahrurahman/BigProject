package pageuser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginUser {
    WebDriver driver;

    public LoginUser (WebDriver driver) {

        this.driver = driver;
    }

    By username = By.id("txtUsername");
    By password = By.id("txtPassword");
    By btnLogin = By.id("btnLogin");

    By vUsernameEmpty = By.id("spanMessage");
    By vPasswordEmpty = By.id("spanMessage");
    By vLoginSuccess = By.xpath("//h1[contains(text(),'Dashboard')]");

    public WebElement Usernamed() {
        return driver.findElement(username);
    }
    public WebElement Passwordd() {
        return driver.findElement(password);
    }
    public WebElement BtnLogind() {
        return driver.findElement(btnLogin);
    }

    public WebElement vUsernameEmpty() {
        return driver.findElement(vUsernameEmpty);
    }

    public WebElement vLoginSuccess() {
        return driver.findElement(vLoginSuccess);
    }


    public void LoginSuccess(){
        driver.findElement(username).sendKeys("KadalLiar");
        driver.findElement(password).sendKeys("Kadalliar99!");
        driver.findElement(btnLogin).click();
        Assert.assertEquals("Dashboard", vLoginSuccess().getText());

    }
}
