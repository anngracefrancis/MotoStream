package cm.aptoide.pt;

import android.view.WindowManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideWindowManagerFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideWindowManagerFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideWindowManagerFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideWindowManagerFactory(applicationModule);
    }

    public static WindowManager provideWindowManager(ApplicationModule applicationModule) {
        return (WindowManager) f.b.b.c(applicationModule.provideWindowManager());
    }

    @Override // javax.inject.Provider
    public WindowManager get() {
        return provideWindowManager(this.module);
    }
}
