package test.cicd.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class runTest {

    private WebDriver driver;

    @BeforeTest
    public void setupTest (){
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        driver = new ChromeDriver();
        //Create a new ChromeDriver
        //Go to www.swtestacademy.com
        driver.navigate().to("http://www.google.com");
    }

    @Test
    public void testcase1(){
        Assert.assertFalse(driver.getTitle().contains("Software sevelopment"));

    }

    @Test
    public void testcase2(){
        System.out.println("i am here2");
        Reporter.log("iternv0oid0");
    }

    @Test
    public void testcase3(){

        System.out.println("i am here3");

    }

    @Test
    public void testcase4(){

        System.out.println("i am here4");
        Reporter.log("invode");
    }
}
