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
import pageadmin.LeaveList;
import pageadmin.Login;

public class TS_05_AssignLeave {

    ExtentReports extent;
    WebDriver driver;

    @BeforeTest
    public void config(){

        System.setProperty("webdriver.chrome.driver", "E:/QA/Chrome Driver/chromedriver.exe");
        driver = new ChromeDriver();

        String path = System.getProperty("user.dir")+"\\reports\\admin\\assignleave.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Project Result");
        reporter.config().setDocumentTitle("Test Result");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Deva");

    }


    @Test(priority = 1)
    public void Test1() throws InterruptedException {
        extent.createTest("TC0045 Assign leave without employee name");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");

        Login lg = new Login(driver);
        lg.LoginSuccess();
        Thread.sleep(2000);

        AssignLeave al = new AssignLeave(driver);
        al.OpenAssignLeave();
        Thread.sleep(2000);

        al.EmployeeName().clear();
        Select type = new Select(al.SelectType());
        type.selectByVisibleText("Cuti");

        al.FromData().click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[3]")).click();
        Select duration = new Select(al.Duration());
        duration.selectByIndex(0);
        al.Comment().sendKeys("Ini komenu");

        al.BtnAssign().click();
        Thread.sleep(2000);

        Assert.assertEquals(al.VemptyEmployeename().getText(),"Required");

        extent.flush();
    }

    @Test(priority = 2)
    public void Test2() throws InterruptedException {
        extent.createTest("TC0046 Assign leave without leave type");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");

        Login lg = new Login(driver);
        lg.LoginSuccess();
        Thread.sleep(2000);

        AssignLeave al = new AssignLeave(driver);
        al.OpenAssignLeave();
        Thread.sleep(2000);

        al.EmployeeName().sendKeys("Kadal");
        driver.findElement(By.xpath("/html/body/div[6]/ul/li[1]")).click();

//        Select type = new Select(al.SelectType());
//        type.selectByVisibleText("Cuti");

        al.FromData().click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[3]")).click();
        Select duration = new Select(al.Duration());
        duration.selectByIndex(0);
        al.Comment().sendKeys("Ini komenu");

        al.BtnAssign().click();
        Thread.sleep(2000);

        Assert.assertEquals(al.VleaveType().getText(),"Required");

        extent.flush();
    }

    @Test(priority = 3)
    public void Test3() throws InterruptedException {
        extent.createTest("TC0047 Assign leave with empty fromdate");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");

        Login lg = new Login(driver);
        lg.LoginSuccess();
        Thread.sleep(2000);

        AssignLeave al = new AssignLeave(driver);
        al.OpenAssignLeave();
        Thread.sleep(2000);

        al.EmployeeName().sendKeys("Kadal");
        driver.findElement(By.xpath("/html/body/div[6]/ul/li[1]")).click();

        Select type = new Select(al.SelectType());
        type.selectByVisibleText("Cuti");

        al.FromData().click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[3]")).click();
        al.FromData().clear();

        Select duration = new Select(al.Duration());
        duration.selectByIndex(0);
        al.Comment().sendKeys("Ini komenu");

        al.BtnAssign().click();
        Thread.sleep(2000);

        Assert.assertEquals(al.VinvalidFromDate().getText(),"Should be a valid date in yyyy-mm-dd format");

        extent.flush();
    }

    @Test(priority = 4)
    public void Test4() throws InterruptedException {
        extent.createTest("TC0048 Assign leave with empty to date");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");

        Login lg = new Login(driver);
        lg.LoginSuccess();
        Thread.sleep(2000);

        AssignLeave al = new AssignLeave(driver);
        al.OpenAssignLeave();
        Thread.sleep(2000);

        al.EmployeeName().sendKeys("Kadal");
        driver.findElement(By.xpath("/html/body/div[6]/ul/li[1]")).click();

        Select type = new Select(al.SelectType());
        type.selectByVisibleText("Cuti");

        al.FromData().click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[3]")).click();
        al.Todate().clear();

        Select duration = new Select(al.Duration());
        duration.selectByIndex(0);
        al.Comment().sendKeys("Ini komenu");

        al.BtnAssign().click();
        Thread.sleep(2000);

        Assert.assertEquals(al.VinvalidToDate().getText(),"Should be a valid date in yyyy-mm-dd format");

        extent.flush();
    }

    @Test(priority = 5)
    public void Test5() throws InterruptedException {
        extent.createTest("TC0049 Assign leave with empty to date");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");

        Login lg = new Login(driver);
        lg.LoginSuccess();
        Thread.sleep(2000);

        AssignLeave al = new AssignLeave(driver);
        al.OpenAssignLeave();
        Thread.sleep(2000);

        al.EmployeeName().sendKeys("Kadal");
        driver.findElement(By.xpath("/html/body/div[6]/ul/li[1]")).click();

        Select type = new Select(al.SelectType());
        type.selectByVisibleText("Cuti");

        al.FromData().sendKeys("01-01-2022");
        al.Todate().sendKeys("01-01-2022");

        Select duration = new Select(al.Duration());
        duration.selectByIndex(0);
        al.Comment().sendKeys("Ini komenu");

        al.BtnAssign().click();
        Thread.sleep(2000);

        Assert.assertEquals(al.VinvalidFromDate().getText(),"Should be a valid date in yyyy-mm-dd format");
        Assert.assertEquals(al.VinvalidToDate().getText(),"Should be a valid date in yyyy-mm-dd format");

        extent.flush();
    }

    @Test(priority = 6)
    public void Test6() throws InterruptedException {
        extent.createTest("TC0050 Assign leave by entering from date < to date");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");

        Login lg = new Login(driver);
        lg.LoginSuccess();
        Thread.sleep(2000);

        AssignLeave al = new AssignLeave(driver);
        al.OpenAssignLeave();
        Thread.sleep(2000);

        al.EmployeeName().sendKeys("Kadal");
        driver.findElement(By.xpath("/html/body/div[6]/ul/li[1]")).click();

        Select type = new Select(al.SelectType());
        type.selectByVisibleText("Cuti");

        al.FromData().click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[3]")).click();

        al.Todate().click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[2]/a")).click();


        Select duration = new Select(al.Duration());
        duration.selectByIndex(0);
        al.Comment().sendKeys("Ini komenu");

        al.BtnAssign().click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[5]/span")).getText(),"To date should be after from date");

        extent.flush();
    }

    @Test(priority = 7)
    public void Test7() throws InterruptedException {
        extent.createTest("TC0051 Assign leave with balanche not sufficient");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");

        Login lg = new Login(driver);
        lg.LoginSuccess();
        Thread.sleep(2000);

        AssignLeave al = new AssignLeave(driver);
        al.OpenAssignLeave();
        Thread.sleep(2000);

        al.EmployeeName().sendKeys("Za");
        driver.findElement(By.xpath("/html/body/div[6]/ul/li[1]")).click();

        Select type = new Select(al.SelectType());
        type.selectByVisibleText("alpa");

        al.FromData().click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[3]")).click();

        al.Todate().click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[2]/a")).click();


        Select duration = new Select(al.Duration());
        duration.selectByIndex(0);
        al.Comment().sendKeys("Ini komenu");

        Thread.sleep(2000);
        al.BtnAssign().click();
        Thread.sleep(2000);

        driver.findElement(By.id("confirmOkButton")).click();
        Assert.assertTrue(driver.getPageSource().contains("Failed to Assign"));

        extent.flush();
    }

    @Test(priority = 8)
    public void Test8() throws InterruptedException {
        extent.createTest("TC0052 Assign leave with valid data");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");

        Login lg = new Login(driver);
        lg.LoginSuccess();
        Thread.sleep(2000);

        AssignLeave al = new AssignLeave(driver);
        al.OpenAssignLeave();
        Thread.sleep(2000);

        al.EmployeeName().sendKeys("Ant");
        driver.findElement(By.xpath("/html/body/div[6]/ul/li[1]")).click();

        Select type = new Select(al.SelectType());
        type.selectByVisibleText("Cuti");

        al.FromData().click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[3]")).click();

        al.Todate().click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]/a")).click();


        Select duration = new Select(al.Duration());
        duration.selectByIndex(0);
        al.Comment().sendKeys("Ini komenu");

        Thread.sleep(2000);
        al.BtnAssign().click();
        Thread.sleep(2000);

//        driver.findElement(By.id("confirmOkButton")).click();

        Assert.assertTrue(driver.getPageSource().contains("Successfully Assigned"));

        extent.flush();
    }

    @AfterTest
    public void quit() throws Throwable{
        driver.quit();
    }

}
