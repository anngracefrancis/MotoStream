package cm.aptoide.pt.view;

import cm.aptoide.pt.navigator.ExternalNavigator;
import cm.aptoide.pt.socialmedia.SocialMediaNavigator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvidesSocialMediaNavigatorFactory implements Provider {
    private final Provider<ExternalNavigator> externalNavigatorProvider;
    private final ActivityModule module;

    public ActivityModule_ProvidesSocialMediaNavigatorFactory(ActivityModule activityModule, Provider<ExternalNavigator> provider) {
        this.module = activityModule;
        this.externalNavigatorProvider = provider;
    }

    public static ActivityModule_ProvidesSocialMediaNavigatorFactory create(ActivityModule activityModule, Provider<ExternalNavigator> provider) {
        return new ActivityModule_ProvidesSocialMediaNavigatorFactory(activityModule, provider);
    }

    public static SocialMediaNavigator providesSocialMediaNavigator(ActivityModule activityModule, ExternalNavigator externalNavigator) {
        return (SocialMediaNavigator) f.b.b.c(activityModule.providesSocialMediaNavigator(externalNavigator));
    }

    @Override // javax.inject.Provider
    public SocialMediaNavigator get() {
        return providesSocialMediaNavigator(this.module, this.externalNavigatorProvider.get());
    }
}
