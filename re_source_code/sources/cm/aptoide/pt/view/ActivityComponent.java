package cm.aptoide.pt.view;

import cm.aptoide.pt.FlavourFragmentModule;
import cm.aptoide.pt.analytics.view.AnalyticsActivity;
import cm.aptoide.pt.bottomNavigation.BottomNavigationActivity;
import cm.aptoide.pt.navigator.ActivityResultNavigator;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import cm.aptoide.pt.view.dialog.DialogUtils;
import cm.aptoide.pt.view.fragment.BaseBottomSheetDialogFragment;
import cm.aptoide.pt.view.fragment.BaseDialogFragment;
import cm.aptoide.pt.view.settings.SettingsFragment;
import cm.aptoide.pt.wallet.WalletInstallActivity;

/* JADX INFO: loaded from: classes.dex */
@ActivityScope
public interface ActivityComponent {
    void inject(AnalyticsActivity analyticsActivity);

    void inject(BottomNavigationActivity bottomNavigationActivity);

    void inject(ActivityResultNavigator activityResultNavigator);

    void inject(StoreTabGridRecyclerFragment storeTabGridRecyclerFragment);

    void inject(BaseActivity baseActivity);

    void inject(MainActivity mainActivity);

    void inject(ThemedActivityView themedActivityView);

    void inject(DialogUtils dialogUtils);

    void inject(BaseBottomSheetDialogFragment baseBottomSheetDialogFragment);

    void inject(BaseDialogFragment baseDialogFragment);

    void inject(SettingsFragment settingsFragment);

    void inject(WalletInstallActivity walletInstallActivity);

    FragmentComponent plus(FragmentModule fragmentModule, FlavourFragmentModule flavourFragmentModule);
}
