package test.cicd.project;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import sun.misc.BASE64Decoder;
import test.cicd.project.Utili.CreateEnvFile;
import test.cicd.project.Utili.SetGetParameter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.String.format;
import static org.testng.Assert.fail;



@Epic("SIT Tests")
@Feature("Testing Practice")
public class runTest {



    private WebDriver driver;
    private SetGetParameter setGetParameter;
    SoftAssert softAssertion = new SoftAssert();
    @BeforeTest
    @Parameters({"runEnv", "buildUrl", "testUrl"})
    public void setParameter(@Optional("testingstring") String runEnv, @Optional("testingBuildUrl") String buildUrl, @Optional("http://www.baidu.com") String testUrl) throws Exception {
        setGetParameter = new SetGetParameter();
        setGetParameter.setLoginUser("svp_p_sdkuser");
        setGetParameter.setLoginPassword("OEI0Vll6emM=");
        setGetParameter.setBuildNo(buildUrl);
        setGetParameter.setENV(runEnv);
        setGetParameter.setBrowser(testUrl);

        System.out.println(decryptBase64(setGetParameter.getLoginPassword()));
        System.out.println(setGetParameter.getLoginUser());
    }

    public String decryptBase64(String key) throws Exception {
        byte result[] = (new BASE64Decoder()).decodeBuffer(key);
        return new String(result);
    }

    @AfterTest
    public void createpropFile() {
        CreateEnvFile createprop = new CreateEnvFile();
        createprop.createFile(setGetParameter.getEnv(), setGetParameter.getBuildNo(), setGetParameter.getBrowser());
    }

    @BeforeTest
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        driver = new ChromeDriver();
        //Create a new ChromeDriver
        //Go to www.swtestacademy.com
        System.out.println("here is opened link"+setGetParameter.getBrowser());
        driver.navigate().to(setGetParameter.getBrowser());
    }

    @Test(priority = 0, description = "Title verification")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This cases run on Windows / MAC / Linux")
    @Story("To verify Url Title")
    @Link("http://www.baidu.com")
    @Issue("123")
    @TmsLink("test-1")
    @Flaky
    public void titleVerification() {

        VerifiedPackage verifiedPadk = new VerifiedPackage();
       // verifiedPadk.createFoder();
        if (!driver.getTitle().contains("Google")) {
            softAssertion.fail("Testing not in google");
            softAssertion.assertAll();
        }
        //Assert.assertTrue(driver.getTitle().contains("Software sevelopment"));
    }


    @Test(priority = 1, description = "testParameter")
    @Severity(SeverityLevel.BLOCKER)
    @Description("To test Parameter")
    @Link("http://www.google.com")
    @Link(name = "allure",type = "mylink")
    @Issue("123")
    @TmsLink("test-1")
    public void testParam() throws Exception {
        System.out.println(decryptBase64(setGetParameter.getLoginPassword()));
        System.out.println(setGetParameter.getLoginUser());
    }

    @Test(priority = 1,description = "TestFlakyCase")
    @Severity(SeverityLevel.NORMAL)
    @Description("The case to view Flack")
    @Story("here is test flaky")
    @Flaky
    public void testFlaky() {
        String searchkeyword ="google";
        if (!driver.getCurrentUrl().contains(searchkeyword)){
            softAssertion.fail("Url Not with google");
            softAssertion.assertAll();
        };
    }

    @Test(description = "CSV Attachment")
    public void csvAttachmentTest() throws Exception {
        int i = 0;
        while (i < 5) {
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

