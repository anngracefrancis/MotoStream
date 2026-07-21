package cm.aptoide.pt.view.wizard;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.p;
import cm.aptoide.pt.NavigationTrackerPagerAdapterHelper;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;

/* JADX INFO: loaded from: classes.dex */
public class WizardPagerAdapter extends p implements NavigationTrackerPagerAdapterHelper {
    private final boolean isLoggedIn;
    private final WizardFragmentProvider wizardFragmentProvider;

    public WizardPagerAdapter(FragmentManager fragmentManager, Boolean bool, WizardFragmentProvider wizardFragmentProvider) {
        super(fragmentManager);
        this.isLoggedIn = bool.booleanValue();
        this.wizardFragmentProvider = wizardFragmentProvider;
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        return this.wizardFragmentProvider.getCount(Boolean.valueOf(this.isLoggedIn));
    }

    @Override // androidx.fragment.app.p
    public Fragment getItem(int i2) {
        return this.wizardFragmentProvider.getItem(i2);
    }

    @Override // cm.aptoide.pt.NavigationTrackerPagerAdapterHelper
    public String getItemName(int i2) {
        return getItem(i2).getClass().getSimpleName();
    }

    @Override // cm.aptoide.pt.NavigationTrackerPagerAdapterHelper
    public StoreContext getItemStore() {
        return StoreContext.home;
    }

    @Override // cm.aptoide.pt.NavigationTrackerPagerAdapterHelper
    public String getItemTag(int i2) {
        return String.valueOf(i2);
    }

    public boolean isLoggedIn() {
        return this.isLoggedIn;
    }
}
