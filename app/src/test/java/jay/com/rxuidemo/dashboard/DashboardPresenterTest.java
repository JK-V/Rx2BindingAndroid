package jay.com.rxuidemo.dashboard;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */

public class DashboardPresenterTest {

    private DashboardContract.Presenter mDashboardPresenter;
    private DashboardContract.View mDashboardView;

    @Before
    public void setUp() {
        mDashboardPresenter = new DashboardPresenter(mDashboardView);
    }

    @After
    public void tearDown() {
        mDashboardView = null;
        mDashboardPresenter = null;
    }
}
