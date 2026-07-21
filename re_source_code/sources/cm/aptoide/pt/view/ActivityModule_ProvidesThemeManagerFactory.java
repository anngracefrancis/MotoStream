package cm.aptoide.pt.view;

import cm.aptoide.pt.themes.ThemeManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvidesThemeManagerFactory implements Provider {
    private final ActivityModule module;

    public ActivityModule_ProvidesThemeManagerFactory(ActivityModule activityModule) {
        this.module = activityModule;
    }

    public static ActivityModule_ProvidesThemeManagerFactory create(ActivityModule activityModule) {
        return new ActivityModule_ProvidesThemeManagerFactory(activityModule);
    }

    public static ThemeManager providesThemeManager(ActivityModule activityModule) {
        return (ThemeManager) f.b.b.c(activityModule.providesThemeManager());
    }

    @Override // javax.inject.Provider
    public ThemeManager get() {
        return providesThemeManager(this.module);
    }
}
