package cm.aptoide.pt;

import cm.aptoide.pt.install.PackageRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesPackageRepositoryFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesPackageRepositoryFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesPackageRepositoryFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesPackageRepositoryFactory(applicationModule);
    }

    public static PackageRepository providesPackageRepository(ApplicationModule applicationModule) {
        return (PackageRepository) f.b.b.c(applicationModule.providesPackageRepository());
    }

    @Override // javax.inject.Provider
    public PackageRepository get() {
        return providesPackageRepository(this.module);
    }
}
