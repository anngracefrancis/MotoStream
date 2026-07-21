package cm.aptoide.pt.view;

import cm.aptoide.pt.app.FlagManager;
import cm.aptoide.pt.app.FlagService;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesFlagManagerFactory implements Provider {
    private final Provider<FlagService> flagServiceProvider;
    private final FragmentModule module;

    public FragmentModule_ProvidesFlagManagerFactory(FragmentModule fragmentModule, Provider<FlagService> provider) {
        this.module = fragmentModule;
        this.flagServiceProvider = provider;
    }

    public static FragmentModule_ProvidesFlagManagerFactory create(FragmentModule fragmentModule, Provider<FlagService> provider) {
        return new FragmentModule_ProvidesFlagManagerFactory(fragmentModule, provider);
    }

    public static FlagManager providesFlagManager(FragmentModule fragmentModule, FlagService flagService) {
        return (FlagManager) f.b.b.c(fragmentModule.providesFlagManager(flagService));
    }

    @Override // javax.inject.Provider
    public FlagManager get() {
        return providesFlagManager(this.module, this.flagServiceProvider.get());
    }
}
