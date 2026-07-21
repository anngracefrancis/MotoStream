package cm.aptoide.pt.view;

import cm.aptoide.pt.orientation.ScreenOrientationManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvideScreenOrientationManagerFactory implements Provider {
    private final ActivityModule module;

    public ActivityModule_ProvideScreenOrientationManagerFactory(ActivityModule activityModule) {
        this.module = activityModule;
    }

    public static ActivityModule_ProvideScreenOrientationManagerFactory create(ActivityModule activityModule) {
        return new ActivityModule_ProvideScreenOrientationManagerFactory(activityModule);
    }

    public static ScreenOrientationManager provideScreenOrientationManager(ActivityModule activityModule) {
        return (ScreenOrientationManager) f.b.b.c(activityModule.provideScreenOrientationManager());
    }

    @Override // javax.inject.Provider
    public ScreenOrientationManager get() {
        return provideScreenOrientationManager(this.module);
    }
}
