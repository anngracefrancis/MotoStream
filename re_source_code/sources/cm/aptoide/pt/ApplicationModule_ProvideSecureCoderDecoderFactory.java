package cm.aptoide.pt;

import android.content.SharedPreferences;
import cm.aptoide.pt.preferences.secure.SecureCoderDecoder;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideSecureCoderDecoderFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public ApplicationModule_ProvideSecureCoderDecoderFactory(ApplicationModule applicationModule, Provider<SharedPreferences> provider) {
        this.module = applicationModule;
        this.sharedPreferencesProvider = provider;
    }

    public static ApplicationModule_ProvideSecureCoderDecoderFactory create(ApplicationModule applicationModule, Provider<SharedPreferences> provider) {
        return new ApplicationModule_ProvideSecureCoderDecoderFactory(applicationModule, provider);
    }

    public static SecureCoderDecoder provideSecureCoderDecoder(ApplicationModule applicationModule, SharedPreferences sharedPreferences) {
        return (SecureCoderDecoder) f.b.b.c(applicationModule.provideSecureCoderDecoder(sharedPreferences));
    }

    @Override // javax.inject.Provider
    public SecureCoderDecoder get() {
        return provideSecureCoderDecoder(this.module, this.sharedPreferencesProvider.get());
    }
}
