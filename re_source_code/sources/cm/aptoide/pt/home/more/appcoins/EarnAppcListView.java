package cm.aptoide.pt.home.more.appcoins;

import cm.aptoide.pt.home.bundles.apps.RewardApp;
import cm.aptoide.pt.home.more.base.ListAppsView;
import cm.aptoide.pt.promotions.WalletApp;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: EarnAppcListView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004H&J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u0012"}, d2 = {"Lcm/aptoide/pt/home/more/appcoins/EarnAppcListView;", "Lcm/aptoide/pt/home/more/base/ListAppsView;", "Lcm/aptoide/pt/home/bundles/apps/RewardApp;", "cancelDownload", "Lrx/Observable;", "Ljava/lang/Void;", "hideWalletArea", HttpUrl.FRAGMENT_ENCODE_SET, "onWalletInstallClick", "pauseDownload", "resumeDownload", "setupWallet", "walletApp", "Lcm/aptoide/pt/promotions/WalletApp;", "showDownloadError", "showRootInstallWarningPopup", HttpUrl.FRAGMENT_ENCODE_SET, "updateState", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface EarnAppcListView extends ListAppsView<RewardApp> {
    rx.e<Void> cancelDownload();

    void hideWalletArea();

    rx.e<Void> onWalletInstallClick();

    rx.e<Void> pauseDownload();

    rx.e<Void> resumeDownload();

    void setupWallet(WalletApp walletApp);

    void showDownloadError(WalletApp walletApp);

    rx.e<Boolean> showRootInstallWarningPopup();

    void updateState(WalletApp walletApp);
}
