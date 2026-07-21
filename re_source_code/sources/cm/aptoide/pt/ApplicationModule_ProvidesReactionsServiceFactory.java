package cm.aptoide.pt;

import cm.aptoide.pt.reactions.network.ReactionsRemoteService;
import cm.aptoide.pt.reactions.network.ReactionsService;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesReactionsServiceFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<ReactionsRemoteService.ServiceV8> reactionServiceV8Provider;

    public ApplicationModule_ProvidesReactionsServiceFactory(ApplicationModule applicationModule, Provider<ReactionsRemoteService.ServiceV8> provider) {
        this.module = applicationModule;
        this.reactionServiceV8Provider = provider;
    }

    public static ApplicationModule_ProvidesReactionsServiceFactory create(ApplicationModule applicationModule, Provider<ReactionsRemoteService.ServiceV8> provider) {
        return new ApplicationModule_ProvidesReactionsServiceFactory(applicationModule, provider);
    }

    public static ReactionsService providesReactionsService(ApplicationModule applicationModule, ReactionsRemoteService.ServiceV8 serviceV8) {
        return (ReactionsService) f.b.b.c(applicationModule.providesReactionsService(serviceV8));
    }

    @Override // javax.inject.Provider
    public ReactionsService get() {
        return providesReactionsService(this.module, this.reactionServiceV8Provider.get());
    }
}
