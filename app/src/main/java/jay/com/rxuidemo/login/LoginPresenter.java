package jay.com.rxuidemo.login;

/**
 *
 */

class LoginPresenter implements LoginContract.Presenter {

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "JakeForSake", "asyouwish"
    };
    private LoginContract.View mLoginView;

    public LoginPresenter(LoginContract.View loginView) {
        mLoginView = loginView;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public int validateUsername(String usernameString) {
        if (usernameString.isEmpty())
            return 101;
        else if (usernameString.length() < 8)
            return 102;
        else
            return 200;
    }

    @Override
    public int validatePassword(String passwordString) {
        if (passwordString.isEmpty())
            return 101;
        else if (passwordString.length() < 8)
            return 102;
        else
            return 200;
    }

    @Override
    public void attemptLogin(String username, String password) {
        if (username.equals(DUMMY_CREDENTIALS[0]) && password.equals(DUMMY_CREDENTIALS[1]))
            mLoginView.onSuccessfulLogin();
        else
            mLoginView.onLoginFailed();
    }

    @Override
    public void unsubscribe() {

    }
}
