package pageadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Report {
    WebDriver driver;

    public Report(WebDriver ldriver) {

        this.driver = ldriver;
//        PageFactory.initElements(driver, this);
    }

    By linkReport = By.id("menu_core_viewDefinedPredefinedReports");
    By pim = By.id("menu_pim_viewPimModule");

    By searchreport = By.className("ac_input");
    By btnSearch = By.className("searchBtn");
    By btnReset = By.xpath("//*[@id=\"searchForm\"]/fieldset/p/input[2]");
    By btnAdd = By.id("btnAdd");
    By btnDelete = By.id("btnDelete");

    By reportname = By.id("report_report_name");
    By selectcriteria = By.id("report_criteria_list");
    By addcriteria = By.id("btnAddConstraint");
    By employeename = By.id("employee_name_empName");
    By paygrade = By.id("report_pay_grade");
    By education = By.id("report_education");
    By employmentstatus = By.id("report_employment_status");
    By serviceperiod = By.id("service_period_comparision");
    By joineddate = By.id("joined_date_comparision");
    By jobtitle = By.id("report_job_title");
    By language = By.id("report_language");
    By skill = By.id("report_skill");
    By agegroup = By.id("age_group_comparision");
    By subunit = By.id("report_sub_unit");
    By gender = By.id("report_gender");
    By location = By.id("location");

    
    By selectdisplayfieldgroup = By.id("report_display_groups");
    By adddisplayfieldgroup = By.id("btnAddDisplayGroup");
    By selectdisplayfield = By.id("report_display_field_list");
    By adddisplayfield = By.id("btnAddDisplayField");
    By btnsave = By.id("btnSave");





//    By selectiondeiplayfieldgroup = By.xpath("//*[@id=\"display_groups\"]/li[2]/label");
//    By selectiondeiplayfieldlist = By.xpath("<label for=\"report_display_field_9\">Employee Id</label>");


    By vSearchNotFound = By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td");
    By vSearchFound = By.className("left");
    By vDefinereport = By.xpath("//*[@id=\"content\"]/div/div[1]/h1");
    By vEmptyreportname = By.xpath("//span[contains(text(),'Required')]");

    public WebElement VemptyReportName(){
        return driver.findElement(vEmptyreportname);
    }


    public WebElement SearchReport(){
        return driver.findElement(searchreport);
    }

    public WebElement BtnSearch(){
        return driver.findElement(btnSearch);
    }

    public WebElement BtnReset(){
        return driver.findElement(btnReset);
    }

    public WebElement BtnAdd(){
        return driver.findElement(btnAdd);
    }

    public WebElement BtnDelete(){
        return driver.findElement(btnDelete);
    }

    public WebElement ReportName(){
        return driver.findElement(reportname);
    }
    public WebElement SelectCriteria(){
        return driver.findElement(selectcriteria);
    }
    public WebElement AddCriteria(){
        return driver.findElement(addcriteria);
    }
    public WebElement EmployeeName(){
        return driver.findElement(employeename);
    }
    public WebElement Paygrade(){
        return driver.findElement(paygrade);
    }
    public WebElement Education(){
        return driver.findElement(education);
    }
    public WebElement EmployementStatus(){
        return driver.findElement(employmentstatus);
    }
    public WebElement ServicePeriod(){
        return driver.findElement(serviceperiod);
    }
    public WebElement JoinedDate(){
        return driver.findElement(joineddate);
    }
    public WebElement JobTitle(){
        return driver.findElement(jobtitle);
    }
    public WebElement Language(){
        return driver.findElement(language);
    }
    public WebElement Skill(){
        return driver.findElement(skill);
    }
    public WebElement AgeGroup(){
        return driver.findElement(agegroup);
    }
    public WebElement Subunit(){
        return driver.findElement(subunit);
    }
    public WebElement Gender(){
        return driver.findElement(gender);
    }
    public WebElement Location(){
        return driver.findElement(location);
    }
    public WebElement SelectDisplayFieldGroup(){
        return driver.findElement(selectdisplayfieldgroup);
    }
    public WebElement AddDisplayFieldGroup(){
        return driver.findElement(adddisplayfieldgroup);
    }
    public WebElement SelectDisplayField(){
        return driver.findElement(selectdisplayfield);
    }
    public WebElement AddDisplayField(){
        return driver.findElement(adddisplayfield);
    }
    public WebElement VsearchNotFound(){
        return driver.findElement(vSearchNotFound);
    }
    public WebElement VsearchFound(){
        return driver.findElement(vSearchFound);
    }
    public WebElement VdefineReport(){
        return driver.findElement(vDefinereport);
    }
    public WebElement BtnSave(){
        return driver.findElement(btnsave);
    }

    public void OpenReport(){
        WebElement PIM = driver.findElement(pim);
        Actions action = new Actions(driver);
        action.moveToElement(PIM).perform();
        driver.findElement(linkReport).click();
    }


}
