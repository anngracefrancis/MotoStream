package cm.aptoide.pt.timeline.view.follow;

import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.fragment.GridRecyclerSwipeWithToolbarFragment_MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class TimeLineFollowersFragment_MembersInjector implements f.a<TimeLineFollowersFragment> {
    private final Provider<String> marketNameProvider;
    private final Provider<ThemeManager> themeManagerProvider;

    public TimeLineFollowersFragment_MembersInjector(Provider<String> provider, Provider<ThemeManager> provider2) {
        this.marketNameProvider = provider;
        this.themeManagerProvider = provider2;
    }

    public static f.a<TimeLineFollowersFragment> create(Provider<String> provider, Provider<ThemeManager> provider2) {
        return new TimeLineFollowersFragment_MembersInjector(provider, provider2);
    }

    public static void injectThemeManager(TimeLineFollowersFragment timeLineFollowersFragment, ThemeManager themeManager) {
        timeLineFollowersFragment.themeManager = themeManager;
    }

    public void injectMembers(TimeLineFollowersFragment timeLineFollowersFragment) {
        GridRecyclerSwipeWithToolbarFragment_MembersInjector.injectMarketName(timeLineFollowersFragment, this.marketNameProvider.get());
        injectThemeManager(timeLineFollowersFragment, this.themeManagerProvider.get());
    }
}
