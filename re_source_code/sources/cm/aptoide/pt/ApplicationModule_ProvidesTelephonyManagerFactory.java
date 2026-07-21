package cm.aptoide.pt;

import android.telephony.TelephonyManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesTelephonyManagerFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesTelephonyManagerFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesTelephonyManagerFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesTelephonyManagerFactory(applicationModule);
    }

    public static TelephonyManager providesTelephonyManager(ApplicationModule applicationModule) {
        return (TelephonyManager) f.b.b.c(applicationModule.providesTelephonyManager());
    }

    @Override // javax.inject.Provider
    public TelephonyManager get() {
        return providesTelephonyManager(this.module);
    }
}
