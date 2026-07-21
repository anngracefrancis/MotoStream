package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesUpdateLaunchManagerFactory implements Provider {
    private final Provider<FollowedStoresManager> followedStoresManagerProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesUpdateLaunchManagerFactory(ApplicationModule applicationModule, Provider<FollowedStoresManager> provider) {
        this.module = applicationModule;
        this.followedStoresManagerProvider = provider;
    }

    public static ApplicationModule_ProvidesUpdateLaunchManagerFactory create(ApplicationModule applicationModule, Provider<FollowedStoresManager> provider) {
        return new ApplicationModule_ProvidesUpdateLaunchManagerFactory(applicationModule, provider);
    }

    public static UpdateLaunchManager providesUpdateLaunchManager(ApplicationModule applicationModule, FollowedStoresManager followedStoresManager) {
        return (UpdateLaunchManager) f.b.b.c(applicationModule.providesUpdateLaunchManager(followedStoresManager));
    }

    @Override // javax.inject.Provider
    public UpdateLaunchManager get() {
        return providesUpdateLaunchManager(this.module, this.followedStoresManagerProvider.get());
    }
}
