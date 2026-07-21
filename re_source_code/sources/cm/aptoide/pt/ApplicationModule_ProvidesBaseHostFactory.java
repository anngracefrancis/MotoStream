package cm.aptoide.pt;

import android.content.SharedPreferences;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesBaseHostFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public ApplicationModule_ProvidesBaseHostFactory(ApplicationModule applicationModule, Provider<SharedPreferences> provider) {
        this.module = applicationModule;
        this.sharedPreferencesProvider = provider;
    }

    public static ApplicationModule_ProvidesBaseHostFactory create(ApplicationModule applicationModule, Provider<SharedPreferences> provider) {
        return new ApplicationModule_ProvidesBaseHostFactory(applicationModule, provider);
    }

    public static String providesBaseHost(ApplicationModule applicationModule, SharedPreferences sharedPreferences) {
        return (String) f.b.b.c(applicationModule.providesBaseHost(sharedPreferences));
    }

    @Override // javax.inject.Provider
    public String get() {
        return providesBaseHost(this.module, this.sharedPreferencesProvider.get());
    }
}
