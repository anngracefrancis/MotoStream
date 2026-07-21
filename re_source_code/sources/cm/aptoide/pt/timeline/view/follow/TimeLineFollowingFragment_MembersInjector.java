package cm.aptoide.pt.timeline.view.follow;

import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.fragment.GridRecyclerSwipeWithToolbarFragment_MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class TimeLineFollowingFragment_MembersInjector implements f.a<TimeLineFollowingFragment> {
    private final Provider<String> marketNameProvider;
    private final Provider<ThemeManager> themeManagerProvider;

    public TimeLineFollowingFragment_MembersInjector(Provider<String> provider, Provider<ThemeManager> provider2) {
        this.marketNameProvider = provider;
        this.themeManagerProvider = provider2;
    }

    public static f.a<TimeLineFollowingFragment> create(Provider<String> provider, Provider<ThemeManager> provider2) {
        return new TimeLineFollowingFragment_MembersInjector(provider, provider2);
    }

    public static void injectThemeManager(TimeLineFollowingFragment timeLineFollowingFragment, ThemeManager themeManager) {
        timeLineFollowingFragment.themeManager = themeManager;
    }

    public void injectMembers(TimeLineFollowingFragment timeLineFollowingFragment) {
        GridRecyclerSwipeWithToolbarFragment_MembersInjector.injectMarketName(timeLineFollowingFragment, this.marketNameProvider.get());
        injectThemeManager(timeLineFollowingFragment, this.themeManagerProvider.get());
    }
}
