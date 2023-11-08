package Config;

import com.priortest.config.PTApiConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BasicConfig {
    private static final Logger log = LogManager.getLogger(BasicConfig.class);

    @Parameters({"testCycle", "enablePriorTestApi", "signOff"})
    @BeforeSuite
    public void basicConfigParameter(@Optional("win10_dev_2.0.0") String testCycle, @Optional("true") boolean enablePriorTestApi, @Optional("true") boolean signOff) {

        log.info("setup CICD :" + enablePriorTestApi);

        // enablePriorTestApi : true - will trigger PT API
                                // false - will not trigger PT API
        // TestCycleTitle > to create test cycle with the passed title
              // if test cycle is null , will proceed with a default test cycle version_platform_env
              // if test cycle title is not null, will proceed with the test cycle title
              // if test cycle title exist, will not re-create
              // if test cycle title does not exist , will create

        // setPriorTestApi -- PT Base API
        // setPriorTestProjectId -- PT Project Id
        // setPriorTestToken -- Request API token
        // setPriorTestEmail -- Request API email
        // setPriorTestSignOff -- true : will generated sign off report, otherwise no
        // setIssueCreation - true: will create an issue if tc is fail, otherwise no
        // setEnv - string: for sign off / create test cycle usage
        // setVersion - string: for sign off / create test cycle usage
        // setPlatform - String for sign off / create test cycle usage, if not pass, PT detect the platform test case running on

        // setup priorTest API
        if (enablePriorTestApi) {
            PTApiConfig pTApiConfig = new PTApiConfig();

            pTApiConfig.setConnectPTAPI(enablePriorTestApi);
            pTApiConfig.setTestCycleTitle(testCycle);

            PriorTestConfig.setPriorTestApi();
            PriorTestConfig.setPriorTestProjectId();
            PriorTestConfig.setPriorTestToken();
            PriorTestConfig.setPriorTestEmail();
            PriorTestConfig.setIssueCreation(true);

            PriorTestConfig.setEnv("开发环境");
            PriorTestConfig.setPlatform("null");
            PriorTestConfig.setVersion("2.0.0.0");

            PriorTestConfig.setPriorTestSignOff(signOff);


            log.info("End Setup CICD");
        }

    }

    @AfterMethod
    public void afterTest(Method method) {
        log.info("End TC " + getClass().getSimpleName() + "." + method.getName());
    }

    @BeforeMethod
    public void beforeTest(Method method) {
        log.info("Start TC " + getClass().getSimpleName() + "." + method.getName());
    }
}
