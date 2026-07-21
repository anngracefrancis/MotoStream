package cm.aptoide.pt;

import com.google.android.gms.safetynet.SafetyNetClient;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesSafetyNetClientFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesSafetyNetClientFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesSafetyNetClientFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesSafetyNetClientFactory(applicationModule);
    }

    public static SafetyNetClient providesSafetyNetClient(ApplicationModule applicationModule) {
        return (SafetyNetClient) f.b.b.c(applicationModule.providesSafetyNetClient());
    }

    @Override // javax.inject.Provider
    public SafetyNetClient get() {
        return providesSafetyNetClient(this.module);
    }
}
