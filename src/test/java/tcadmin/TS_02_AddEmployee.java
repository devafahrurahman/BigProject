package tcadmin;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageadmin.AddEmployee;
import pageadmin.Login;

public class TS_02_AddEmployee {

    ExtentReports extent;
    WebDriver driver;


    @BeforeTest
    public void config(){

        String path = System.getProperty("user.dir")+"\\reports\\coba\\coba.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Project Result");
        reporter.config().setDocumentTitle("Test Result");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Deva");

        System.setProperty("webdriver.chrome.driver", "E:/QA/Chrome Driver/chromedriver.exe");
        driver = new ChromeDriver();

    }


    @Test (priority=1)
    public void Test1() throws Throwable {
        extent.createTest("TC0006 Add Employee with empty fullname field");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Thread.sleep(2000);
        AddEmployee ae = new AddEmployee(driver);
        ae.OpenAddEmployee();

        ae.Upload().sendKeys("E:\\QA\\Big Project\\Foto/selenium.jpg");

        ae.BtnSave().click();

        Assert.assertEquals("Required", ae.VemptyFN().getText());
        Assert.assertEquals("Required", ae.VemptyLN().getText());

        extent.flush();

    }

    @Test (priority=2)
    public void Test2() throws Throwable {
        extent.createTest("TC0007 Add Employee with empty firstname field");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        AddEmployee ae = new AddEmployee(driver);
        ae.OpenAddEmployee();
        Thread.sleep(2000);

        ae.MidleName().sendKeys("Ini");
        ae.Lastname().sendKeys("Liar");
        ae.Upload().sendKeys("E:\\QA\\Big Project\\Foto/selenium.jpg");

        ae.BtnSave().click();

        Thread.sleep(2000);
        Assert.assertEquals(ae.VemptyFN().getText(), "Required");

        extent.flush();

    }

    @Test (priority=3)
    public void Test3() throws Throwable {
        extent.createTest("TC0008 Add Employee with empty middle field");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Thread.sleep(2000);
        AddEmployee ae = new AddEmployee(driver);
        ae.OpenAddEmployee();

        ae.FirstName().sendKeys("Kuda");
        ae.Lastname().sendKeys("Terbang");
        ae.Upload().sendKeys("E:\\QA\\Big Project\\Foto/selenium.jpg");

        ae.BtnSave().click();
        Thread.sleep(5000);

        Assert.assertTrue(ae.VaddSuccess().isDisplayed());

        extent.flush();
    }

    @Test (priority=4)
    public void Test4() throws Throwable {
        extent.createTest("TC0009 Add Employee with empty lastname field");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Thread.sleep(2000);
        AddEmployee ae = new AddEmployee(driver);
        ae.OpenAddEmployee();

        ae.FirstName().sendKeys("Kada");
        ae.MidleName().sendKeys("Ini");
        ae.Upload().sendKeys("E:\\QA\\Big Project\\Foto/selenium.jpg");

        ae.BtnSave().click();

        Assert.assertEquals("Required", ae.VemptyLN().getText());

        extent.flush();
    }

    @Test (priority=5)
    public void Test5() throws Throwable {
        ExtentTest test = extent.createTest("TC0010 Add Employee with empty employee id field");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Thread.sleep(2000);
        AddEmployee ae = new AddEmployee(driver);
        ae.OpenAddEmployee();

        ae.FirstName().sendKeys("Banteng");
        ae.MidleName().sendKeys("Ini");
        ae.Lastname().sendKeys("Galak");
        ae.EmployeeId().clear();
        ae.Upload().sendKeys("E:\\QA\\Big Project\\Foto/selenium.jpg");

        ae.BtnSave().click();

        test.fail("Fail");

//        Assert.assertEquals("Required", ae.VemptyLN().getText());


        extent.flush();
    }

    @Test (priority=6)
    public void Test6() throws Throwable {
        ExtentTest test = extent.createTest("TC0011 Add Employee with registred employee id");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Thread.sleep(2000);
        AddEmployee ae = new AddEmployee(driver);
        ae.OpenAddEmployee();

        ae.FirstName().sendKeys("Banteng");
        ae.MidleName().sendKeys("Ini");
        ae.Lastname().sendKeys("Galak");
        ae.EmployeeId().clear();
        ae.Upload().sendKeys("E:\\QA\\Big Project\\Foto/selenium.jpg");

        ae.BtnSave().click();

        test.fail("Fail");

//        Assert.assertEquals("Employee ID has been registred", ae.VemptyLN().getText());

        extent.flush();
    }

    @Test (priority=7)
    public void Test7() throws Throwable {
        extent.createTest("TC0012 Add Employee without upload photograph");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();


        AddEmployee ae = new AddEmployee(driver);
        Thread.sleep(1000);
        ae.OpenAddEmployee();

        ae.FirstName().sendKeys("Kuda");
        ae.MidleName().sendKeys("Tidak");
        ae.Lastname().sendKeys("Terbang");

        ae.BtnSave().click();
        Thread.sleep(2000);
        Assert.assertTrue(ae.VaddSuccess().isDisplayed());

        extent.flush();
    }

    @Test (priority=8)
    public void Test8() throws Throwable {
        extent.createTest("TC0013 Add Employee with valid data without login details ");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Thread.sleep(2000);
        AddEmployee ae = new AddEmployee(driver);
        ae.OpenAddEmployee();

        ae.FirstName().sendKeys("Kalilawar");
        ae.MidleName().sendKeys("Jatuh");
        ae.Lastname().sendKeys("Terbang");
        ae.Upload().sendKeys("E:\\QA\\Big Project\\Foto/selenium.jpg");

        ae.BtnSave().click();

        Thread.sleep(2000);
        Assert.assertTrue(ae.VaddSuccess().isDisplayed());

        extent.flush();
    }

    @Test (priority=9)
    public void Test9() throws Throwable {
        extent.createTest("TC0014 Add Employee by entering username < 5 ");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Thread.sleep(2000);
        AddEmployee ae = new AddEmployee(driver);
        ae.OpenAddEmployee();

        ae.ValidDataWithoutCreateLogin();

        ae.ChckLogin().click();

        ae.UserName().sendKeys("kada");
        ae.Password().sendKeys("KadalLiar99!");
        ae.Cpassword().sendKeys("KadalLiar99!");
        Select status = new Select(ae.SelectStatus());
        status.selectByIndex(0);

        ae.BtnSave().click();

        Assert.assertEquals("Should have at least 5 characters", ae.VinvalidUN().getText());

        extent.flush();
    }

    @Test (priority=10)
    public void Test10() throws Throwable {
        extent.createTest("TC0015 Add Employee using registred username");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();


        AddEmployee ae = new AddEmployee(driver);
        Thread.sleep(10000);
        ae.OpenAddEmployee();

        ae.ValidDataCreateLogin();

        ae.UserName().sendKeys("Cobaliar");
        ae.Password().sendKeys("KadalLiar99!");
        ae.Cpassword().sendKeys("KadalLiar99!");
        Select status = new Select(ae.SelectStatus());
        status.selectByIndex(0);

        ae.BtnSave().click();

        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText(), "Add Employee");

        extent.flush();
    }

    @Test (priority=11)
    public void Test11() throws Throwable {
        extent.createTest("TC0016 Add Employee with entering password < 8 character");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        AddEmployee ae = new AddEmployee(driver);
        Thread.sleep(10000);
        ae.OpenAddEmployee();

        ae.ValidDataCreateLogin();
        Thread.sleep(2000);

        ae.ChckLogin().click();

        ae.UserName().sendKeys("Oraaaaa");
        ae.Password().sendKeys("Ka99!");
        ae.Cpassword().sendKeys("Ka99!");
        Select status = new Select(ae.SelectStatus());
        status.selectByIndex(0);


        ae.BtnSave().click();
        Thread.sleep(5000);

        Assert.assertEquals(ae.VinvalidPassword().getText(), "Should have at least 8 characters");

        extent.flush();
    }

    @Test (priority=12)
    public void Test12() throws Throwable {
        extent.createTest("TC0017 Add Employee with entering password without uppercase");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Thread.sleep(2000);
        AddEmployee ae = new AddEmployee(driver);
        ae.OpenAddEmployee();

        ae.ValidDataCreateLogin();
        Thread.sleep(2000);

        ae.ChckLogin().click();

        ae.UserName().sendKeys("Cobaliab");
        ae.Password().sendKeys("kadal99!");
        ae.Cpassword().sendKeys("kadal99!");
        Select status = new Select(ae.SelectStatus());
        status.selectByIndex(0);

        ae.BtnSave().click();
        Thread.sleep(5000);

        Assert.assertEquals(ae.VinvalidPassword().getText(), "Your password must contain a lower-case letter, an upper-case letter, a digit and a special character. Try a different password.");

        extent.flush();
    }

    @Test (priority=13)
    public void Test13() throws Throwable {
        extent.createTest("TC0018 Add Employee with entering password without lowercase");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Thread.sleep(2000);
        AddEmployee ae = new AddEmployee(driver);
        ae.OpenAddEmployee();

        ae.ValidDataCreateLogin();
        Thread.sleep(2000);

        ae.ChckLogin().click();

        ae.UserName().sendKeys("Cobaliarc");
        ae.Password().sendKeys("KADAL99!");
        ae.Cpassword().sendKeys("KADAL99!");
        Select status = new Select(ae.SelectStatus());
        status.selectByIndex(0);

        ae.BtnSave().click();
        Thread.sleep(5000);

        Assert.assertEquals(ae.VinvalidPassword().getText(), "Your password must contain a lower-case letter, an upper-case letter, a digit and a special character. Try a different password.");

        extent.flush();
    }

    @Test (priority=14)
    public void Test14() throws Throwable {
        extent.createTest("TC0019 Add Employee with entering password without number");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Thread.sleep(2000);
        AddEmployee ae = new AddEmployee(driver);
        ae.OpenAddEmployee();

        ae.ValidDataCreateLogin();
        Thread.sleep(2000);

        ae.ChckLogin().click();

        ae.UserName().sendKeys("Cobaliard");
        ae.Password().sendKeys("Kadalliar!");
        ae.Cpassword().sendKeys("Kadalliar!");
        Select status = new Select(ae.SelectStatus());
        status.selectByIndex(0);

        ae.BtnSave().click();
        Thread.sleep(5000);

        Assert.assertEquals(ae.VinvalidPassword().getText(), "Your password must contain a lower-case letter, an upper-case letter, a digit and a special character. Try a different password.");

        extent.flush();
    }

    @Test (priority=15)
    public void Test15() throws Throwable {
        extent.createTest("TC0020 Add Employee with entering password without symbol");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Thread.sleep(2000);
        AddEmployee ae = new AddEmployee(driver);
        ae.OpenAddEmployee();

        ae.ValidDataCreateLogin();
        Thread.sleep(2000);

        ae.ChckLogin().click();

        ae.UserName().sendKeys("Cobaliare");
        ae.Password().sendKeys("Kadalliar99");
        ae.Cpassword().sendKeys("Kadalliar99");
        Select status = new Select(ae.SelectStatus());
        status.selectByIndex(0);

        ae.BtnSave().click();
        Thread.sleep(5000);

        Assert.assertEquals(ae.VinvalidPassword().getText(), "Your password must contain a lower-case letter, an upper-case letter, a digit and a special character. Try a different password.");

        extent.flush();
    }

    @Test (priority=16)
    public void Test16() throws Throwable {
        extent.createTest("TC0021 Add Employee with entering password without alphabet");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Thread.sleep(2000);
        AddEmployee ae = new AddEmployee(driver);
        ae.OpenAddEmployee();

        ae.ValidDataCreateLogin();
        Thread.sleep(2000);

        ae.ChckLogin().click();

        ae.UserName().sendKeys("Cobaliarf");
        ae.Password().sendKeys("1234567899!");
        ae.Cpassword().sendKeys("1234567899!");
        Select status = new Select(ae.SelectStatus());
        status.selectByIndex(0);

        ae.BtnSave().click();
        Thread.sleep(5000);

        Assert.assertEquals(ae.VinvalidPassword().getText(), "Your password must contain a lower-case letter, an upper-case letter, a digit and a special character. Try a different password.");

        extent.flush();
    }

    @Test (priority=17)
    public void Test17() throws Throwable {
        extent.createTest("TC0022 Add Employee with entering password not match");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Thread.sleep(2000);
        AddEmployee ae = new AddEmployee(driver);
        ae.OpenAddEmployee();

        ae.ValidDataCreateLogin();
        Thread.sleep(2000);

        ae.ChckLogin().click();

        ae.UserName().sendKeys("Cobaliargau");
        ae.Password().sendKeys("KadalLiar99");
        ae.Cpassword().sendKeys("KadalLiar00");
        Select status = new Select(ae.SelectStatus());
        status.selectByIndex(0);

        ae.BtnSave().click();
        Thread.sleep(5000);

        Assert.assertEquals(ae.VcPassword().getText(), "Passwords do not match");

        extent.flush();
    }

    @Test (priority=18)
    public void Test18() throws Throwable {
        extent.createTest("TC0023 Add Employee with entering valid data");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Thread.sleep(2000);
        AddEmployee ae = new AddEmployee(driver);
        ae.OpenAddEmployee();

        ae.ValidDataCreateLogin();
        Thread.sleep(2000);

        ae.ChckLogin().click();

        ae.UserName().sendKeys("Cosal121aacolaahuyodpra12");
        ae.Password().sendKeys("KadalLiar99!");
        ae.Cpassword().sendKeys("KadalLiar99!");
        Select status = new Select(ae.SelectStatus());
        status.selectByIndex(0);

        ae.BtnSave().click();
        Thread.sleep(5000);

        Assert.assertTrue(ae.VaddSuccess().isDisplayed());

        extent.flush();
    }

    @Test (priority=19)
    public void Test19() throws Throwable {
//        extent.createTest("TC0023 Add Employee with selecting status disable");

        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
        Login lg = new Login(driver);
        lg.LoginSuccess();

        Thread.sleep(2000);
        AddEmployee ae = new AddEmployee(driver);
        ae.OpenAddEmployee();

        ae.ValidDataCreateLogin();
        Thread.sleep(2000);

        ae.ChckLogin().click();

        ae.UserName().sendKeys("Roaaro12saaaopra21");
        ae.Password().sendKeys("KadalLiar99!");
        ae.Cpassword().sendKeys("KadalLiar99!");
        Select status = new Select(ae.SelectStatus());
        status.selectByIndex(1);

        ae.BtnSave().click();
        Thread.sleep(5000);

        Assert.assertTrue(ae.VaddSuccess().isDisplayed());

        extent.flush();
    }


    @AfterTest
    public void quit() throws Throwable{
        driver.quit();
    }

}
