package cm.aptoide.pt;

import cm.aptoide.pt.install.FilePathProvider;
import cm.aptoide.pt.install.InstallAppSizeValidator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesInstallAppSizeValidatorFactory implements Provider {
    private final Provider<FilePathProvider> filePathProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesInstallAppSizeValidatorFactory(ApplicationModule applicationModule, Provider<FilePathProvider> provider) {
        this.module = applicationModule;
        this.filePathProvider = provider;
    }

    public static ApplicationModule_ProvidesInstallAppSizeValidatorFactory create(ApplicationModule applicationModule, Provider<FilePathProvider> provider) {
        return new ApplicationModule_ProvidesInstallAppSizeValidatorFactory(applicationModule, provider);
    }

    public static InstallAppSizeValidator providesInstallAppSizeValidator(ApplicationModule applicationModule, FilePathProvider filePathProvider) {
        return (InstallAppSizeValidator) f.b.b.c(applicationModule.providesInstallAppSizeValidator(filePathProvider));
    }

    @Override // javax.inject.Provider
    public InstallAppSizeValidator get() {
        return providesInstallAppSizeValidator(this.module, this.filePathProvider.get());
    }
}
