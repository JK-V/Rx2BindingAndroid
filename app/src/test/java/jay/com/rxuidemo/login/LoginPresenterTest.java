package jay.com.rxuidemo.login;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */

public class LoginPresenterTest {

    private LoginContract.Presenter mLoginPresenter;
    private LoginContract.View mLoginView;

    @Before
    public void setUp() {
        this.mLoginPresenter = new LoginPresenter(mLoginView);
    }

    @Test
    public void usernameInvalid() {
        String usernameString = "";
        mLoginPresenter.validateUsername(usernameString);
    }

    @Test
    public void usernameValid() {
        String usernameString = "";
        mLoginPresenter.validateUsername(usernameString);
    }

    @Test
    public void loginFailed() {
        mLoginPresenter.onLoginFailed();
    }

    @Test
    public void loginPass() {
        mLoginPresenter.onSuccessfulLogin();
    }

    @After
    public void tearDown() {
        mLoginView = null;
        mLoginPresenter = null;
    }
}
