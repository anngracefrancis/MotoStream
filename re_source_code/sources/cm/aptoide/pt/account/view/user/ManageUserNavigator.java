package cm.aptoide.pt.account.view.user;

import cm.aptoide.pt.bottomNavigation.BottomNavigationNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;

/* JADX INFO: loaded from: classes.dex */
public class ManageUserNavigator {
    private final BottomNavigationNavigator bottomNavigationNavigator;
    private final FragmentNavigator navigator;

    public ManageUserNavigator(FragmentNavigator fragmentNavigator, BottomNavigationNavigator bottomNavigationNavigator) {
        this.navigator = fragmentNavigator;
        this.bottomNavigationNavigator = bottomNavigationNavigator;
    }

    public void goBack() {
        this.navigator.popBackStack();
    }

    public void goToHome() {
        this.bottomNavigationNavigator.navigateToHome();
    }

    public void toProfileStepOne() {
        this.navigator.cleanBackStack();
        this.navigator.navigateTo(ProfileStepOneFragment.newInstance(), true);
    }
}
