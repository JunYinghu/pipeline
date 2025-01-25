package payload;

import com.priortest.config.PTApiConfig;
import com.priortest.config.PTApiFieldSetup;
import com.priortest.config.PTApiPayloadConfig;
import com.priortest.config.PTConstant;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PayloadUtility {


    FieldsSetup FieldSetup = new FieldsSetup();

    public JSONObject customFiledData(Map<String, String> custom) {
        JSONObject customFieldDatas = new JSONObject();
        for (Map.Entry<String, String> entry : custom.entrySet()) {
            try {
                customFieldDatas.put(entry.getKey(), entry.getValue());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return customFieldDatas;
    }

    public void tcPayload(String externalId) {
        FieldSetup.externalLinkId(externalId);
        FieldSetup.title(PTApiFieldSetup.getTitle());
        FieldSetup.feature(PTApiFieldSetup.getFeature());
        FieldSetup.testModule(PTApiFieldSetup.getModule());
        FieldSetup.testStatus("已评审");
        FieldSetup.projectId(PTConstant.getPTProjectId());
        FieldSetup.description("THIS IS payload from AUTOMATION test case given via test case");
        FieldSetup.version(PTConstant.getPTVersion());
        FieldSetup.caseCategory(PTApiFieldSetup.getCategory());
        FieldSetup.priority(PTApiFieldSetup.getPriority());
        FieldSetup.severity(PTApiFieldSetup.getSeverity());
        FieldSetup.reportTo("huju");
        FieldSetup.testData("tet data");
        FieldSetup.testMethod("自动");
        FieldSetup.env(PTConstant.getPTEnv());
        FieldSetup.testType("正向");
        FieldSetup.testDevice(PTConstant.getPTPlatform());
        FieldSetup.platform(PTConstant.getPTPlatform());
        FieldSetup.browser("Chrome");
        FieldSetup.testCondition("");
        FieldSetup.remarks("testing only");
        Map<String, String> custom = new HashMap<>();
        FieldSetup.customFieldDatas(customFiledData(custom));
        PTApiPayloadConfig.setTestCasePayload(testCaseCreationPayload());
        System.out.println("+++++++++++++ this print from test case: " + PTApiPayloadConfig.getTestCasePayload());
    }

    public String testCaseCreationPayload() {
        JSONObject createTc = new JSONObject();
        try {
            createTc.put("externalLinkId", FieldSetup.externalLinkId());
            createTc.put("title", FieldSetup.title());
            createTc.put("feature", FieldSetup.feature());
            createTc.put("module", FieldSetup.testModule());
            createTc.put("testStatus", FieldSetup.testStatus());
            createTc.put("projectId", FieldSetup.projectId());
            createTc.put("description", FieldSetup.description());
            createTc.put("version", FieldSetup.version());
            createTc.put("caseCategory", FieldSetup.caseCategory());
            createTc.put("priority", FieldSetup.priority());
            createTc.put("reportTo", FieldSetup.reportTo());
            createTc.put("testData", FieldSetup.testData());
            createTc.put("testMethod", FieldSetup.testMethod());
            createTc.put("env", FieldSetup.env());
            createTc.put("testType", FieldSetup.testType());
            createTc.put("device", FieldSetup.testDevice());
            createTc.put("platform", FieldSetup.platform());
            createTc.put("browser", FieldSetup.browser());
            createTc.put("testCondition", FieldSetup.testCondition());
            createTc.put("remarks", FieldSetup.remarks());
            createTc.put("customFieldDatas", FieldSetup.customFieldDatas());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return createTc.toString();
    }


    public JSONObject issueCreationPayload() {
        JSONObject createIssue = new JSONObject();
        try {
            createIssue.put("runcaseId", FieldSetup.runCaseId());
            createIssue.put("verifiedResult", FieldSetup.verifiedResult());
            createIssue.put("planFixDate", FieldSetup.planFixDate());
            createIssue.put("severity", FieldSetup.severity());
            createIssue.put("issueVersion", FieldSetup.version());
            createIssue.put("fixVersion", FieldSetup.fixVersion());
            createIssue.put("title", FieldSetup.title());
            createIssue.put("feature", FieldSetup.feature());
            createIssue.put("issueStatus", FieldSetup.testStatus());
            createIssue.put("projectId", FieldSetup.projectId());
            createIssue.put("description", FieldSetup.description());
            createIssue.put("caseCategory", FieldSetup.caseCategory());
            createIssue.put("priority", FieldSetup.priority());
            createIssue.put("reportTo", FieldSetup.reportTo());
            createIssue.put("env", FieldSetup.env());
            createIssue.put("testType", FieldSetup.testType());
            createIssue.put("testDevice", FieldSetup.testDevice());
            createIssue.put("platform", FieldSetup.platform());
            createIssue.put("browser", FieldSetup.browser());
            createIssue.put("remarks", FieldSetup.remarks());
            createIssue.put("customFieldDatas", FieldSetup.customFieldDatas());

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return createIssue;
    }


    public void issuePayload(String title) {
        FieldSetup.verifiedResult("");
        FieldSetup.planFixDate(PTApiFieldSetup.getPlanFixDate());
        FieldSetup.severity(PTApiFieldSetup.getSeverity());
        FieldSetup.version(PTConstant.getPTVersion());
        FieldSetup.fixVersion(PTConstant.getPTVersion());
        FieldSetup.title(title);
        FieldSetup.feature(PTApiFieldSetup.getFeature());
        FieldSetup.testStatus("新建");
        FieldSetup.projectId(PTConstant.getPTProjectId());
        FieldSetup.description(PTApiFieldSetup.getFailureMessage());
        FieldSetup.caseCategory(PTApiFieldSetup.getCategory());
        FieldSetup.priority(PTApiFieldSetup.getPriority());
        FieldSetup.reportTo("huju");
        FieldSetup.testMethod("自动");
        FieldSetup.env(PTConstant.getPTEnv());
        FieldSetup.testType("负向");
        FieldSetup.testDevice(PTConstant.getPTPlatform());
        FieldSetup.platform(PTConstant.getPTPlatform());
        FieldSetup.browser("Chrome");
        FieldSetup.remarks("testing text from test case running");

        FieldSetup.duration( PTApiFieldSetup.getDuration());
        FieldSetup.userImpact( PTApiFieldSetup.getUserImpact());
        FieldSetup.fixCategory( PTApiFieldSetup.getFixCategory());
        FieldSetup.rootcauseCategory(PTApiFieldSetup.getRootcauseCategory());
        FieldSetup.rootCause( PTApiFieldSetup.getRootCause());
        FieldSetup.frequency( PTApiFieldSetup.getFrequency());
        FieldSetup.issueSource( PTApiFieldSetup.getIssueSource());

        Map<String, String> custom = new HashMap<>();
        FieldSetup.customFieldDatas(customFiledData(custom));
        PTApiPayloadConfig.setIssuePayloadAsJson(issueCreationPayload());
        System.out.println("==================="+ issueCreationPayload().toString());
    }
}
