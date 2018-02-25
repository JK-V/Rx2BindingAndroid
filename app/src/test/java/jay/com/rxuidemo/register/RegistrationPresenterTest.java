package jay.com.rxuidemo.register;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */

public class RegistrationPresenterTest {
    private RegistrationContract.Presenter mRegistrationPresenter;
    private RegistrationContract.View mRegistrationView;

    @Before
    void setUp() {
        mRegistrationPresenter = new RegistrationPresenter(mRegistrationView);
    }

    @Test
    public void subscribe() {
        mRegistrationPresenter.subscribe();
    }


    @Test
    public int validateNameEmpty() {
        String nameString = "";
        return mRegistrationPresenter.validateName(nameString);
    }

    @Test
    public int validateNameInvalidLength() {
        String nameString = "Jake567";
        return mRegistrationPresenter.validateName(nameString);
    }

    @Test
    public int validateNamePass() {
        String nameString = "Jake Droid";
        return mRegistrationPresenter.validateName(nameString);
    }

    @Test
    public int validateInvalidEmail() {
        String emailString = "jake.com";
        return mRegistrationPresenter.validateEmail(emailString);
    }

    @Test
    public int validateEmailPass() {
        String emailString = "";
        return mRegistrationPresenter.validateEmail(emailString);
    }

    @Test
    public int validateInvalidDOB() {
        String dobString = "01-01-18";
        return mRegistrationPresenter.validateDOB(dobString);
    }

    @Test
    public int validateDOBFail() {
        String dobString = "01-01-2018";
        return mRegistrationPresenter.validateDOB(dobString);
    }

    @Test
    public int validateDOBPass() {
        String dobString = "11-02-2018";
        return mRegistrationPresenter.validateDOB(dobString);
    }

    @Test
    public int validateInvalidPhoneNumber() {
        String phoneNumberString = "12345678";
        return mRegistrationPresenter.validatePhoneNumber(phoneNumberString);
    }

    @Test
    public int validatePhoneNumberPass() {
        String phoneNumberString = "1234567890";
        return mRegistrationPresenter.validatePhoneNumber(phoneNumberString);
    }

    @Test
    public void unsubscribe() {
        mRegistrationPresenter.unsubscribe();
    }


    @After
    void tearDown() {

    }
}
