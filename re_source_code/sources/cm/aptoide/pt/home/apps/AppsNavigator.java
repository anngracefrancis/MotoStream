package cm.aptoide.pt.home.apps;

import cm.aptoide.pt.app.AppNavigator;
import cm.aptoide.pt.app.view.AppViewFragment;
import cm.aptoide.pt.bottomNavigation.BottomNavigationItem;
import cm.aptoide.pt.bottomNavigation.BottomNavigationMapper;
import cm.aptoide.pt.home.AptoideBottomNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.view.settings.MyAccountFragment;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class AppsNavigator {
    private final AppNavigator appNavigator;
    private final AptoideBottomNavigator aptoideBottomNavigator;
    private final BottomNavigationMapper bottomNavigationMapper;
    private final FragmentNavigator fragmentNavigator;

    public AppsNavigator(FragmentNavigator fragmentNavigator, AptoideBottomNavigator aptoideBottomNavigator, BottomNavigationMapper bottomNavigationMapper, AppNavigator appNavigator) {
        this.fragmentNavigator = fragmentNavigator;
        this.aptoideBottomNavigator = aptoideBottomNavigator;
        this.bottomNavigationMapper = bottomNavigationMapper;
        this.appNavigator = appNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bottomNavigation$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean a(Integer num) {
        return Boolean.valueOf(this.bottomNavigationMapper.mapItemClicked(num).equals(BottomNavigationItem.APPS));
    }

    public rx.e<Integer> bottomNavigation() {
        return this.aptoideBottomNavigator.navigationEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.t0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5805f.a((Integer) obj);
            }
        });
    }

    public void navigateToAppView(long j2, String str) {
        this.appNavigator.navigateWithAppId(j2, str, AppViewFragment.OpenType.OPEN_ONLY, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public void navigateToMyAccount() {
        this.fragmentNavigator.navigateTo(MyAccountFragment.newInstance(), true);
    }

    public void navigateToAppView(String str) {
        this.appNavigator.navigateWithMd5(str);
    }
}
