package jay.com.rxuidemo.register;

/**
 *
 */

class RegistrationPresenter implements RegistrationContract.Presenter {

    public RegistrationPresenter(RegistrationContract.View mRegistrationView) {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public int validateName(String nameString) {
        return 0;
    }

    @Override
    public int validateEmail(String emailString) {
        return 0;
    }

    @Override
    public int validateDOB(String dobString) {
        return 0;
    }

    @Override
    public int validatePhoneNumber(String phoneNumberString) {
        return 0;
    }

    private boolean isAlpha(String input) {
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
}
