package cm.aptoide.pt;

import android.content.res.Resources;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideResourcesFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideResourcesFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideResourcesFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideResourcesFactory(applicationModule);
    }

    public static Resources provideResources(ApplicationModule applicationModule) {
        return (Resources) f.b.b.c(applicationModule.provideResources());
    }

    @Override // javax.inject.Provider
    public Resources get() {
        return provideResources(this.module);
    }
}
