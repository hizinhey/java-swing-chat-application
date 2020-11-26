package models;

public class LoginUser {
    private static LoginUser instance = null;

    // variable
    private String username;

    private LoginUser() {}

    public static LoginUser getInstance(){
        if(instance == null){
            synchronized (LoginUser.class){
                if(instance == null){
                    instance = new LoginUser();
                }
            }
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }
}
