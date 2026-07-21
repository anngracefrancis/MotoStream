package cm.aptoide.pt.view.app;

import cm.aptoide.pt.presenter.View;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ListStoreAppsView extends View {
    void addApps(List<Application> list);

    rx.e<Application> getAppClick();

    rx.s.b<Void> getRefreshEvent();

    rx.e<Void> getRetryEvent();

    void hideLoading();

    void hideRefreshLoading();

    rx.e<Object> reachesBottom();

    void setApps(List<Application> list);

    void showGenericError();

    void showLoading();

    void showNetworkError();

    void showStartingLoading();
}
