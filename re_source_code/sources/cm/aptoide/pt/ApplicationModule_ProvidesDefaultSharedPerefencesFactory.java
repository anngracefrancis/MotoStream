package cm.aptoide.pt;

import android.content.SharedPreferences;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesDefaultSharedPerefencesFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesDefaultSharedPerefencesFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesDefaultSharedPerefencesFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesDefaultSharedPerefencesFactory(applicationModule);
    }

    public static SharedPreferences providesDefaultSharedPerefences(ApplicationModule applicationModule) {
        return (SharedPreferences) f.b.b.c(applicationModule.providesDefaultSharedPerefences());
    }

    @Override // javax.inject.Provider
    public SharedPreferences get() {
        return providesDefaultSharedPerefences(this.module);
    }
}
