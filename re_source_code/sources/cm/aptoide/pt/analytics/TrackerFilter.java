package cm.aptoide.pt.analytics;

import cm.aptoide.analytics.implementation.navigation.ViewNameFilter;
import cm.aptoide.pt.account.view.LoginSignUpCredentialsFragment;
import cm.aptoide.pt.store.view.StoreFragment;
import cm.aptoide.pt.view.wizard.WizardFragment;

/* JADX INFO: loaded from: classes.dex */
public class TrackerFilter implements ViewNameFilter {
    @Override // cm.aptoide.analytics.implementation.navigation.ViewNameFilter
    public boolean filter(String str) {
        return (str.equals(WizardFragment.class.getSimpleName()) || str.equals(LoginSignUpCredentialsFragment.class.getSimpleName()) || str.equals(StoreFragment.class.getSimpleName())) ? false : true;
    }
}
