package cm.aptoide.pt;

import cm.aptoide.pt.reactions.network.ReactionsRemoteService;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesReactionsServiceV8Factory implements Provider {
    private final ApplicationModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ApplicationModule_ProvidesReactionsServiceV8Factory(ApplicationModule applicationModule, Provider<Retrofit> provider) {
        this.module = applicationModule;
        this.retrofitProvider = provider;
    }

    public static ApplicationModule_ProvidesReactionsServiceV8Factory create(ApplicationModule applicationModule, Provider<Retrofit> provider) {
        return new ApplicationModule_ProvidesReactionsServiceV8Factory(applicationModule, provider);
    }

    public static ReactionsRemoteService.ServiceV8 providesReactionsServiceV8(ApplicationModule applicationModule, Retrofit retrofit) {
        return (ReactionsRemoteService.ServiceV8) f.b.b.c(applicationModule.providesReactionsServiceV8(retrofit));
    }

    @Override // javax.inject.Provider
    public ReactionsRemoteService.ServiceV8 get() {
        return providesReactionsServiceV8(this.module, this.retrofitProvider.get());
    }
}
