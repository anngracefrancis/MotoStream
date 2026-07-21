package cm.aptoide.pt.view;

import cm.aptoide.pt.home.more.appcoins.EarnAppcListConfiguration;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesListAppsConfigurationFactory implements Provider {
    private final FragmentModule module;

    public FragmentModule_ProvidesListAppsConfigurationFactory(FragmentModule fragmentModule) {
        this.module = fragmentModule;
    }

    public static FragmentModule_ProvidesListAppsConfigurationFactory create(FragmentModule fragmentModule) {
        return new FragmentModule_ProvidesListAppsConfigurationFactory(fragmentModule);
    }

    public static EarnAppcListConfiguration providesListAppsConfiguration(FragmentModule fragmentModule) {
        return (EarnAppcListConfiguration) f.b.b.c(fragmentModule.providesListAppsConfiguration());
    }

    @Override // javax.inject.Provider
    public EarnAppcListConfiguration get() {
        return providesListAppsConfiguration(this.module);
    }
}
