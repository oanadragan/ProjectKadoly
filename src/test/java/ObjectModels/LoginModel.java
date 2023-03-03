package ObjectModels;


public class LoginModel{

    private AccountModel account;
    private String userError;
    private String passwordError;

    public LoginModel() {
    }

    public LoginModel(String username, String password, String userError, String passwordError) {
        AccountModel ac = new AccountModel();
        ac.setUsername(username);
        ac.setPassword(password);

        this.account = ac;
        this.userError = userError;
        this.passwordError = passwordError;
    }

    public AccountModel getAccount() {
        return account;
    }


    public String getUserError() {
        return userError;
    }


    public String getPasswordError() {
        return passwordError;
    }




    @Override
    public String toString() {
        return "LoginData{" +
                "account={username:" + account.getUsername() + ",password:" + account.getPassword() +
                "}, userError='" + userError + '\'' +
                ", passwordError='" + passwordError + '\'' +
                '}';
    }
}
