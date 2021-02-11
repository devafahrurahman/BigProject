package tcadmin;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageadmin.Login;
import pageadmin.Report;

public class TS_03_Report {
    ExtentReports extent;
    WebDriver driver;

    @BeforeTest
    public void config(){

        System.setProperty("webdriver.chrome.driver", "E:/QA/Chrome Driver/chromedriver.exe");
        driver = new ChromeDriver();

        String path = System.getProperty("user.dir")+"\\reports\\admin\\report.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Project Result");
        reporter.config().setDocumentTitle("Test Result");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Deva");

    }

    @Test (priority = 1)
    public void Test1() throws InterruptedException {
        extent.createTest("TC0024 Search report not found");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Report rp = new Report(driver);
        rp.OpenReport();
        Thread.sleep(2000);
        rp.SearchReport().sendKeys("Lalalala");
        rp.BtnSearch().click();

        Assert.assertEquals(rp.VsearchNotFound().getText(), "No Records Found");

        extent.flush();
    }

    @Test (priority = 2)
    public void Test2() throws InterruptedException {
        extent.createTest("TC0025 Check button reset");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Report rp = new Report(driver);
        rp.OpenReport();
        Thread.sleep(2000);
        rp.SearchReport().sendKeys("Lalalala");
        rp.BtnSearch().click();
        Thread.sleep(2000);
        rp.BtnReset().click();


        Assert.assertEquals(rp.SearchReport().getText(), "");

        extent.flush();
    }

    @Test (priority = 3)
    public void Test3() throws InterruptedException {
        extent.createTest("TC0026 Search added report ");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Report rp = new Report(driver);
        rp.OpenReport();
        Thread.sleep(2000);
        rp.SearchReport().sendKeys("Coba");
        rp.BtnSearch().click();

        Assert.assertTrue(rp.VsearchFound().isDisplayed());
        Assert.assertTrue(driver.getPageSource().contains("Coba"));

        extent.flush();
    }

    @Test (priority = 4)
    public void Test4() throws InterruptedException {
        extent.createTest("TC0027 Check button add");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Report rp = new Report(driver);
        rp.OpenReport();
        Thread.sleep(2000);
        rp.BtnAdd().click();

        Assert.assertEquals(rp.VdefineReport().getText(), "Define Report");

        extent.flush();
    }

    @Test (priority = 5)
    public void Test5() throws InterruptedException {
        extent.createTest("TC0028 Define report without entering report name");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Report rp = new Report(driver);
        rp.OpenReport();
        Thread.sleep(2000);
        rp.BtnAdd().click();
        Assert.assertEquals(rp.VdefineReport().getText(), "Define Report");
        Thread.sleep(2000);

        Select criteria = new Select(rp.SelectCriteria());
        criteria.selectByIndex(0);
        rp.AddCriteria().click();
        rp.EmployeeName().sendKeys("Kadal T");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[5]/ul[1]/li[1]")).click();

        Select displayfield = new Select(rp.SelectDisplayField());
        displayfield.selectByIndex(0);
        rp.AddDisplayField().click();

        Assert.assertTrue(driver.findElement(By.id("display_groups")).isDisplayed());

        rp.BtnSave().click();

        Assert.assertEquals(rp.VemptyReportName().getText(), "Required");

        extent.flush();
    }

    @Test (priority = 6)
    public void Test6() throws InterruptedException {
        extent.createTest("TC0029 Define report without selecting criteria");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Report rp = new Report(driver);
        rp.OpenReport();
        Thread.sleep(2000);
        rp.BtnAdd().click();
        Assert.assertEquals(rp.VdefineReport().getText(), "Define Report");
        Thread.sleep(2000);

        rp.ReportName().sendKeys("Kudanil");
        Thread.sleep(2000);

        Select displayfield = new Select(rp.SelectDisplayField());
        displayfield.selectByIndex(2);
        Thread.sleep(1000);
        rp.AddDisplayField().click();

        Assert.assertTrue(driver.findElement(By.id("display_groups")).isDisplayed());

        rp.BtnSave().click();

        Assert.assertEquals(driver.findElement(By.className("head")).getText(), "Employee Reports");
//        Assert.assertEquals(rp.VemptyReportName().getText(), "Required");

        extent.flush();
    }

    @Test (priority = 7)
    public void Test7() throws InterruptedException {
        extent.createTest("TC0030 Define report with emptying selection criteria");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Report rp = new Report(driver);
        rp.OpenReport();
        Thread.sleep(2000);
        rp.BtnAdd().click();
        Assert.assertEquals(rp.VdefineReport().getText(), "Define Report");
        Thread.sleep(2000);

        rp.ReportName().sendKeys("Pinguin");
        Select criteria = new Select(rp.SelectCriteria());
        criteria.selectByIndex(0);

        for (int i = 0; i < 4; i++){
            rp.AddCriteria().click();
        }


        Select displayfield = new Select(rp.SelectDisplayField());
        displayfield.selectByIndex(0);
        rp.AddDisplayField().click();

        Assert.assertTrue(driver.findElement(By.id("display_groups")).isDisplayed());

        rp.BtnSave().click();

        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.className("error_list")).getText(), "Required");

        extent.flush();
    }

    @Test (priority = 8)
    public void Test8() throws InterruptedException {
        extent.createTest("TC0031 Define report without adding display field");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Report rp = new Report(driver);
        rp.OpenReport();
        Thread.sleep(2000);
        rp.BtnAdd().click();
        Assert.assertEquals(rp.VdefineReport().getText(), "Define Report");
        Thread.sleep(2000);

        rp.ReportName().sendKeys("Kura kura");
        Select criteria = new Select(rp.SelectCriteria());
        criteria.selectByIndex(0);
        rp.AddCriteria().click();

        rp.EmployeeName().sendKeys("Kadal T");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[5]/ul[1]/li[1]")).click();

        rp.BtnSave().click();

        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.className("validation-error")).getText(), "Required");

        extent.flush();
    }

    @Test (priority = 9)
    public void Test9() throws InterruptedException {
        extent.createTest("TC0032 Define report by adding a display field based on the display field group");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Report rp = new Report(driver);
        rp.OpenReport();
        Thread.sleep(2000);
        rp.BtnAdd().click();
        Assert.assertEquals(rp.VdefineReport().getText(), "Define Report");
        Thread.sleep(2000);

        rp.ReportName().sendKeys("Kura kura");
        Select criteria = new Select(rp.SelectCriteria());
        criteria.selectByIndex(0);
        rp.AddCriteria().click();

        rp.EmployeeName().sendKeys("Kadal T");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[5]/ul[1]/li[1]")).click();

        Select displayfieldgroup = new Select(rp.SelectDisplayFieldGroup());
        displayfieldgroup.selectByIndex(0);
        rp.AddDisplayFieldGroup().click();

        Assert.assertTrue(driver.findElement(By.id("display_groups")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.id("report_display_field_list")).getText(), "");

        rp.BtnSave().click();

        Thread.sleep(2000);

        Assert.assertTrue(driver.getPageSource().contains("Successfully Saved"));

        extent.flush();
    }

    @Test (priority = 10)
    public void Test10() throws InterruptedException {
        extent.createTest("TC0033 Define report by adding a display field based on the display field selection");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Report rp = new Report(driver);
        rp.OpenReport();
        Thread.sleep(2000);
        rp.BtnAdd().click();
        Assert.assertEquals(rp.VdefineReport().getText(), "Define Report");
        Thread.sleep(2000);

        rp.ReportName().sendKeys("Kura kura");
        Select criteria = new Select(rp.SelectCriteria());
        criteria.selectByIndex(0);
        rp.AddCriteria().click();

        rp.EmployeeName().sendKeys("Kadal T");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[5]/ul[1]/li[1]")).click();

        Select displayfield = new Select(rp.SelectDisplayField());
        displayfield.selectByIndex(0);

        for (int i = 0; i < 5; i++){
            rp.AddDisplayField().click();
        }

//        rp.BtnSave().click();

        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"display_groups\"]/li[2]/ul/li[1]/label")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"display_groups\"]/li[2]/ul/li[2]/label")).isDisplayed());

        extent.flush();
    }

    @Test (priority = 11)
    public void Test11() throws InterruptedException {
        extent.createTest("TC0034 Define report entering valid data");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Report rp = new Report(driver);
        rp.OpenReport();
        Thread.sleep(2000);
        rp.BtnAdd().click();
        Assert.assertEquals(rp.VdefineReport().getText(), "Define Report");
        Thread.sleep(2000);

        rp.ReportName().sendKeys("Pinguin");
        Select criteria = new Select(rp.SelectCriteria());
        criteria.selectByIndex(0);

        for (int i = 0; i < 14; i++){
            rp.AddCriteria().click();
        }

        rp.EmployeeName().sendKeys("Kadal T");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[5]/ul[1]/li[1]")).click();

        Select paygrade = new Select(rp.Paygrade());
        paygrade.selectByIndex(1);

        Select education = new Select(rp.Education());
        education.selectByIndex(1);

        Select employmentstatus = new Select(rp.EmployementStatus());
        employmentstatus.selectByIndex(2);

        Select serviceperiod = new Select(rp.ServicePeriod());
        serviceperiod.selectByIndex(2);
        Assert.assertTrue(driver.findElement(By.id("service_period_value1")).isDisplayed());
        driver.findElement(By.id("service_period_value1")).sendKeys("4");

        Select joindate = new Select(rp.JoinedDate());
        joindate.selectByIndex(1);
        driver.findElement(By.id("joined_date_from")).clear();
        driver.findElement(By.id("joined_date_from")).sendKeys("2002-05-18");

        Select jobtitle = new Select(rp.JobTitle());
        jobtitle.selectByIndex(1);

        Select language = new Select(rp.Language());
        language.selectByIndex(1);

        Select skill = new Select(rp.Skill());
        skill.selectByIndex(1);

        Select agegroup = new Select(rp.AgeGroup());
        agegroup.selectByIndex(2);
        Assert.assertTrue(driver.findElement(By.id("age_group_value1")).isDisplayed());
        driver.findElement(By.id("age_group_value1")).sendKeys("4");

        Select subunit = new Select(rp.Subunit());
        subunit.selectByIndex(1);

        Select gender = new Select(rp.Gender());
        gender.selectByIndex(1);

        Select location = new Select(rp.Location());
        location.selectByIndex(1);


        Select displayfieldgroup = new Select(rp.SelectDisplayFieldGroup());
        displayfieldgroup.selectByIndex(0);
        rp.AddDisplayFieldGroup().click();

        Assert.assertTrue(driver.findElement(By.id("display_groups")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.id("report_display_field_list")).getText(), "");

        Assert.assertTrue(driver.findElement(By.id("display_groups")).isDisplayed());

        rp.BtnSave().click();

        Thread.sleep(2000);

        driver.getPageSource().contains("Successfully Saved");

        Assert.assertEquals(driver.findElement(By.className("head")).getText(),"Employee Reports");

        extent.flush();
    }

    @Test (priority = 12)
    public void Test12() throws InterruptedException {
        extent.createTest("TC0035 Check button cancel");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Report rp = new Report(driver);
        rp.OpenReport();
        Thread.sleep(2000);
        rp.BtnAdd().click();
        Thread.sleep(2000);
        driver.findElement(By.id("btnCancel")).click();

        Assert.assertEquals(driver.findElement(By.className("head")).getText(),"Employee Reports");

        extent.flush();
    }

    @Test (priority = 13)
    public void Test13() throws InterruptedException {
        extent.createTest("TC0100 Delete report");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Report rp = new Report(driver);
        rp.OpenReport();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"ohrmList_chkSelectRecord_13\"]")).click();
        driver.findElement(By.id("btnDelete")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("dialogDeleteBtn")).click();

        Assert.assertTrue(driver.getPageSource().contains("Successfully Deleted"));

        extent.flush();
    }

    @AfterTest
    public void quit() throws Throwable{
        driver.quit();
    }

}
