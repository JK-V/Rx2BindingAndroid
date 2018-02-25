package jay.com.rxuidemo.launch;

import org.junit.After;
import org.junit.Before;

/**
 *
 */

public class LaunchPresenterTest {

    private LaunchContract.Presenter mLunchPresenter;
    private LaunchContract.View mLunchView;

    @Before
    public void setUp(){
        mLunchPresenter = new LaunchPresenter(mLunchView);
    }

    @After
    public void tearDown(){
        mLunchView = null;
        mLunchPresenter = null;
    }
}
