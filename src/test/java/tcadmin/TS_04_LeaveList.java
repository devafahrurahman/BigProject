package tcadmin;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import helper.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageadmin.LeaveList;
import pageadmin.Login;
import pageadmin.Report;

import java.util.List;

public class TS_04_LeaveList{
    ExtentReports extent;
    WebDriver driver;

    @BeforeTest
    public void config(){

        System.setProperty("webdriver.chrome.driver", "E:/QA/Chrome Driver/chromedriver.exe");
        driver = new ChromeDriver();

        String path = System.getProperty("user.dir")+"\\reports\\admin\\leaveList.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Project Result");
        reporter.config().setDocumentTitle("Test Result");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Deva");

    }

    @Test(priority = 1)
    public void Test1() throws InterruptedException {
        extent.createTest("TC0036 Search leave list by emptying TO date");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");

        Login lg = new Login(driver);
        lg.LoginSuccess();
        Thread.sleep(2000);

        LeaveList ll = new LeaveList(driver);
        ll.OpenLeaveList();
        Thread.sleep(2000);

        ll.FromDate().clear();
        ll.ToDate().clear();
        ll.ToDate().sendKeys("2022-12-31");
        driver.findElement(By.xpath("//*[@id=\"frmFilterLeave\"]/fieldset/ol/li[2]/img")).click();
        ll.StatusAll().click();

        ll.BtnSearch().click();

        Assert.assertTrue(driver.getPageSource().contains("2022"));
        Assert.assertFalse(driver.getPageSource().contains("2023"));
        Assert.assertFalse(driver.getPageSource().contains("2024"));
        Assert.assertFalse(driver.getPageSource().contains("2025"));

        extent.flush();
    }

    @Test(priority = 2)
    public void Test2() throws InterruptedException {
        extent.createTest("TC0037 Search leave list by emptying From date");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");

        Login lg = new Login(driver);
        lg.LoginSuccess();
        Thread.sleep(2000);

        LeaveList ll = new LeaveList(driver);
        ll.OpenLeaveList();
        Thread.sleep(2000);

        ll.FromDate().clear();
        ll.FromDate().sendKeys("2021-01-01");
        ll.ToDate().clear();
        driver.findElement(By.xpath("//*[@id=\"frmFilterLeave\"]/fieldset/ol/li[2]/img")).click();

        ll.StatusAll().click();

        ll.BtnSearch().click();

        Assert.assertTrue(driver.getPageSource().contains("2023"));
        Assert.assertFalse(driver.getPageSource().contains("2020"));
        Assert.assertFalse(driver.getPageSource().contains("2019"));
        Assert.assertFalse(driver.getPageSource().contains("2018"));

        extent.flush();
    }

   @Test(priority = 3)
    public void Test3() throws InterruptedException {
        extent.createTest("TC0038 Search leave list by invalid date");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");

        Login lg = new Login(driver);
        lg.LoginSuccess();
        Thread.sleep(2000);

        LeaveList ll = new LeaveList(driver);
        ll.OpenLeaveList();
        Thread.sleep(2000);

        ll.FromDate().sendKeys("2021-01-01");
        ll.ToDate().sendKeys("2022-12-31");


        ll.StatusAll().click();

        ll.BtnSearch().click();

        Assert.assertEquals(ll.VfromDateInvalid().getText(),"Should be a valid date in yyyy-mm-dd format");
        Assert.assertEquals(ll.VtoDateInvalid().getText(),"Should be a valid date in yyyy-mm-dd format");

        extent.flush();
    }


    @Test(priority = 4)
    public void Test4() throws InterruptedException {
        extent.createTest("TC0040 Search leave list not found");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");

        Login lg = new Login(driver);
        lg.LoginSuccess();
        Thread.sleep(2000);

        LeaveList ll = new LeaveList(driver);
        ll.OpenLeaveList();
        Thread.sleep(2000);

        ll.FromDate().clear();
        ll.FromDate().sendKeys("2021-01-01");
        ll.ToDate().clear();
        ll.ToDate().sendKeys("2022-12-31");
        driver.findElement(By.xpath("//*[@id=\"frmFilterLeave\"]/fieldset/ol/li[2]/img")).click();

        ll.StatusAll().click();

        Select subunit = new Select(ll.SelectSubUnit());
        subunit.selectByIndex(1);

        ll.BtnSearch().click();

        Assert.assertEquals(ll.VnotFound().getText(), "No Records Found");

        extent.flush();
    }

    @Test(priority = 5)
    public void Test5() throws InterruptedException {
        extent.createTest("TC0040 Search leave list with checking show leave status");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");

        Login lg = new Login(driver);
        lg.LoginSuccess();
        Thread.sleep(2000);

        LeaveList ll = new LeaveList(driver);
        ll.OpenLeaveList();
        Thread.sleep(2000);

        ll.FromDate().clear();
        ll.FromDate().sendKeys("2021-01-01");
        ll.ToDate().clear();
        ll.ToDate().sendKeys("2022-12-31");
        driver.findElement(By.xpath("//*[@id=\"frmFilterLeave\"]/fieldset/ol/li[2]/img")).click();

        ll.StatusAll().click();
        ll.StatusAll().click();


        ll.StatusPending().click();

        driver.findElement(By.id("leaveList_cmbWithTerminated")).click();

        ll.BtnSearch().click();

        Assert.assertTrue(driver.getPageSource().contains("Pending Approval"));
        Assert.assertTrue(ll.VstatusApproval2().getText().contains("Pending Approval"), "Pending Approval");
        Assert.assertTrue(ll.VstatusApproval3().getText().contains("Pending Approval"), "Pending Approval");

        extent.flush();
    }

    @Test(priority = 6)
    public void Test6() throws InterruptedException {
        extent.createTest("TC0041 Search leave list by entering employee name");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");

        Login lg = new Login(driver);
        lg.LoginSuccess();
        Thread.sleep(2000);

        LeaveList ll = new LeaveList(driver);
        ll.OpenLeaveList();
        Thread.sleep(2000);

        ll.FromDate().clear();
        ll.FromDate().sendKeys("2021-01-01");
        ll.ToDate().clear();
        ll.ToDate().sendKeys("2022-12-31");
        driver.findElement(By.xpath("//*[@id=\"frmFilterLeave\"]/fieldset/ol/li[2]/img")).click();

        ll.StatusAll().click();

        ll.EmployeeName().sendKeys("Kadal");

        driver.findElement(By.xpath("/html/body/div[5]/ul/li[1]")).click();

        ll.BtnSearch().click();

        Assert.assertEquals(ll.VemployeeName().getText(), "Kadal Ini Liar");

        extent.flush();
    }

    @Test(priority = 7)
    public void Test7() throws InterruptedException {
        extent.createTest("TC0042 Search leave list by entering sub unit");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");

        Login lg = new Login(driver);
        lg.LoginSuccess();
        Thread.sleep(2000);

        LeaveList ll = new LeaveList(driver);
        ll.OpenLeaveList();
        Thread.sleep(2000);

        ll.FromDate().clear();
        ll.FromDate().sendKeys("2021-01-01");
        ll.ToDate().clear();
        ll.ToDate().sendKeys("2022-12-31");
        driver.findElement(By.xpath("//*[@id=\"frmFilterLeave\"]/fieldset/ol/li[2]/img")).click();

        ll.StatusAll().click();

        Select subunit = new Select(ll.SelectSubUnit());
        subunit.selectByIndex(1);

        driver.findElement(By.id("leaveList_cmbWithTerminated")).click();

        ll.BtnSearch().click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"frmEmpCustomFields\"]/ol/li/label")).getText(), "inosuke");

        extent.flush();
    }

    @Test(priority = 8)
    public void Test8() throws InterruptedException {
        extent.createTest("TC0043 Handle action where status pending approval");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");

        Login lg = new Login(driver);
        lg.LoginSuccess();
        Thread.sleep(2000);

        LeaveList ll = new LeaveList(driver);
        ll.OpenLeaveList();
        Thread.sleep(2000);

        ll.FromDate().clear();
        ll.FromDate().sendKeys("2021-01-01");
        ll.ToDate().clear();
        ll.ToDate().sendKeys("2022-12-31");
        driver.findElement(By.xpath("//*[@id=\"frmFilterLeave\"]/fieldset/ol/li[2]/img")).click();

        driver.findElement(By.id("leaveList_cmbWithTerminated")).click();

        ll.BtnSearch().click();
        Thread.sleep(2000);


        Assert.assertEquals(ll.SelectAction().getText(), "Select Action\n" +
                "Approve\n" +
                "Cancel\n" +
                "Reject");

        Select ation = new Select(ll.SelectAction());
        ation.selectByIndex(1);

        ll.BtnSave().click();

        Assert.assertTrue(driver.getPageSource().contains("Successfully Updated"));

        extent.flush();
    }

    @Test(priority = 9)
    public void Test9() throws InterruptedException {
        extent.createTest("TC0044 Handle action where status schedule");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");

        Login lg = new Login(driver);
        lg.LoginSuccess();
        Thread.sleep(2000);

        LeaveList ll = new LeaveList(driver);
        ll.OpenLeaveList();
        Thread.sleep(2000);

        ll.FromDate().clear();
        ll.FromDate().sendKeys("2021-01-01");
        ll.ToDate().clear();
        ll.ToDate().sendKeys("2022-12-31");
        driver.findElement(By.xpath("//*[@id=\"frmFilterLeave\"]/fieldset/ol/li[2]/img")).click();

        ll.StatusAll().click();
        ll.StatusAll().click();
        driver.findElement(By.id("leaveList_chkSearchFilter_2")).click();


        driver.findElement(By.id("leaveList_cmbWithTerminated")).click();

        ll.BtnSearch().click();
        Thread.sleep(2000);

        WebElement schedule = driver.findElement(By.xpath("//*[@id=\"select_leave_action_74\"]"));

        Assert.assertEquals(schedule.getText(), "Select Action\n" +
                "Cancel");

        Select ation = new Select(schedule);
        ation.selectByIndex(1);

        ll.BtnSave().click();

        Assert.assertTrue(driver.getPageSource().contains("Successfully Updated"));

        extent.flush();
    }

    @Test(priority = 10)
    public void Test10() throws InterruptedException {
        extent.createTest("TC0044 Handle action where status taken");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");

        Login lg = new Login(driver);
        lg.LoginSuccess();
        Thread.sleep(2000);

        LeaveList ll = new LeaveList(driver);
        ll.OpenLeaveList();
        Thread.sleep(2000);

        ll.FromDate().clear();
        ll.FromDate().sendKeys("2021-01-01");
        ll.ToDate().clear();
        ll.ToDate().sendKeys("2022-12-31");
        driver.findElement(By.xpath("//*[@id=\"frmFilterLeave\"]/fieldset/ol/li[2]/img")).click();

        ll.StatusAll().click();
        ll.StatusAll().click();
        driver.findElement(By.id("leaveList_chkSearchFilter_3")).click();


        driver.findElement(By.id("leaveList_cmbWithTerminated")).click();

        ll.BtnSearch().click();
        Thread.sleep(2000);

        WebElement schedule = driver.findElement(By.xpath("//*[@id=\"select_leave_action_71\"]"));

        Assert.assertEquals(schedule.getText(), "Select Action\n" +
                "Cancel");

        Select ation = new Select(schedule);
        ation.selectByIndex(1);

        ll.BtnSave().click();

        Assert.assertTrue(driver.getPageSource().contains("Successfully Updated"));

        extent.flush();
    }

    @AfterTest
    public void quit() throws Throwable{
        driver.quit();
    }

}
