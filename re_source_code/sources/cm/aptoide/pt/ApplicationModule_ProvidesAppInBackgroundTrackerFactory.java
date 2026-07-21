package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAppInBackgroundTrackerFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAppInBackgroundTrackerFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesAppInBackgroundTrackerFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesAppInBackgroundTrackerFactory(applicationModule);
    }

    public static AppInBackgroundTracker providesAppInBackgroundTracker(ApplicationModule applicationModule) {
        return (AppInBackgroundTracker) f.b.b.c(applicationModule.providesAppInBackgroundTracker());
    }

    @Override // javax.inject.Provider
    public AppInBackgroundTracker get() {
        return providesAppInBackgroundTracker(this.module);
    }
}
