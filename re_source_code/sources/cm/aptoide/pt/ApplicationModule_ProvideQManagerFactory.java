package cm.aptoide.pt;

import android.content.res.Resources;
import android.view.WindowManager;
import cm.aptoide.pt.utils.q.QManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideQManagerFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<Resources> resourcesProvider;
    private final Provider<WindowManager> windowManagerProvider;

    public ApplicationModule_ProvideQManagerFactory(ApplicationModule applicationModule, Provider<Resources> provider, Provider<WindowManager> provider2) {
        this.module = applicationModule;
        this.resourcesProvider = provider;
        this.windowManagerProvider = provider2;
    }

    public static ApplicationModule_ProvideQManagerFactory create(ApplicationModule applicationModule, Provider<Resources> provider, Provider<WindowManager> provider2) {
        return new ApplicationModule_ProvideQManagerFactory(applicationModule, provider, provider2);
    }

    public static QManager provideQManager(ApplicationModule applicationModule, Resources resources, WindowManager windowManager) {
        return (QManager) f.b.b.c(applicationModule.provideQManager(resources, windowManager));
    }

    @Override // javax.inject.Provider
    public QManager get() {
        return provideQManager(this.module, this.resourcesProvider.get(), this.windowManagerProvider.get());
    }
}
