package cm.aptoide.pt.view;

import cm.aptoide.pt.app.AppNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvidesAppNavigatorFactory implements Provider {
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final ActivityModule module;

    public ActivityModule_ProvidesAppNavigatorFactory(ActivityModule activityModule, Provider<FragmentNavigator> provider) {
        this.module = activityModule;
        this.fragmentNavigatorProvider = provider;
    }

    public static ActivityModule_ProvidesAppNavigatorFactory create(ActivityModule activityModule, Provider<FragmentNavigator> provider) {
        return new ActivityModule_ProvidesAppNavigatorFactory(activityModule, provider);
    }

    public static AppNavigator providesAppNavigator(ActivityModule activityModule, FragmentNavigator fragmentNavigator) {
        return (AppNavigator) f.b.b.c(activityModule.providesAppNavigator(fragmentNavigator));
    }

    @Override // javax.inject.Provider
    public AppNavigator get() {
        return providesAppNavigator(this.module, this.fragmentNavigatorProvider.get());
    }
}
