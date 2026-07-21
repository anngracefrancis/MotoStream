package cm.aptoide.pt.view;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.repository.request.RewardAppCoinsAppsRepository;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesRewardAppCoinsAppsRepositoryFactory implements Provider {
    private final Provider<BodyInterceptor<BaseBody>> baseBodyBodyInterceptorProvider;
    private final Provider<InstallManager> installManagerProvider;
    private final FragmentModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;

    public FragmentModule_ProvidesRewardAppCoinsAppsRepositoryFactory(FragmentModule fragmentModule, Provider<OkHttpClient> provider, Provider<BodyInterceptor<BaseBody>> provider2, Provider<TokenInvalidator> provider3, Provider<SharedPreferences> provider4, Provider<InstallManager> provider5) {
        this.module = fragmentModule;
        this.okHttpClientProvider = provider;
        this.baseBodyBodyInterceptorProvider = provider2;
        this.tokenInvalidatorProvider = provider3;
        this.sharedPreferencesProvider = provider4;
        this.installManagerProvider = provider5;
    }

    public static FragmentModule_ProvidesRewardAppCoinsAppsRepositoryFactory create(FragmentModule fragmentModule, Provider<OkHttpClient> provider, Provider<BodyInterceptor<BaseBody>> provider2, Provider<TokenInvalidator> provider3, Provider<SharedPreferences> provider4, Provider<InstallManager> provider5) {
        return new FragmentModule_ProvidesRewardAppCoinsAppsRepositoryFactory(fragmentModule, provider, provider2, provider3, provider4, provider5);
    }

    public static RewardAppCoinsAppsRepository providesRewardAppCoinsAppsRepository(FragmentModule fragmentModule, OkHttpClient okHttpClient, BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, InstallManager installManager) {
        return (RewardAppCoinsAppsRepository) f.b.b.c(fragmentModule.providesRewardAppCoinsAppsRepository(okHttpClient, bodyInterceptor, tokenInvalidator, sharedPreferences, installManager));
    }

    @Override // javax.inject.Provider
    public RewardAppCoinsAppsRepository get() {
        return providesRewardAppCoinsAppsRepository(this.module, this.okHttpClientProvider.get(), this.baseBodyBodyInterceptorProvider.get(), this.tokenInvalidatorProvider.get(), this.sharedPreferencesProvider.get(), this.installManagerProvider.get());
    }
}
