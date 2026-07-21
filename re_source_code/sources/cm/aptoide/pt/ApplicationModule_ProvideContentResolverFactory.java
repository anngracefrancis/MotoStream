package cm.aptoide.pt;

import android.content.ContentResolver;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideContentResolverFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideContentResolverFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideContentResolverFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideContentResolverFactory(applicationModule);
    }

    public static ContentResolver provideContentResolver(ApplicationModule applicationModule) {
        return (ContentResolver) f.b.b.c(applicationModule.provideContentResolver());
    }

    @Override // javax.inject.Provider
    public ContentResolver get() {
        return provideContentResolver(this.module);
    }
}
