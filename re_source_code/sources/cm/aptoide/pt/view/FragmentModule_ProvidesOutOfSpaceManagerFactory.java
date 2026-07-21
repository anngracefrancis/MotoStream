package cm.aptoide.pt.view;

import cm.aptoide.pt.download.view.outofspace.OutOfSpaceManager;
import cm.aptoide.pt.install.InstallAppSizeValidator;
import cm.aptoide.pt.install.InstallManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesOutOfSpaceManagerFactory implements Provider {
    private final Provider<InstallAppSizeValidator> installAppSizeValidatorProvider;
    private final Provider<InstallManager> installManagerProvider;
    private final FragmentModule module;

    public FragmentModule_ProvidesOutOfSpaceManagerFactory(FragmentModule fragmentModule, Provider<InstallManager> provider, Provider<InstallAppSizeValidator> provider2) {
        this.module = fragmentModule;
        this.installManagerProvider = provider;
        this.installAppSizeValidatorProvider = provider2;
    }

    public static FragmentModule_ProvidesOutOfSpaceManagerFactory create(FragmentModule fragmentModule, Provider<InstallManager> provider, Provider<InstallAppSizeValidator> provider2) {
        return new FragmentModule_ProvidesOutOfSpaceManagerFactory(fragmentModule, provider, provider2);
    }

    public static OutOfSpaceManager providesOutOfSpaceManager(FragmentModule fragmentModule, InstallManager installManager, InstallAppSizeValidator installAppSizeValidator) {
        return (OutOfSpaceManager) f.b.b.c(fragmentModule.providesOutOfSpaceManager(installManager, installAppSizeValidator));
    }

    @Override // javax.inject.Provider
    public OutOfSpaceManager get() {
        return providesOutOfSpaceManager(this.module, this.installManagerProvider.get(), this.installAppSizeValidatorProvider.get());
    }
}
