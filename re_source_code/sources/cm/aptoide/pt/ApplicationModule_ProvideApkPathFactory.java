package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideApkPathFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideApkPathFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideApkPathFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideApkPathFactory(applicationModule);
    }

    public static String provideApkPath(ApplicationModule applicationModule) {
        return (String) f.b.b.c(applicationModule.provideApkPath());
    }

    @Override // javax.inject.Provider
    public String get() {
        return provideApkPath(this.module);
    }
}
