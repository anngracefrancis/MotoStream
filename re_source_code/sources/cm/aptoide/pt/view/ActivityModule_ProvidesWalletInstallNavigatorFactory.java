package cm.aptoide.pt.view;

import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.wallet.WalletInstallNavigator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvidesWalletInstallNavigatorFactory implements Provider {
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final ActivityModule module;

    public ActivityModule_ProvidesWalletInstallNavigatorFactory(ActivityModule activityModule, Provider<FragmentNavigator> provider) {
        this.module = activityModule;
        this.fragmentNavigatorProvider = provider;
    }

    public static ActivityModule_ProvidesWalletInstallNavigatorFactory create(ActivityModule activityModule, Provider<FragmentNavigator> provider) {
        return new ActivityModule_ProvidesWalletInstallNavigatorFactory(activityModule, provider);
    }

    public static WalletInstallNavigator providesWalletInstallNavigator(ActivityModule activityModule, FragmentNavigator fragmentNavigator) {
        return (WalletInstallNavigator) f.b.b.c(activityModule.providesWalletInstallNavigator(fragmentNavigator));
    }

    @Override // javax.inject.Provider
    public WalletInstallNavigator get() {
        return providesWalletInstallNavigator(this.module, this.fragmentNavigatorProvider.get());
    }
}
