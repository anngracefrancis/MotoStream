package cm.aptoide.pt.view;

import cm.aptoide.pt.app.AppNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.search.SearchNavigator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvidesSearchNavigatorFactory implements Provider {
    private final Provider<AppNavigator> appNavigatorProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final ActivityModule module;

    public ActivityModule_ProvidesSearchNavigatorFactory(ActivityModule activityModule, Provider<FragmentNavigator> provider, Provider<AppNavigator> provider2) {
        this.module = activityModule;
        this.fragmentNavigatorProvider = provider;
        this.appNavigatorProvider = provider2;
    }

    public static ActivityModule_ProvidesSearchNavigatorFactory create(ActivityModule activityModule, Provider<FragmentNavigator> provider, Provider<AppNavigator> provider2) {
        return new ActivityModule_ProvidesSearchNavigatorFactory(activityModule, provider, provider2);
    }

    public static SearchNavigator providesSearchNavigator(ActivityModule activityModule, FragmentNavigator fragmentNavigator, AppNavigator appNavigator) {
        return (SearchNavigator) f.b.b.c(activityModule.providesSearchNavigator(fragmentNavigator, appNavigator));
    }

    @Override // javax.inject.Provider
    public SearchNavigator get() {
        return providesSearchNavigator(this.module, this.fragmentNavigatorProvider.get(), this.appNavigatorProvider.get());
    }
}
