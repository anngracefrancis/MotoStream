package cm.aptoide.pt.view;

import cm.aptoide.pt.bottomNavigation.BottomNavigationMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvideBottomNavigationMapperFactory implements Provider {
    private final ActivityModule module;

    public ActivityModule_ProvideBottomNavigationMapperFactory(ActivityModule activityModule) {
        this.module = activityModule;
    }

    public static ActivityModule_ProvideBottomNavigationMapperFactory create(ActivityModule activityModule) {
        return new ActivityModule_ProvideBottomNavigationMapperFactory(activityModule);
    }

    public static BottomNavigationMapper provideBottomNavigationMapper(ActivityModule activityModule) {
        return (BottomNavigationMapper) f.b.b.c(activityModule.provideBottomNavigationMapper());
    }

    @Override // javax.inject.Provider
    public BottomNavigationMapper get() {
        return provideBottomNavigationMapper(this.module);
    }
}
