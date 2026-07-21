package cm.aptoide.pt;

import cm.aptoide.accountmanager.AdultContent;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideAccountSettingsBodyInterceptorPoolV7Factory implements Provider {
    private final Provider<AdultContent> adultContentProvider;
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvideAccountSettingsBodyInterceptorPoolV7Factory(ApplicationModule applicationModule, Provider<BodyInterceptor<BaseBody>> provider, Provider<AdultContent> provider2) {
        this.module = applicationModule;
        this.bodyInterceptorProvider = provider;
        this.adultContentProvider = provider2;
    }

    public static ApplicationModule_ProvideAccountSettingsBodyInterceptorPoolV7Factory create(ApplicationModule applicationModule, Provider<BodyInterceptor<BaseBody>> provider, Provider<AdultContent> provider2) {
        return new ApplicationModule_ProvideAccountSettingsBodyInterceptorPoolV7Factory(applicationModule, provider, provider2);
    }

    public static BodyInterceptor<BaseBody> provideAccountSettingsBodyInterceptorPoolV7(ApplicationModule applicationModule, BodyInterceptor<BaseBody> bodyInterceptor, AdultContent adultContent) {
        return (BodyInterceptor) f.b.b.c(applicationModule.provideAccountSettingsBodyInterceptorPoolV7(bodyInterceptor, adultContent));
    }

    @Override // javax.inject.Provider
    public BodyInterceptor<BaseBody> get() {
        return provideAccountSettingsBodyInterceptorPoolV7(this.module, this.bodyInterceptorProvider.get(), this.adultContentProvider.get());
    }
}
