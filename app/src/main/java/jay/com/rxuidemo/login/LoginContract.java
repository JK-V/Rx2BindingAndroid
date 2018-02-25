package jay.com.rxuidemo.login;

import jay.com.rxuidemo.core.BasePresenter;
import jay.com.rxuidemo.core.BaseView;

/**
 *
 */

interface LoginContract {

    interface View extends BaseView<Presenter> {
        void onLoginFailed();

        void onSuccessfulLogin();
    }

    interface Presenter extends BasePresenter<View> {

        int validateUsername(String usernameString);

        int validatePassword(String passwordString);

        void attemptLogin(String username, String password);
    }
}
