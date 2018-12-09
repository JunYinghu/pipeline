package test.cicd.project;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.String.format;
import static org.testng.Assert.fail;

//@Listeners({AllureListerner.class})
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

    @Test(priority = 1,description = "testcaseparam")
    @Severity(SeverityLevel.NORMAL)
    @Description("The case to scan the whole folder from aritifitaor")
    @Parameters({"createdataName","testString"})
    public void testcaseparam(@Optional("hujun") String createdataName, @Optional("testingstring") String testString) {
        System.out.println(createdataName);
        System.out.println(testString);
        System.out.println("i am here2");
        //  Reporter.log("iternv0oid0");
    }

   // @Test(priority = 1,description = "Binscope scan")
    @Severity(SeverityLevel.NORMAL)
    @Description("The case to scan file one by one")
    public void testcaseprint() {
        System.out.println("i am here3");
    }

    @Test(description = "CSV Attachment")
    public void csvAttachmentTest() throws Exception {
        int i=0;
        while (i<5) {
            saveCsvAttachment();
        i++;
        }
    }



    @Attachment(value = "Sample csv attachment", type = "text/html")
    public byte[] saveCsvAttachment() throws URISyntaxException, IOException {
        return getSampleFile("index.html");
    }


    private byte[] getSampleFile(String fileName) throws IOException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(fileName);
        if (resource == null) {
            fail(format("Couldn't find resource '%s'", fileName));
        }
        return Files.readAllBytes(Paths.get(resource.toURI()));
    }

}
