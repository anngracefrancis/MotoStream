package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesShortcutManagerFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesShortcutManagerFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesShortcutManagerFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesShortcutManagerFactory(applicationModule);
    }

    public static AptoideShortcutManager providesShortcutManager(ApplicationModule applicationModule) {
        return (AptoideShortcutManager) f.b.b.c(applicationModule.providesShortcutManager());
    }

    @Override // javax.inject.Provider
    public AptoideShortcutManager get() {
        return providesShortcutManager(this.module);
    }
}
