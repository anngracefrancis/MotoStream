package cm.aptoide.pt;

import android.content.SharedPreferences;
import cm.aptoide.pt.app.mmpcampaigns.CampaignManager;
import cm.aptoide.pt.app.mmpcampaigns.CampaignRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideCampaignManagerFactory implements Provider {
    private final Provider<CampaignRepository> campaignRepositoryProvider;
    private final ApplicationModule module;
    private final Provider<SharedPreferences> securePreferencesProvider;

    public ApplicationModule_ProvideCampaignManagerFactory(ApplicationModule applicationModule, Provider<CampaignRepository> provider, Provider<SharedPreferences> provider2) {
        this.module = applicationModule;
        this.campaignRepositoryProvider = provider;
        this.securePreferencesProvider = provider2;
    }

    public static ApplicationModule_ProvideCampaignManagerFactory create(ApplicationModule applicationModule, Provider<CampaignRepository> provider, Provider<SharedPreferences> provider2) {
        return new ApplicationModule_ProvideCampaignManagerFactory(applicationModule, provider, provider2);
    }

    public static CampaignManager provideCampaignManager(ApplicationModule applicationModule, CampaignRepository campaignRepository, SharedPreferences sharedPreferences) {
        return (CampaignManager) f.b.b.c(applicationModule.provideCampaignManager(campaignRepository, sharedPreferences));
    }

    @Override // javax.inject.Provider
    public CampaignManager get() {
        return provideCampaignManager(this.module, this.campaignRepositoryProvider.get(), this.securePreferencesProvider.get());
    }
}
