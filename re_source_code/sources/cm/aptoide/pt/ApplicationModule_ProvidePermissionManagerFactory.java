package cm.aptoide.pt;

import cm.aptoide.pt.actions.PermissionManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidePermissionManagerFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidePermissionManagerFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidePermissionManagerFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidePermissionManagerFactory(applicationModule);
    }

    public static PermissionManager providePermissionManager(ApplicationModule applicationModule) {
        return (PermissionManager) f.b.b.c(applicationModule.providePermissionManager());
    }

    @Override // javax.inject.Provider
    public PermissionManager get() {
        return providePermissionManager(this.module);
    }
}
