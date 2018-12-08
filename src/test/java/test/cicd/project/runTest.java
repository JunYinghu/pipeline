package test.cicd.project;

import io.qameta.allure.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


@Epic("Regression Tests")
@Feature("SDKPackage Testing")
public class runTest {

    private WebDriver driver;

    @BeforeTest
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        driver = new ChromeDriver();
        //Create a new ChromeDriver
        //Go to www.swtestacademy.com
        driver.navigate().to("http://www.google.com");
    }

    //@Test(priority = 0, description = "SDKpackage verification")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This cases run on Windows / MAC / Linux")
    @Story("To verify SDKpackage")
    public void testcase1() {
        verifiedSDKPackage verifiedPadk = new verifiedSDKPackage();
        verifiedPadk.createFoder();

        Assert.assertTrue(driver.getTitle().contains("Software sevelopment"));

    }

    @Test(priority = 1,description = "testcase2")
    @Severity(SeverityLevel.NORMAL)
    @Description("The case to scan the whole folder from aritifitaor")
    public void testcase2() {
        System.out.println("i am here2");
        //  Reporter.log("iternv0oid0");
    }

   // @Test(priority = 1,description = "Binscope scan")
    @Severity(SeverityLevel.NORMAL)
    @Description("The case to scan file one by one")
    public void testcase3() {
        System.out.println("i am here3");
    }

    @Test
    @Attachment(value = "HTML attachment",type = "text/html")
    public byte[] appendLogAllure (File file) {
        try{

           return FileUtils.readFileToByteArray(file);
        }
        catch (IOException ignored){

        }
        return null;
        //  Reporter.log("invode");
    }
}
