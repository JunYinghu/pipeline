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


    public JSONObject customFiledData(Map<String, String> custom){
        JSONObject customFieldDatas = new JSONObject();
        for (Map.Entry<String,String> entry : custom.entrySet()){
            try {
                customFieldDatas.put(entry.getKey(), entry.getValue());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return customFieldDatas;
    }
    FieldsSetup FieldsSetup = new FieldsSetup();
    public void tcPayload(String externalId){
        FieldsSetup.externalLinkId(externalId);
        FieldsSetup.title(PTApiFieldSetup.getTitle());
        FieldsSetup.feature(PTApiFieldSetup.getFeature());
        FieldsSetup.testModule("自动化");
        FieldsSetup.testStatus("已评审");
        FieldsSetup.projectId(PTConstant.getPTProjectId());
        FieldsSetup.description("THIS IS payload from AUTOMATION test case given via test case");
        FieldsSetup.version(PTConstant.getPTVersion());
        FieldsSetup.caseCategory("功能");
        FieldsSetup.priority("高");
        FieldsSetup.reportTo("huju");
        FieldsSetup.testData("tet data");
        FieldsSetup.testMethod("自动化");
        FieldsSetup.env(PTConstant.getPTEnv());
        FieldsSetup.testType("正向");
        FieldsSetup.testDevice(PTConstant.getPTPlatform());
        FieldsSetup.platform(PTConstant.getPTPlatform());
        FieldsSetup.browser("Chrome");
        FieldsSetup.testCondition("");
        FieldsSetup.remarks("testing only");
        Map<String, String> custom = new HashMap<>();
        FieldsSetup.customFieldDatas(customFiledData(custom));
        //PTApiPayloadConfig ptApiPayload = new PTApiPayloadConfig();
        PTApiPayloadConfig.setTestCasePayload(testCaseCreationPayload());
        System.out.println("+++++++++++++ this print from test case: " + PTApiPayloadConfig.getTestCasePayload());
    }
    public String testCaseCreationPayload(){
        JSONObject createTc = new JSONObject();
        try {
            createTc.put("externalLinkId", FieldsSetup.externalLinkId());
            createTc.put("title", FieldsSetup.title());
            createTc.put("feature", FieldsSetup.feature());
            createTc.put("module", FieldsSetup.testModule());
            createTc.put("testStatus", FieldsSetup.testStatus());
            createTc.put("projectId", FieldsSetup.projectId());
            createTc.put("description",FieldsSetup.description());
            createTc.put("version",FieldsSetup.version());
            createTc.put("caseCategory",FieldsSetup.caseCategory());
            createTc.put("priority",FieldsSetup.priority());
            createTc.put("reportTo", FieldsSetup.reportTo());
            createTc.put("testData", FieldsSetup.testData());
            createTc.put("testMethod", FieldsSetup.testMethod());
            createTc.put("env", FieldsSetup.env());
            createTc.put("testType", FieldsSetup.testType());
            createTc.put("device",FieldsSetup.testDevice());
            createTc.put("platform",FieldsSetup.platform());
            createTc.put("browser", FieldsSetup.browser());
            createTc.put("testCondition", FieldsSetup.testCondition());
            createTc.put("remarks", FieldsSetup.remarks());
            createTc.put("customFieldDatas", FieldsSetup.customFieldDatas());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return createTc.toString();
    }



    public String issuePayload(){
        JSONObject createIssue = new JSONObject();
        try {
            createIssue.put("runcaseId", FieldsSetup.externalLinkId());
            createIssue.put("verifiedResult", FieldsSetup.verifiedResult());
            createIssue.put("planFixDate", FieldsSetup.planFixDate());
            createIssue.put("severity", FieldsSetup.severity());
            createIssue.put("issueVersion", FieldsSetup.version());
            createIssue.put("fixVersion", FieldsSetup.fixVersion());

            createIssue.put("title", FieldsSetup.title());
            createIssue.put("feature", FieldsSetup.feature());
            createIssue.put("issueStatus", FieldsSetup.testStatus());
            createIssue.put("projectId", FieldsSetup.projectId());
            createIssue.put("description",FieldsSetup.description());
            createIssue.put("caseCategory",FieldsSetup.caseCategory());
            createIssue.put("priority",FieldsSetup.priority());
            createIssue.put("reportTo", FieldsSetup.reportTo());
            createIssue.put("fixVersion", FieldsSetup.testMethod());
            createIssue.put("env", FieldsSetup.env());
            createIssue.put("testType", FieldsSetup.testType());
            createIssue.put("testDevice",FieldsSetup.testDevice());
            createIssue.put("platform",FieldsSetup.platform());
            createIssue.put("browser", FieldsSetup.browser());
            createIssue.put("remarks", FieldsSetup.remarks());
            createIssue.put("customFieldDatas", FieldsSetup.customFieldDatas());

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return createIssue.toString();
    }


    public void issueCreationPayload(String title){
        FieldsSetup.verifiedResult("");
        FieldsSetup.planFixDate("");
        FieldsSetup.severity("严重");
        FieldsSetup.version(PTConstant.getPTVersion());
        FieldsSetup.fixVersion("");

        FieldsSetup.title(title);
        FieldsSetup.feature("feature");
        FieldsSetup.testStatus("已评审");
        FieldsSetup.projectId(PTConstant.getPTProjectId());
        FieldsSetup.description("THIS IS FROM AUTOMATION");
        FieldsSetup.caseCategory("功能");
        FieldsSetup.priority("高");
        FieldsSetup.reportTo("huju");
        FieldsSetup.testMethod("自动化");
        FieldsSetup.env(PTConstant.getPTEnv());
        FieldsSetup.testType("正向");
        FieldsSetup.testDevice(PTConstant.getPTPlatform());
        FieldsSetup.platform(PTConstant.getPTPlatform());
        FieldsSetup.browser("Chrome");

        FieldsSetup.remarks("testing only");
        Map<String, String> custom = new HashMap<>();
        FieldsSetup.customFieldDatas(customFiledData(custom));
        PTApiPayloadConfig.getIssuePayload(issuePayload());

    }
}
