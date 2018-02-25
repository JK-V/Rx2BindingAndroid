package jay.com.rxuidemo.dashboard;

import jay.com.rxuidemo.core.BasePresenter;
import jay.com.rxuidemo.core.BaseView;

/**
 *
 */

interface DashboardContract {
    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter<View> {
        
    }
}
