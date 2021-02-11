//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import pageadmin.Login;
//import pageadmin.Report;
//
//public class TS_01_Login {
//
//    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "E:/QA/Chrome Driver/chromedriver.exe");
//        WebDriver driver;
//        driver = new ChromeDriver();
//
//        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
//        Login lg = new Login(driver);
//        lg.LoginSuccess();
//
//        Report rp = new Report(driver);
//        rp.OpenReport();
//
//        driver.findElement(By.className("ac_input")).sendKeys("alalal");
//
//        Assert.assertEquals(driver.findElement(By.id("//*[@id=\"resultTable\"]/tbody/tr/td")), "No Records Found");
//
//    }
//
////        ExtentReports extent;
////
////    @BeforeTest
////    public void config(){
////        String path = System.getProperty("user.dir")+"\\reports\\admin\\login.html";
////        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
////        reporter.config().setReportName("Project Result");
////        reporter.config().setDocumentTitle("Test Result");
////
////        extent = new ExtentReports();
////        extent.attachReporter(reporter);
////        extent.setSystemInfo("Tester", "Deva");
////    }
////
////    @Test
////    public void emptyUsername() throws Throwable {
////        extent.createTest("Login with empty username");
////
////        System.setProperty("webdriver.chrome.driver", "E:/QA/Chrome Driver/chromedriver.exe");
////        WebDriver driver = new ChromeDriver();
////        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
////
////        Login lg = new Login(driver);
////        lg.Passwordd().sendKeys("coba");
////        lg.BtnLogind().click();
////        Assert.assertEquals("Username cannot be empty", lg.vUsernameEmpty().getText());
////
////        extent.flush();
////    }
////
////    @Test
////    public void emptyPassword() throws Throwable {
////        extent.createTest("Login with empty password");
////
////        System.setProperty("webdriver.chrome.driver", "E:/QA/Chrome Driver/chromedriver.exe");
////        WebDriver driver = new ChromeDriver();
////        driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
////
////        Login lg = new Login(driver);
////        lg.Usernamed().sendKeys("Admin");
////        lg.BtnLogind().click();
////
////        extent.flush();
////
////    }
//
//}
