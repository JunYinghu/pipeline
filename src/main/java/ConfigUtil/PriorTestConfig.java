package ConfigUtil;

import com.priortest.config.PTConstant;

public class PriorTestConfig {

    public static void setPriorTestApi() {
        PTConstant.setPTBasedURI("http://43.139.159.146:8082/api/apiAdpater/");
    }
    public static void setPriorTestProjectId() {
        PTConstant.setPTProjectId("593988941040848898");
    }

    public static void setPriorTestToken() {
        PTConstant.setPTToken("dgwoekm04xyljrhpvdutmj681pmqzdodn5b2uy6r787llo2gpc");
    }

    public static void setPriorTestEmail() {
        PTConstant.setPTEmail("qatest.hu.mary3@gmail.com");
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
