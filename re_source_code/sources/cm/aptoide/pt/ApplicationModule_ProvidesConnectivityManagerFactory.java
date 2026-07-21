package cm.aptoide.pt;

import android.net.ConnectivityManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesConnectivityManagerFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesConnectivityManagerFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesConnectivityManagerFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesConnectivityManagerFactory(applicationModule);
    }

    public static ConnectivityManager providesConnectivityManager(ApplicationModule applicationModule) {
        return (ConnectivityManager) f.b.b.c(applicationModule.providesConnectivityManager());
    }

    @Override // javax.inject.Provider
    public ConnectivityManager get() {
        return providesConnectivityManager(this.module);
    }
}
