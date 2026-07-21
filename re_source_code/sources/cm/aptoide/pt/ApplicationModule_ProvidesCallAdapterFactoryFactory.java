package cm.aptoide.pt;

import javax.inject.Provider;
import retrofit2.CallAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesCallAdapterFactoryFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesCallAdapterFactoryFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesCallAdapterFactoryFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesCallAdapterFactoryFactory(applicationModule);
    }

    public static CallAdapter.Factory providesCallAdapterFactory(ApplicationModule applicationModule) {
        return (CallAdapter.Factory) f.b.b.c(applicationModule.providesCallAdapterFactory());
    }

    @Override // javax.inject.Provider
    public CallAdapter.Factory get() {
        return providesCallAdapterFactory(this.module);
    }
}
