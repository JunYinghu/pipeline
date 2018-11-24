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


        Assert.assertTrue(driver.getTitle().contains("Software Development"));
    }

    @Test
    public void testcase2(){
        System.out.println("i am here");
        Reporter.log("调用test2方法");
    }

    @Test
    public void testcase3(){

        System.out.println("i am here");

    }

    @Test
    public void testcase4(){

        System.out.println("i am here");
        Reporter.log("调用test2方法");
    }
}
