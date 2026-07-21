package cm.aptoide.pt.wallet;

import cm.aptoide.pt.app.DownloadModel;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.promotions.WalletApp;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: WalletInstallView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0007H&J\b\u0010\f\u001a\u00020\u0007H&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003H&J\b\u0010\u000f\u001a\u00020\u0007H&J\u001a\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0007H&¨\u0006\u0016"}, d2 = {"Lcm/aptoide/pt/wallet/WalletInstallView;", "Lcm/aptoide/pt/presenter/View;", "cancelDownloadButtonClicked", "Lrx/Observable;", "Ljava/lang/Void;", "closeButtonClicked", "dismissDialog", HttpUrl.FRAGMENT_ENCODE_SET, "showDownloadState", "downloadModel", "Lcm/aptoide/pt/app/DownloadModel;", "showIndeterminateDownload", "showInstallationSuccessView", "showRootInstallWarningPopup", HttpUrl.FRAGMENT_ENCODE_SET, "showSdkErrorView", "showWalletInstallationView", "appIcon", HttpUrl.FRAGMENT_ENCODE_SET, "walletApp", "Lcm/aptoide/pt/promotions/WalletApp;", "showWalletInstalledAlreadyView", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletInstallView extends View {
    rx.e<Void> cancelDownloadButtonClicked();

    rx.e<Void> closeButtonClicked();

    void dismissDialog();

    void showDownloadState(DownloadModel downloadModel);

    void showIndeterminateDownload();

    void showInstallationSuccessView();

    rx.e<Boolean> showRootInstallWarningPopup();

    void showSdkErrorView();

    void showWalletInstallationView(String appIcon, WalletApp walletApp);

    void showWalletInstalledAlreadyView();
}
