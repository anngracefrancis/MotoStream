package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesSettingsManagerFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesSettingsManagerFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesSettingsManagerFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesSettingsManagerFactory(applicationModule);
    }

    public static SettingsManager providesSettingsManager(ApplicationModule applicationModule) {
        return (SettingsManager) f.b.b.c(applicationModule.providesSettingsManager());
    }

    @Override // javax.inject.Provider
    public SettingsManager get() {
        return providesSettingsManager(this.module);
    }
}
