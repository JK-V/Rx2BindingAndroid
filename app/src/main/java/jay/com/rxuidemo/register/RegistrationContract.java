package jay.com.rxuidemo.register;

import jay.com.rxuidemo.core.BasePresenter;
import jay.com.rxuidemo.core.BaseView;

/**
 *
 */

public interface RegistrationContract {
    interface View extends BaseView<Presenter> {
        void navigateToDashboard();
    }

    interface Presenter extends BasePresenter<View> {

//        int validateName(String nameString);

//        int validateEmail(String emailString);
//
//        int validateDOB(String dobString);
//
//        int validatePhoneNumber(String phoneNumberString);

        int validateName(String nameString);

        int validateEmail(String emailString);

        int validateDOB(String dobString);

        int validatePhoneNumber(String phoneNumberString);
    }
}
