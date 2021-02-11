package tcuser;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageuser.Attendance;
import pageuser.LoginUser;

public class TS_02_Attendance {
    ExtentReports extent;
    WebDriver driver;
    @BeforeTest
    public void config(){

        System.setProperty("webdriver.chrome.driver", "E:/QA/Chrome Driver/chromedriver.exe");
        driver = new ChromeDriver();

        String path = System.getProperty("user.dir")+"\\reports\\user\\Attendance.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Project Result");
        reporter.config().setDocumentTitle("Test Result");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Deva");
    }

    @Test(priority = 1)
    public void Punchin() throws Throwable {
        extent.createTest("TC007 Punch in");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        LoginUser lu = new LoginUser(driver);
        lu.LoginSuccess();
        Thread.sleep(2000);

        Attendance at = new Attendance(driver);
        at.OpenPunch();

        at.Note().sendKeys("Al komen nu");
        at.BtnPunch().click();

        Assert.assertEquals(at.Vpunchin().getText(), "Punch Out");

        extent.flush();
    }


    @Test(priority = 2)
    public void Punchout() throws Throwable {
        extent.createTest("TC008 Punch out");

        Thread.sleep(10000);
        Attendance at = new Attendance(driver);
        at.BtnPunch().click();


        Assert.assertTrue(driver.getPageSource().contains("Successfully Saved"));

        extent.flush();
    }

    @AfterTest
    public void quit() throws Throwable{
        driver.quit();
    }
}
