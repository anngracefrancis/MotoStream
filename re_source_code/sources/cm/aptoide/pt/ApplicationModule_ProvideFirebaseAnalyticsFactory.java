package cm.aptoide.pt;

import com.google.firebase.analytics.FirebaseAnalytics;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideFirebaseAnalyticsFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideFirebaseAnalyticsFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideFirebaseAnalyticsFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideFirebaseAnalyticsFactory(applicationModule);
    }

    public static FirebaseAnalytics provideFirebaseAnalytics(ApplicationModule applicationModule) {
        return (FirebaseAnalytics) f.b.b.c(applicationModule.provideFirebaseAnalytics());
    }

    @Override // javax.inject.Provider
    public FirebaseAnalytics get() {
        return provideFirebaseAnalytics(this.module);
    }
}
