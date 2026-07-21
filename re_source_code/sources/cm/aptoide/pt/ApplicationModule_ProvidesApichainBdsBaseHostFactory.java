package cm.aptoide.pt;

import android.content.SharedPreferences;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesApichainBdsBaseHostFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public ApplicationModule_ProvidesApichainBdsBaseHostFactory(ApplicationModule applicationModule, Provider<SharedPreferences> provider) {
        this.module = applicationModule;
        this.sharedPreferencesProvider = provider;
    }

    public static ApplicationModule_ProvidesApichainBdsBaseHostFactory create(ApplicationModule applicationModule, Provider<SharedPreferences> provider) {
        return new ApplicationModule_ProvidesApichainBdsBaseHostFactory(applicationModule, provider);
    }

    public static String providesApichainBdsBaseHost(ApplicationModule applicationModule, SharedPreferences sharedPreferences) {
        return (String) f.b.b.c(applicationModule.providesApichainBdsBaseHost(sharedPreferences));
    }

    @Override // javax.inject.Provider
    public String get() {
        return providesApichainBdsBaseHost(this.module, this.sharedPreferencesProvider.get());
    }
}
