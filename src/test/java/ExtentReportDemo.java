//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import org.junit.Before;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import pageadmin.AddEmployee;
//import pageadmin.Login;
//
//public class ExtentReportDemo {
//    ExtentReports extent;
//    WebDriver driver;
//
//    @BeforeTest
//    public void config(){
//        String path = System.getProperty("user.dir")+"\\reports\\index.html";
//        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//        reporter.config().setReportName("Project Result");
//        reporter.config().setDocumentTitle("Test Result");
//
//        extent = new ExtentReports();
//        extent.attachReporter(reporter);
//        extent.setSystemInfo("Tester", "Deva");
//    }
//
//
//
//
//    @Test
//    public void initialDemo(){
//        extent.createTest("Initial Demo");
//        System.setProperty("webdriver.chrome.driver", "E:/QA/Chrome Driver/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://home.amikom.ac.id/");
//        System.out.println(driver.getTitle());
//        extent.flush();
//    }
//
//    @Test
//    public void Test6() throws Throwable {
//        ExtentTest test = extent.createTest("Add Employee with registred employee id");
//
//        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
//        Login lg = new Login(driver);
//        lg.LoginSuccess();
//
//        AddEmployee ae = new AddEmployee(driver);
//        ae.OpenAddEmployee();
//
//        ae.FirstName().sendKeys("Banteng");
//        ae.MidleName().sendKeys("Ini");
//        ae.Lastname().sendKeys("Galak");
//        ae.EmployeeId().clear();
//        ae.Upload().sendKeys("E:\\QA\\Big Project\\Foto/selenium.jpg");
//
//        ae.BtnSave().click();
//
//
//        Assert.assertEquals("Employee ID has been registred", ae.VemptyLN().getText());
//
//        test.fail("Fail");
//
//        extent.flush();
//    }
//
//}
//
//
