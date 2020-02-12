package test.cicd.project;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
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

    SoftAssert softAssertion = new SoftAssert();
    String expectedTitle = "Google";
    String expectedUrl = "https://www.google.com";
    private WebDriver driver;
    private SetGetParameter setGetParameter;

    @BeforeTest
    @Parameters({"runEnv", "buildUrl", "testUrl"})
    public void setParameter(@Optional("testingstring") String runEnv, @Optional("testingBuildUrl") String buildUrl, @Optional("http://www.google.com") String testUrl) throws Exception {
        setGetParameter = new SetGetParameter();

        setGetParameter.setBuildNo(buildUrl);
        setGetParameter.setENV(runEnv);
        System.out.println("here is run"+runEnv);
        setGetParameter.setBrowser(testUrl);


    }

    private String decryptBase64(String key) throws Exception {
        byte result[] = (new BASE64Decoder()).decodeBuffer(key);
        return new String(result);
    }

    @AfterTest
    public void createpropFile() {
        CreateEnvFile createprop = new CreateEnvFile();
        createprop.createFile(setGetParameter.getEnv(), setGetParameter.getBuildNo(), setGetParameter.getBrowser());
        driver.quit();

    }

    @BeforeTest
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("here is opened link" + setGetParameter.getBrowser());
        driver.navigate().to(setGetParameter.getBrowser());
    }

    @Step
    public void setOpenedPage() {
        setGetParameter.setCurrentPageTitle(driver.getTitle());
    }

    @Step
    public String getOpenedPage() {
        return setGetParameter.getCurrentPageTitle();
    }

    @Step
    public void verifiedPage() {
        setOpenedPage();
        softAssertion.assertEquals(getOpenedPage(),expectedTitle);
        softAssertion.assertFalse(false);
        softAssertion.assertAll();
        /*if (!getOpenedPage().contains(expectedTitle)) {
            softAssertion.fail("KeyWords Google is not not found");
            System.out.println("i am here to print:"+getOpenedPage());

        }
*/
    }

    @Test(priority = 0, description = "Title verification")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This cases run on Windows / MAC / Linux")
    @Story("To verify Url Title")
    public void titleVerification() {
        verifiedPage();
    }


    @Test(groups = {"windows"}, priority = 1, description = "testLink")
    @Severity(SeverityLevel.BLOCKER)
    @Description("To test link")
    @Link(name = "wikipage", type = "mylink")
    @Link(name = "extrnalPage", type = "link")
    @Issue("jira-002")
    @TmsLink("test-1")
    public void testParam() throws Exception {
        //System.out.println(decryptBase64(setGetParameter.getLoginPassword()));
        //System.out.println(setGetParameter.getLoginUser());

            System.out.println("this case to test links");

    }

    @Test(priority = 1, description = "TestFlakyCase")
    @Severity(SeverityLevel.CRITICAL)
    @Description("The case to view Flack")
    @Story("here is test flaky")
    @Flaky
    public void testFlaky() {
        if (!driver.getCurrentUrl().contains(expectedUrl)) {
            //softAssertion.fail("Url Not with google");
            softAssertion.fail("It is not expected Url");
            softAssertion.assertAll();
        }
    }

    @Test(description = "CSV Attachment")
    public void csvAttachmentTest() throws Exception {
        int i = 0;
        while (i < 2) {
            saveCsvAttachment();
            i++;
        }
    }

    @Attachment(value = "Sample csv attachment", type = "text/csv")
    private byte[] saveCsvAttachment() throws URISyntaxException, IOException {
        return getSampleFile("sample.csv");
    }

    @Step
    private byte[] getSampleFile(String fileName) throws IOException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(fileName);
        if (resource == null) {
            fail(format("Couldn't find resource '%s'", fileName));
        }
        return Files.readAllBytes(Paths.get(resource.toURI()));
    }

}

