package cm.aptoide.pt.editorialList;

import android.os.Bundle;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.editorial.EditorialFragment;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.view.settings.MyAccountFragment;

/* JADX INFO: loaded from: classes.dex */
public class EditorialListNavigator {
    private final AccountNavigator accountNavigator;
    private final FragmentNavigator fragmentNavigator;

    public EditorialListNavigator(FragmentNavigator fragmentNavigator, AccountNavigator accountNavigator) {
        this.fragmentNavigator = fragmentNavigator;
        this.accountNavigator = accountNavigator;
    }

    public void navigateToEditorial(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("cardId", str);
        bundle.putBoolean(EditorialFragment.FROM_HOME, false);
        EditorialFragment editorialFragment = new EditorialFragment();
        editorialFragment.setArguments(bundle);
        this.fragmentNavigator.navigateTo(editorialFragment, true);
    }

    public void navigateToLogIn() {
        this.accountNavigator.navigateToAccountView(AccountAnalytics.AccountOrigins.EDITORIAL);
    }

    public void navigateToMyAccount() {
        this.fragmentNavigator.navigateTo(MyAccountFragment.newInstance(), true);
    }
}
