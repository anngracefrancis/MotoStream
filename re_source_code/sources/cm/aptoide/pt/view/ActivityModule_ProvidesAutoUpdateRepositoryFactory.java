package cm.aptoide.pt.view;

import cm.aptoide.pt.autoupdate.AutoUpdateRepository;
import cm.aptoide.pt.autoupdate.AutoUpdateService;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvidesAutoUpdateRepositoryFactory implements Provider {
    private final Provider<AutoUpdateService> autoUpdateServiceProvider;
    private final ActivityModule module;

    public ActivityModule_ProvidesAutoUpdateRepositoryFactory(ActivityModule activityModule, Provider<AutoUpdateService> provider) {
        this.module = activityModule;
        this.autoUpdateServiceProvider = provider;
    }

    public static ActivityModule_ProvidesAutoUpdateRepositoryFactory create(ActivityModule activityModule, Provider<AutoUpdateService> provider) {
        return new ActivityModule_ProvidesAutoUpdateRepositoryFactory(activityModule, provider);
    }

    public static AutoUpdateRepository providesAutoUpdateRepository(ActivityModule activityModule, AutoUpdateService autoUpdateService) {
        return (AutoUpdateRepository) f.b.b.c(activityModule.providesAutoUpdateRepository(autoUpdateService));
    }

    @Override // javax.inject.Provider
    public AutoUpdateRepository get() {
        return providesAutoUpdateRepository(this.module, this.autoUpdateServiceProvider.get());
    }
}
