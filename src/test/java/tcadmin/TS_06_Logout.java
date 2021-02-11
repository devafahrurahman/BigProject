package tcadmin;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageadmin.AssignLeave;
import pageadmin.Login;

public class TS_06_Logout {

    ExtentReports extent;
    WebDriver driver;

    @BeforeTest
    public void config(){

        System.setProperty("webdriver.chrome.driver", "E:/QA/Chrome Driver/chromedriver.exe");
        driver = new ChromeDriver();

        String path = System.getProperty("user.dir")+"\\reports\\admin\\logout.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Project Result");
        reporter.config().setDocumentTitle("Test Result");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Deva");

    }

    @Test(priority = 1)
    public void Test1() throws InterruptedException {
        extent.createTest("TC0053 Logout Admin");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");

        Login lg = new Login(driver);
        lg.LoginSuccess();
        Thread.sleep(2000);

        driver.findElement(By.id("welcome")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a")).click();

        Assert.assertEquals(driver.findElement(By.id("logInPanelHeading")).getText(), "LOGIN Panel");
        extent.flush();
    }

    @AfterTest
    public void quit() throws Throwable{
        driver.quit();
    }
}
