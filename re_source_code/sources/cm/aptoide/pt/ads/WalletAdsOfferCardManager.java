package cm.aptoide.pt.ads;

import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.blacklist.BlacklistManager;
import cm.aptoide.pt.install.PackageRepository;

/* JADX INFO: loaded from: classes.dex */
public class WalletAdsOfferCardManager {
    private final BlacklistManager blacklistManager;
    private final PackageRepository packageRepository;

    public WalletAdsOfferCardManager(BlacklistManager blacklistManager, PackageRepository packageRepository) {
        this.blacklistManager = blacklistManager;
        this.packageRepository = packageRepository;
    }

    public boolean shouldShowWalletOfferCard(String str, String str2) {
        return (this.blacklistManager.isBlacklisted(str, str2) || this.packageRepository.isAppInstalled(AptoideApplication.APPCOINS_WALLET_PACKAGE_NAME)) ? false : true;
    }
}
