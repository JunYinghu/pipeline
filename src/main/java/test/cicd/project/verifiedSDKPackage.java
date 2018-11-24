package test.cicd.project;


import io.qameta.allure.Step;

public class verifiedSDKPackage {

    @Step("createFolder &DownloadHelper")
    public void createFoder(){
    System.err.println("i am testing");
    }

    @Step("Verify Structure")
    public void verifyStructure(){
        System.err.println("i am testing");
    }

    @Step("Verify Version")
    public void verifyVersion(){
        System.err.println("i am testing");
    }

    @Step("Verify executable file")
    public void verifyExecutable(){

    }

    @Step("return result")
    public void returnResult(){

    }


}
