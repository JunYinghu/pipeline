package test.cicd.project.Utili;

public class SetGetParameter {


    private String loginUserId;
    private String LoginUserPassword;

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
}
