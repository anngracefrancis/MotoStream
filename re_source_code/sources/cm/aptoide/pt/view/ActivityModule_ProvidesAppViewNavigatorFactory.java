package cm.aptoide.pt.view;

import cm.aptoide.pt.CatappultNavigator;
import cm.aptoide.pt.app.AppNavigator;
import cm.aptoide.pt.app.view.AppViewNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvidesAppViewNavigatorFactory implements Provider {
    private final Provider<AppNavigator> appNavigatorProvider;
    private final Provider<CatappultNavigator> catappultNavigatorProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final ActivityModule module;

    public ActivityModule_ProvidesAppViewNavigatorFactory(ActivityModule activityModule, Provider<FragmentNavigator> provider, Provider<AppNavigator> provider2, Provider<CatappultNavigator> provider3) {
        this.module = activityModule;
        this.fragmentNavigatorProvider = provider;
        this.appNavigatorProvider = provider2;
        this.catappultNavigatorProvider = provider3;
    }

    public static ActivityModule_ProvidesAppViewNavigatorFactory create(ActivityModule activityModule, Provider<FragmentNavigator> provider, Provider<AppNavigator> provider2, Provider<CatappultNavigator> provider3) {
        return new ActivityModule_ProvidesAppViewNavigatorFactory(activityModule, provider, provider2, provider3);
    }

    public static AppViewNavigator providesAppViewNavigator(ActivityModule activityModule, FragmentNavigator fragmentNavigator, AppNavigator appNavigator, CatappultNavigator catappultNavigator) {
        return (AppViewNavigator) f.b.b.c(activityModule.providesAppViewNavigator(fragmentNavigator, appNavigator, catappultNavigator));
    }

    @Override // javax.inject.Provider
    public AppViewNavigator get() {
        return providesAppViewNavigator(this.module, this.fragmentNavigatorProvider.get(), this.appNavigatorProvider.get(), this.catappultNavigatorProvider.get());
    }
}
