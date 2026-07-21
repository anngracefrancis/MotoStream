package cm.aptoide.pt.account.view.store;

import cm.aptoide.pt.bottomNavigation.BottomNavigationNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.navigator.Result;

/* JADX INFO: loaded from: classes.dex */
public class ManageStoreNavigator {
    private final BottomNavigationNavigator bottomNavigationNavigator;
    private final FragmentNavigator fragmentNavigator;

    public ManageStoreNavigator(FragmentNavigator fragmentNavigator, BottomNavigationNavigator bottomNavigationNavigator) {
        this.fragmentNavigator = fragmentNavigator;
        this.bottomNavigationNavigator = bottomNavigationNavigator;
    }

    public void goToHome() {
        this.bottomNavigationNavigator.navigateToHome();
    }

    public void popViewWithResult(int i2, boolean z) {
        this.fragmentNavigator.popWithResult(new Result(i2, z ? -1 : 0, null));
    }
}
