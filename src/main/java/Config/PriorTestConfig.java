package Config;

import com.priortest.config.PTConstant;

public class PriorTestConfig {

    public static void setPriorTestApi() {
        PTConstant.setPTBasedURI("http://43.139.159.146:8082/api");
    }

    public static void setPriorTestProjectId() {
        PTConstant.setPTProjectId("593988941040848898");
    }

    public static void setPriorTestToken() {
        PTConstant.setPTToken("9999999");
    }

    public static void setPriorTestEmail() {
        PTConstant.setPTEmail("9999999");
    }

    public static void setPriorTestSignOff(boolean signOff) {
        PTConstant.setPTSignOff(signOff);
    }

    public static void setIssueCreation(boolean issueCreation) {
        PTConstant.setPTIssueCreation(issueCreation);
    }

    public static void setEnv(String env) {
        PTConstant.setPTEnv(env);
    }

    public static void setPlatform(String platform) {
        PTConstant.setPTPlatform(platform);
    }

    public static void setVersion(String version) {
        PTConstant.setPTVersion(version);
    }

}
