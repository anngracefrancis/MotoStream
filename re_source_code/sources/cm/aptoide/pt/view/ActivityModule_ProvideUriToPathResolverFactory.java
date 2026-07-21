package cm.aptoide.pt.view;

import cm.aptoide.pt.account.view.UriToPathResolver;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvideUriToPathResolverFactory implements Provider {
    private final ActivityModule module;

    public ActivityModule_ProvideUriToPathResolverFactory(ActivityModule activityModule) {
        this.module = activityModule;
    }

    public static ActivityModule_ProvideUriToPathResolverFactory create(ActivityModule activityModule) {
        return new ActivityModule_ProvideUriToPathResolverFactory(activityModule);
    }

    public static UriToPathResolver provideUriToPathResolver(ActivityModule activityModule) {
        return (UriToPathResolver) f.b.b.c(activityModule.provideUriToPathResolver());
    }

    @Override // javax.inject.Provider
    public UriToPathResolver get() {
        return provideUriToPathResolver(this.module);
    }
}
