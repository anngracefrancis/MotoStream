package cm.aptoide.pt.view;

import cm.aptoide.pt.app.AppNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.promotions.PromotionsNavigator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvidesPromotionsNavigatorFactory implements Provider {
    private final Provider<AppNavigator> appNavigatorProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final ActivityModule module;

    public ActivityModule_ProvidesPromotionsNavigatorFactory(ActivityModule activityModule, Provider<FragmentNavigator> provider, Provider<AppNavigator> provider2) {
        this.module = activityModule;
        this.fragmentNavigatorProvider = provider;
        this.appNavigatorProvider = provider2;
    }

    public static ActivityModule_ProvidesPromotionsNavigatorFactory create(ActivityModule activityModule, Provider<FragmentNavigator> provider, Provider<AppNavigator> provider2) {
        return new ActivityModule_ProvidesPromotionsNavigatorFactory(activityModule, provider, provider2);
    }

    public static PromotionsNavigator providesPromotionsNavigator(ActivityModule activityModule, FragmentNavigator fragmentNavigator, AppNavigator appNavigator) {
        return (PromotionsNavigator) f.b.b.c(activityModule.providesPromotionsNavigator(fragmentNavigator, appNavigator));
    }

    @Override // javax.inject.Provider
    public PromotionsNavigator get() {
        return providesPromotionsNavigator(this.module, this.fragmentNavigatorProvider.get(), this.appNavigatorProvider.get());
    }
}
