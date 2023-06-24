package Selenium.Tests;

import Selenium.ExtentReports.reports;
import Selenium.Pages.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class TestFrontEnd {
    WebDriver driver;
    PageRegister pageRegister;
    PageNewAccount pageNewAccount;
    PageAccountOverview pageAccountOverview;
    PageTransferFunds pageTransferFunds;
    PageAccountActivity pageAccountActivity;

    PageLogin pageLogin;
    ExtentReports extent;
    ExtentTest test;

    @BeforeEach
    public void setUp (){
        pageRegister = new PageRegister();
        driver = pageRegister.chromeDriverConnection();
        pageRegister.link("https://parabank.parasoft.com/parabank/register.htm");
        extent = reports.getInstance();
    }

    @AfterEach
    public void tearDown (){
        extent.endTest(test);
        extent.flush();
        driver.quit();
    }

    @Before
    public void login() throws InterruptedException {
        pageLogin = new PageLogin();
        pageLogin.login();
    }

    @Test
    public void registerUser () throws InterruptedException {
        test = extent.startTest(" register success");
        test.log(LogStatus.INFO, "starting test");
        pageRegister.register();
        test.log(LogStatus.PASS, "succes test");
    }



    @Test
    public void newAccount () throws InterruptedException {
        login();
        Thread.sleep(1000);
        pageNewAccount = new PageNewAccount();
        test = extent.startTest(" Create New Account success");
        test.log(LogStatus.INFO, "starting test");
        pageNewAccount.createAccount();
        test.log(LogStatus.PASS, "succes test");
        Thread.sleep(1000);
    }


    @Test
    @Tag("TestRegresion")
    public void view () throws InterruptedException{
        login();
        Thread.sleep(1000);
        pageAccountOverview= new PageAccountOverview();
        test = extent.startTest(" AccountOverview success");
        test.log(LogStatus.INFO, "starting test");
        pageAccountOverview.viewAccount();
        test.log(LogStatus.PASS, "succes test");
    }

    @Test
    @Tag("TestRegresion")
    public void transfer () throws InterruptedException{
        login();
        Thread.sleep(1000);
        pageTransferFunds = new PageTransferFunds();
        test = extent.startTest("Transfer Funds success");
        test.log(LogStatus.INFO, "starting test");
        pageTransferFunds.transferFunds();
        test.log(LogStatus.PASS, "succes test");
    }

    @Test
    @Tag("TestRegresion")
    public void activity () throws InterruptedException{
        login();
        Thread.sleep(1000);
        pageAccountActivity = new PageAccountActivity();
        test = extent.startTest(" Account Activity success");
        test.log(LogStatus.INFO, "starting test");
        pageAccountActivity.accountMovements();
        test.log(LogStatus.PASS, "succes test");
    }



}
