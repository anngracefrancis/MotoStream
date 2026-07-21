package cm.aptoide.pt.home.apps;

import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.view.rx.RxAlertDialog;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public interface AppsFragmentView extends View {
    rx.e<App> cancelDownload();

    rx.e<App> cardClick();

    void hidePullToRefresh();

    rx.e<Void> imageClick();

    rx.e<App> installApp();

    rx.e<App> pauseDownload();

    rx.e<Void> refreshApps();

    rx.e<App> resumeDownload();

    void scrollToTop();

    void setDefaultUserImage();

    void setUserImage(String str);

    void showAvatar();

    Single<RxAlertDialog.Result> showIgnoreUpdateDialog();

    void showModel(AppsModel appsModel);

    rx.e<Boolean> showRootWarning();

    void showUnknownErrorMessage();

    rx.e<App> startDownload();

    rx.e<Void> updateAll();

    rx.e<App> updateLongClick();
}
