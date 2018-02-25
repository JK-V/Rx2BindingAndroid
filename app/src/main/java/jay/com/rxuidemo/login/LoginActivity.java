package jay.com.rxuidemo.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import jay.com.rxuidemo.R;
import jay.com.rxuidemo.dashboard.DashboardActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private Button mLoginButton;
    private EditText mUserNameEditText, mPasswordEditText;
    private CompositeDisposable mCompositeDisposable;
    private LoginContract.Presenter mLoginPresenter;
    private int userNameValidationStatusCode = 0;
    private int passwordValidationStatusCode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setPresenter(new LoginPresenter(this));

        mLoginButton = findViewById(R.id.button_login);
        mUserNameEditText = findViewById(R.id.edit_text_user_name);
        mPasswordEditText = findViewById(R.id.edit_text_password);

        mCompositeDisposable = new CompositeDisposable();
        Observable<CharSequence> usernameObservable = RxTextView.textChanges(mUserNameEditText).skipInitialValue();
        Observable<CharSequence> passwordObservable = RxTextView.textChanges(mPasswordEditText).skipInitialValue();

        mCompositeDisposable.add(passwordObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o -> {
                    userNameValidationStatusCode = mLoginPresenter.validateUsername(o.toString());
                    switch (userNameValidationStatusCode) {
                        case 101:
                            mUserNameEditText.setError("Username can't be empty!");
                            break;
                        case 102:
                            mUserNameEditText.setError("Length should be greater than 8!");
                            break;
                    }
                }));

        mCompositeDisposable.add(passwordObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o -> {
                    passwordValidationStatusCode = mLoginPresenter.validatePassword(o.toString());
                    switch (passwordValidationStatusCode) {
                        case 101:
                            mPasswordEditText.setError("Password can't be empty!");
                            break;
                        case 102:
                            mPasswordEditText.setError("Length should be greater than 8!");
                            break;
                    }
                }));

        mCompositeDisposable.add(Observable.combineLatest(usernameObservable, passwordObservable,
                (o1, o2) -> userNameValidationStatusCode == 200
                        && passwordValidationStatusCode == 200)
                .subscribe(output -> {
                            if (output)
                                mLoginButton.setEnabled(true);
                            else
                                mLoginButton.setEnabled(false);
                        },
                        throwable -> {
                            mLoginButton.setEnabled(false);
                        }));

        RxView.clicks(mLoginButton).subscribe(o -> {
            mLoginPresenter.attemptLogin(mUserNameEditText.getText().toString(), mPasswordEditText.getText().toString());
        });

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mLoginPresenter = presenter;
    }

    @Override
    public void onLoginFailed() {
        Snackbar.make(mLoginButton, getString(R.string.login_failed_msg), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void onSuccessfulLogin() {
        startActivity(new Intent(this, DashboardActivity.class));
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (!mCompositeDisposable.isDisposed())
            mCompositeDisposable.dispose();
    }
}
