package payload;

import org.json.JSONObject;

public class FieldsSetup {

    private String version;
    private String externalLinkId;
    private String title;
    private JSONObject custom;
    private String testStatus;
    private String feature;
    private String projectId;
    private String priority;
    private String reportTo;
    private String category;
    private String type;
    private String browser;
    private String condition;
    private String platform;
    private String remarks;
    private String desc;
    private String env;
    private String method;
    private String testData;
    private String device;
    private String verifyResult;
    private String planFD;
    private String severity;
    private String fixVersion;
    private String module;
    private String runCaseId;
    private String duration;
    private String userImpact;
    private String fixCategory;
    private String rootcauseCategory;
    private String rootCause;
    private String frequency;
    private String issueSource;

    public void version(String version) {
        this.version = version;
    }

    public void externalLinkId(String externalLinkId) {
        this.externalLinkId = externalLinkId;
    }

    public void runCaseId(String runCaseId) {
        this.runCaseId = runCaseId;
    }
    public void title(String title) {
        this.title = title;
    }

    public void feature(String feature) {
        this.feature = feature;
    }

    public void testStatus(String testStatus) {
        this.testStatus = testStatus;
    }

    public void projectId(String projectId) {
        this.projectId = projectId;
    }

    public void description(String desc) {
        this.desc = desc;
    }

    public void caseCategory(String category) {
        this.category = category;
    }

    public void priority(String priority) {
        this.priority = priority;
    }

    public void reportTo(String reportTo) {
        this.reportTo = reportTo;
    }

    public void testData(String testData) {
        this.testData = testData;
    }

    public void testMethod(String method) {
        this.method = method;
    }

    public void testModule(String module) {
        this.module = module;
    }
    public void env(String env) {
        this.env = env;
    }

    public void testType(String type) {
        this.type = type;
    }

    public void testDevice(String device) {
        this.device = device;
    }

    public void platform(String platform) {
        this.platform = platform;
    }

    public void browser(String browser) {
        this.browser = browser;
    }

    public void testCondition(String condition) {
        this.condition = condition;
    }

    public void remarks(String remarks) {
        this.remarks = remarks;
    }

    public void customFieldDatas(JSONObject custom) {
        this.custom = custom;
    }


    public void verifiedResult(String verifyResult) {
        this.verifyResult = verifyResult;
    }

    public void severity(String severity) {
        this.severity = severity;
    }

    public void fixVersion(String fixVersion) {
        this.fixVersion = fixVersion;
    }

    public void planFixDate(String planFD) {
        this.planFD = planFD;
    }

    public void userImpact(String userImpact) {
        this.userImpact = userImpact;
    }
    public void fixCategory(String fixCategory) {
        this.fixCategory = fixCategory;
    }
    public void rootcauseCategory(String rootcauseCategory) {
        this.rootcauseCategory = rootcauseCategory;
    }
    public void rootCause(String rootCause) {
        this.rootCause = rootCause;
    }
    public void frequency(String frequency) {
        this.frequency = frequency;
    }
    public void issueSource(String issueSource) {
        this.issueSource = issueSource;
    }
    public void duration(String duration) {
        this.duration = duration;
    }

    public String version() {
        return this.version;
    }

    public String title() {
        return this.title;
    }

    public String feature() {
        return this.feature;
    }

    public String testStatus() {
        return this.testStatus;
    }

    public String projectId() {
        return this.projectId;
    }

    public String description() {
        return this.desc;
    }

    public String caseCategory() {
        return this.category;
    }

    public String priority() {
        return this.priority;
    }

    public String reportTo() {
        return this.reportTo;
    }

    public String testData() {
        return this.testData;
    }

    public String testMethod() {
        return this.method;
    }

    public String testModule() {
        return this.module;
    }

    public String env() {
        return this.env;
    }

    public String testType() {
        return this.type;
    }

    public String testDevice() {
        return this.device;
    }

    public String platform() {
        return this.platform;
    }


    public String browser() {
        return this.browser;
    }

    public String testCondition() {
        return this.condition;
    }

    public String remarks() {
        return this.remarks;
    }

    public String externalLinkId() {
        return this.externalLinkId;
    }

    public JSONObject customFieldDatas() {
        return this.custom;
    }

    public String verifiedResult() {
        return this.verifyResult;
    }


    public String planFixDate() {
        return this.planFD;
    }


    public String severity() {
        return this.severity;
    }

    public String fixVersion() {
        return this.fixVersion;
    }

    public String runCaseId() {
        return this.runCaseId;
    }

    public String duration() {
        return this.duration;
    }
    public String userImpact() {
        return this.userImpact;
    }
    public String fixCategory() {
        return this.fixCategory;
    }
    public String rootcauseCategory() {
        return this.rootcauseCategory;
    }
    public String rootCause() {
        return this.rootCause;
    }
    public String frequency() {
        return this.frequency;
    }
    public String issueSource() {
        return this.issueSource;
    }
}
