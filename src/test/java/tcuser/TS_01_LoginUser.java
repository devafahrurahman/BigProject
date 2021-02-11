package tcuser;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import javafx.scene.layout.Priority;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageadmin.Login;
import pageuser.LoginUser;

public class TS_01_LoginUser {
    ExtentReports extent;
    WebDriver driver;

    @BeforeTest
    public void config(){

        System.setProperty("webdriver.chrome.driver", "E:/QA/Chrome Driver/chromedriver.exe");
        driver = new ChromeDriver();

        String path = System.getProperty("user.dir")+"\\reports\\user\\loginuser.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Project Result");
        reporter.config().setDocumentTitle("Test Result");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Deva");
    }


    @Test (priority = 1)
    public void emptyUsername() throws Throwable {
        extent.createTest("TC001 User Login with empty username");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        LoginUser lu = new LoginUser(driver);
        lu.Passwordd().sendKeys("Kadalliar99!");
        lu.BtnLogind().click();
        Assert.assertEquals("Username cannot be empty", lu.vUsernameEmpty().getText());

        extent.flush();
    }


    @Test (priority = 2)
    public void emptyPassword() throws Throwable {
        extent.createTest("TC002 User Login with empty password");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        LoginUser lu = new LoginUser(driver);
        lu.Usernamed().sendKeys("KadalLiar");
        lu.BtnLogind().click();
        Assert.assertEquals("Password cannot be empty", lu.vUsernameEmpty().getText());

        extent.flush();
    }

    @Test (priority = 3)
    public void WrongUserName() throws Throwable {
        extent.createTest("TC003 User Login with wrong username");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        LoginUser lu = new LoginUser(driver);
        lu.Usernamed().sendKeys("Kadal");
        lu.Passwordd().sendKeys("s3Kol4HQA!*");
        lu.BtnLogind().click();
        Assert.assertEquals("Invalid credentials", lu.vUsernameEmpty().getText());

        extent.flush();
    }

    @Test (priority = 4)
    public void WrongPassword() throws Throwable {
        extent.createTest("TC004 User Login with wrong password");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        LoginUser lu = new LoginUser(driver);
        lu.Usernamed().sendKeys("Admin");
        lu.Passwordd().sendKeys("Kada9l!*");
        lu.BtnLogind().click();
        Assert.assertEquals("Invalid credentials", lu.vUsernameEmpty().getText());

        extent.flush();
    }

    @Test (priority = 5)
    public void Disbale() throws Throwable {
        extent.createTest("TC005 User Login where status is disable");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        LoginUser lu = new LoginUser(driver);
        lu.Usernamed().sendKeys("KadalDisable");
        lu.Passwordd().sendKeys("Kadalliar99!");
        lu.BtnLogind().click();
        Assert.assertEquals("Account disabled", lu.vUsernameEmpty().getText());

        extent.flush();
    }

    @Test(priority = 6)
    public void Successlogin() throws Throwable {
        extent.createTest("TC006 User Login with valid data");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        LoginUser lu = new LoginUser(driver);
        lu.LoginSuccess();

        extent.flush();
    }

    @AfterTest
    public void quit() throws Throwable{
        driver.quit();
    }
}
