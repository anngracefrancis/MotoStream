package cm.aptoide.pt.store.view.my;

import cm.aptoide.pt.bottomNavigation.BottomNavigationItem;
import cm.aptoide.pt.bottomNavigation.BottomNavigationMapper;
import cm.aptoide.pt.home.AptoideBottomNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.view.settings.MyAccountFragment;

/* JADX INFO: loaded from: classes.dex */
public class MyStoresNavigator {
    private final AptoideBottomNavigator aptoideBottomNavigator;
    private final BottomNavigationMapper bottomNavigationMapper;
    private final FragmentNavigator fragmentNavigator;

    public MyStoresNavigator(FragmentNavigator fragmentNavigator, AptoideBottomNavigator aptoideBottomNavigator, BottomNavigationMapper bottomNavigationMapper) {
        this.fragmentNavigator = fragmentNavigator;
        this.aptoideBottomNavigator = aptoideBottomNavigator;
        this.bottomNavigationMapper = bottomNavigationMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bottomNavigationEvent$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean a(Integer num) {
        return Boolean.valueOf(this.bottomNavigationMapper.mapItemClicked(num).equals(BottomNavigationItem.STORES));
    }

    public rx.e<Integer> bottomNavigationEvent() {
        return this.aptoideBottomNavigator.navigationEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.store.view.my.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7654f.a((Integer) obj);
            }
        });
    }

    public void navigateToMyAccount() {
        this.fragmentNavigator.navigateTo(MyAccountFragment.newInstance(), true);
    }
}
