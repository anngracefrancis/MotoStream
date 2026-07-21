package cm.aptoide.pt;

import cm.aptoide.accountmanager.AccountService;
import cm.aptoide.accountmanager.AdultContent;
import cm.aptoide.pt.account.LoginPreferences;
import cm.aptoide.pt.ads.WalletAdsOfferCardManager;
import cm.aptoide.pt.ads.WalletAdsOfferManager;
import cm.aptoide.pt.blacklist.BlacklistManager;
import cm.aptoide.pt.install.PackageRepository;
import cm.aptoide.pt.preferences.AdultContentManager;
import cm.aptoide.pt.preferences.LocalPersistenceAdultContent;
import cm.aptoide.pt.preferences.Preferences;
import cm.aptoide.pt.preferences.SecurePreferences;
import com.google.android.gms.common.GoogleApiAvailability;
import javax.inject.Named;
import javax.inject.Singleton;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class FlavourApplicationModule {
    private final AptoideApplication application;

    public FlavourApplicationModule(AptoideApplication aptoideApplication) {
        this.application = aptoideApplication;
    }

    @Singleton
    AdultContent provideAdultContent(LocalPersistenceAdultContent localPersistenceAdultContent, AccountService accountService) {
        return new AdultContentManager(localPersistenceAdultContent, accountService);
    }

    @Singleton
    @Named
    String provideAutoUpdateStoreName() {
        return "v9";
    }

    @Singleton
    LocalPersistenceAdultContent provideLocalAdultContent(Preferences preferences, @Named("secure") SecurePreferences securePreferences) {
        return new LocalPersistenceAdultContent(preferences, securePreferences);
    }

    @Singleton
    LoginPreferences provideLoginPreferences() {
        return new LoginPreferences(this.application, GoogleApiAvailability.q());
    }

    @Singleton
    @Named
    String providePartnerID() {
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    @Singleton
    @Named
    String providesSupportEmail() {
        return this.application.getString(R.string.aptoide_email);
    }

    @Singleton
    WalletAdsOfferCardManager providesWalletAdsOfferCardManager(BlacklistManager blacklistManager, PackageRepository packageRepository) {
        return new WalletAdsOfferCardManager(blacklistManager, packageRepository);
    }

    @Singleton
    WalletAdsOfferManager providesWalletAdsOfferManager() {
        return new WalletAdsOfferManager(this.application.getApplicationContext().getPackageManager());
    }
}
