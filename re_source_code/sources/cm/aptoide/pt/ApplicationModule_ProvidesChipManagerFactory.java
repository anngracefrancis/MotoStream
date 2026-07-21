package cm.aptoide.pt;

import cm.aptoide.pt.home.ChipManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesChipManagerFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesChipManagerFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesChipManagerFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesChipManagerFactory(applicationModule);
    }

    public static ChipManager providesChipManager(ApplicationModule applicationModule) {
        return (ChipManager) f.b.b.c(applicationModule.providesChipManager());
    }

    @Override // javax.inject.Provider
    public ChipManager get() {
        return providesChipManager(this.module);
    }
}
