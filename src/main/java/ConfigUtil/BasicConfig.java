package ConfigUtil;

import com.priortest.config.PTApiConfig;
import com.priortest.config.PTConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;


import java.lang.reflect.Method;

public class BasicConfig {
    private static final Logger log = LogManager.getLogger(BasicConfig.class);

    @Parameters({"testCycle", "enablePTApi", "signOff", "Env", "version", "release", "currentRelease"})
    @BeforeSuite
    public void basicConfigParameter(@Optional("调试 API count") String testCycle, @Optional("true") boolean enablePTApi, @Optional("true") boolean signOff, @Optional("开发") String Env, @Optional("1.0.0.0") String version, @Optional("1") int release, @Optional("1") int currentRelease) {
        log.info("+++++ Setup CICD setting :" + enablePTApi + "  " + testCycle + " " + version + "  " + Env);
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

        PTApiConfig pTApiConfig = new PTApiConfig();
        PTApiConfig.setConnectPTAPI(enablePTApi);
        PTApiConfig.setTestCycleTitle(testCycle);
        PTApiConfig.setPriorTestRelease(release);
        PTApiConfig.setPriorTestCurrentRelease(currentRelease);

        PriorTestConfig.setPriorTestApi();
        PriorTestConfig.setPriorTestProjectId();
        PriorTestConfig.setPriorTestToken();
        PriorTestConfig.setPriorTestEmail();
        PriorTestConfig.setEnv(Env);
        PriorTestConfig.setIssueCreation(true);
        PriorTestConfig.setPlatform(System.getProperty("os.name"));
        PriorTestConfig.setVersion(version);
        PriorTestConfig.setPriorTestSignOff(signOff);

        PTApiConfig.setIssueIdentifier(generateDeviceInfo());

        log.info("+++ End Setup CICD ++++ ");
    }

    private String generateDeviceInfo() {
        // Example implementation: retrieve device or OS from test result attributes or system properties
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        String osArch = System.getProperty("os.arch");
        String version = PTConstant.getPTVersion();
        String issueIdentifier =version+"_"+(osName != null ? osName : "UnknownDevice") + "_" + (osVersion != null ? osVersion : "UnknownOSVersion") + "_" + (osArch != null ? osArch : "UnKnowsOSarch");
        return issueIdentifier;
        //PTApiConfig.setIssueIdentifier(issueIdentifier);
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
