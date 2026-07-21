package cm.aptoide.pt;

import java.util.Collection;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideFlurryEventsFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideFlurryEventsFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideFlurryEventsFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideFlurryEventsFactory(applicationModule);
    }

    public static Collection<String> provideFlurryEvents(ApplicationModule applicationModule) {
        return (Collection) f.b.b.c(applicationModule.provideFlurryEvents());
    }

    @Override // javax.inject.Provider
    public Collection<String> get() {
        return provideFlurryEvents(this.module);
    }
}
