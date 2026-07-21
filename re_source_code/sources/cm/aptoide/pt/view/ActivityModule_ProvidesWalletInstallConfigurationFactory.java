package cm.aptoide.pt.view;

import cm.aptoide.pt.wallet.WalletInstallConfiguration;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvidesWalletInstallConfigurationFactory implements Provider {
    private final ActivityModule module;

    public ActivityModule_ProvidesWalletInstallConfigurationFactory(ActivityModule activityModule) {
        this.module = activityModule;
    }

    public static ActivityModule_ProvidesWalletInstallConfigurationFactory create(ActivityModule activityModule) {
        return new ActivityModule_ProvidesWalletInstallConfigurationFactory(activityModule);
    }

    public static WalletInstallConfiguration providesWalletInstallConfiguration(ActivityModule activityModule) {
        return (WalletInstallConfiguration) f.b.b.c(activityModule.providesWalletInstallConfiguration());
    }

    @Override // javax.inject.Provider
    public WalletInstallConfiguration get() {
        return providesWalletInstallConfiguration(this.module);
    }
}
