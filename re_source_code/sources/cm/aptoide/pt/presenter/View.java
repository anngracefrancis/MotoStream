package cm.aptoide.pt.presenter;

/* JADX INFO: loaded from: classes.dex */
public interface View {

    public enum LifecycleEvent {
        CREATE,
        START,
        RESUME,
        PAUSE,
        STOP,
        DESTROY
    }

    void attachPresenter(Presenter presenter);

    <T> com.trello.rxlifecycle.b<T> bindUntilEvent(LifecycleEvent lifecycleEvent);

    rx.e<LifecycleEvent> getLifecycleEvent();
}
