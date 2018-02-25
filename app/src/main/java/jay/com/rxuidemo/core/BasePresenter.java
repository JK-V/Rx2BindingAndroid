package jay.com.rxuidemo.core;


public interface BasePresenter<T> {
    void subscribe();
    void unsubscribe();
}
