package cm.aptoide.pt;

import java.util.List;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesFacebookLoginPermissionsFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesFacebookLoginPermissionsFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesFacebookLoginPermissionsFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesFacebookLoginPermissionsFactory(applicationModule);
    }

    public static List<String> providesFacebookLoginPermissions(ApplicationModule applicationModule) {
        return (List) f.b.b.c(applicationModule.providesFacebookLoginPermissions());
    }

    @Override // javax.inject.Provider
    public List<String> get() {
        return providesFacebookLoginPermissions(this.module);
    }
}
