package cm.aptoide.pt.appview;

import cm.aptoide.pt.app.DownloadModel;
import cm.aptoide.pt.app.view.AppCoinsViewModel;
import cm.aptoide.pt.presenter.View;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public interface InstallAppView extends View {
    e<Void> cancelDownload();

    e<DownloadModel.Action> installAppClick();

    void openApp(String str);

    e<Void> pauseDownload();

    e<DownloadModel.Action> resumeDownload();

    e<Boolean> showDowngradeMessage();

    void showDowngradingMessage();

    void showDownloadAppModel(DownloadModel downloadModel, AppCoinsViewModel appCoinsViewModel, boolean z);

    void showGenericErrorDialog();

    void showInvalidAppInfoErrorDialog();

    e<Boolean> showRootInstallWarningPopup();
}
