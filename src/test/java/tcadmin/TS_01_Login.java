package tcadmin;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageadmin.Login;

public class TS_01_Login {

    ExtentReports extent;
    WebDriver driver;


    @Before
    public void config(){

        System.setProperty("webdriver.chrome.driver", "E:/QA/Chrome Driver/chromedriver.exe");
        driver = new ChromeDriver();

        String path = System.getProperty("user.dir")+"\\reports\\admin\\login.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Project Result");
        reporter.config().setDocumentTitle("Test Result");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Deva");

    }

    @org.junit.Test
    public void emptyUsername() throws Throwable {
        extent.createTest("TC001 Login with empty username");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.Passwordd().sendKeys("coba");
        lg.BtnLogind().click();
        Assert.assertEquals("Username cannot be empty", lg.vUsernameEmpty().getText());

        extent.flush();
    }

    @Test
    public void emptyPassword() throws Throwable {
        extent.createTest("TC002 Login with empty password");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.Usernamed().sendKeys("Admin");
        lg.BtnLogind().click();
        Assert.assertEquals("Password cannot be empty", lg.vUsernameEmpty().getText());

        extent.flush();
    }

    @Test
    public void WrongUserName() throws Throwable {
        extent.createTest("TC003 Login with wrong username");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.Usernamed().sendKeys("Kadal");
        lg.Passwordd().sendKeys("s3Kol4HQA!*");
        lg.BtnLogind().click();
        Assert.assertEquals("Invalid credentials", lg.vUsernameEmpty().getText());

        extent.flush();
    }

    @Test
    public void WrongPassword() throws Throwable {
        extent.createTest("TC004 Login with wrong password");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.Usernamed().sendKeys("Admin");
        lg.Passwordd().sendKeys("Kada9l!*");
        lg.BtnLogind().click();
        Assert.assertEquals("Invalid credentials", lg.vUsernameEmpty().getText());

        extent.flush();
    }

    @Test
    public void Successlogin() throws Throwable {
        extent.createTest("TC005 Login with valid data");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        extent.flush();
    }

    @AfterTest
    public void quit() throws Throwable{
        driver.quit();
    }
}
