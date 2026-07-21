package cm.aptoide.pt.ads;

import android.content.pm.PackageManager;
import cm.aptoide.pt.AptoideApplication;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class WalletAdsOfferManager {
    private final PackageManager packageManager;

    public enum OfferResponseStatus {
        NO_ADS,
        ADS_SHOW,
        ADS_HIDE
    }

    public WalletAdsOfferManager(PackageManager packageManager) {
        this.packageManager = packageManager;
    }

    private boolean isWalletInstalled() {
        try {
            return this.packageManager.getPackageInfo(AptoideApplication.APPCOINS_WALLET_PACKAGE_NAME, 0) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public Single<Boolean> shouldRequestMoPubAd() {
        return Single.m(Boolean.valueOf(!isWalletInstalled()));
    }
}
