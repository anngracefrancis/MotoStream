package cm.aptoide.pt;

import cm.aptoide.pt.dataprovider.ws.v7.store.RequestBodyFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideRequestBodyFactoryFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideRequestBodyFactoryFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideRequestBodyFactoryFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideRequestBodyFactoryFactory(applicationModule);
    }

    public static RequestBodyFactory provideRequestBodyFactory(ApplicationModule applicationModule) {
        return (RequestBodyFactory) f.b.b.c(applicationModule.provideRequestBodyFactory());
    }

    @Override // javax.inject.Provider
    public RequestBodyFactory get() {
        return provideRequestBodyFactory(this.module);
    }
}
