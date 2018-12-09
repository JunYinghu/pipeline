package test.cicd.project;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import sun.misc.BASE64Decoder;
import test.cicd.project.Utili.SetGetParameter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.String.format;
import static org.testng.Assert.fail;

@Epic("Regression Tests")
@Feature("SDKPackage Testing")
public class runTest {

    private WebDriver driver;
    private SetGetParameter setGetParameter;

    @BeforeTest
    @Parameters({"testString"})
    public void setParameter(@Optional("testingstring") String testString) throws Exception {
        setGetParameter = new SetGetParameter();
        setGetParameter.setLoginUser("svp_p_sdkuser");
        setGetParameter.setLoginPassword("OEI0Vll6emM=");
        System.out.println(decryptBase64(setGetParameter.getLoginPassword()));
        System.out.println(setGetParameter.getLoginUser());
    }

    public String decryptBase64(String key) throws Exception{
        byte result[] = (new BASE64Decoder()).decodeBuffer(key);
        return new String(result);
    }
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
        VerifiedPackage verifiedPadk = new VerifiedPackage();
        verifiedPadk.createFoder();

        Assert.assertTrue(driver.getTitle().contains("Software sevelopment"));

    }

    @Test(priority = 1,description = "testcaseparam")
    @Severity(SeverityLevel.NORMAL)
    @Description("The case to scan the whole folder from aritifitaor")

    public void testcaseparam() throws Exception {
        System.out.println(decryptBase64(setGetParameter.getLoginPassword()));
        System.out.println(setGetParameter.getLoginUser());


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

