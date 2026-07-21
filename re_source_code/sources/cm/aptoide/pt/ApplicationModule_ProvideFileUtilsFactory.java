package cm.aptoide.pt;

import cm.aptoide.pt.utils.FileUtils;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideFileUtilsFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideFileUtilsFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideFileUtilsFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideFileUtilsFactory(applicationModule);
    }

    public static FileUtils provideFileUtils(ApplicationModule applicationModule) {
        return (FileUtils) f.b.b.c(applicationModule.provideFileUtils());
    }

    @Override // javax.inject.Provider
    public FileUtils get() {
        return provideFileUtils(this.module);
    }
}
