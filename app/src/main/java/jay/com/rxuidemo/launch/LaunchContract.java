package jay.com.rxuidemo.launch;

import jay.com.rxuidemo.core.BasePresenter;
import jay.com.rxuidemo.core.BaseView;

/**
 *
 */

interface LaunchContract {
    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter<View> {

    }
}
