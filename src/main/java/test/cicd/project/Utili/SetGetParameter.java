package test.cicd.project.Utili;

public class SetGetParameter {


    private String loginUserId;
    private String LoginUserPassword;
    private String currentBuildNo;
    private String currentENV;
    private String currentBrowser;

    public void setLoginUser(String loginUser){
        loginUserId = loginUser;

    }

    public String getLoginUser(){
        return loginUserId;
    }

    public void setLoginPassword (String LoginPassword){
        LoginUserPassword = LoginPassword;
    }

    public String getLoginPassword(){
        return LoginUserPassword;
    }
    public void setBuildNo(String buildNo){
        currentBuildNo = buildNo;
    }

    public String getBuildNo(){
        return currentBuildNo;
    }

    public void setENV(String env){
        currentENV = env;
    }

    public String getEnv (){
        return currentENV;
    }

    public void setBrowser(String browser){
        currentBrowser = browser;
    }
    public String getBrowser(){
        return currentBrowser;
    }
}
