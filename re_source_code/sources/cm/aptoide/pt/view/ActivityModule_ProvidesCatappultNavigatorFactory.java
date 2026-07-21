package cm.aptoide.pt.view;

import cm.aptoide.pt.CatappultNavigator;
import cm.aptoide.pt.navigator.ExternalNavigator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvidesCatappultNavigatorFactory implements Provider {
    private final Provider<ExternalNavigator> externalNavigatorProvider;
    private final ActivityModule module;

    public ActivityModule_ProvidesCatappultNavigatorFactory(ActivityModule activityModule, Provider<ExternalNavigator> provider) {
        this.module = activityModule;
        this.externalNavigatorProvider = provider;
    }

    public static ActivityModule_ProvidesCatappultNavigatorFactory create(ActivityModule activityModule, Provider<ExternalNavigator> provider) {
        return new ActivityModule_ProvidesCatappultNavigatorFactory(activityModule, provider);
    }

    public static CatappultNavigator providesCatappultNavigator(ActivityModule activityModule, ExternalNavigator externalNavigator) {
        return (CatappultNavigator) f.b.b.c(activityModule.providesCatappultNavigator(externalNavigator));
    }

    @Override // javax.inject.Provider
    public CatappultNavigator get() {
        return providesCatappultNavigator(this.module, this.externalNavigatorProvider.get());
    }
}
