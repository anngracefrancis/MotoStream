package cm.aptoide.pt.view.settings;

import cm.aptoide.aptoideviews.socialmedia.SocialMediaView;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.account.view.store.ManageStoreFragment;
import cm.aptoide.pt.account.view.store.ManageStoreViewModel;
import cm.aptoide.pt.account.view.user.ManageUserFragment;
import cm.aptoide.pt.app.AppNavigator;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.navigator.Result;
import cm.aptoide.pt.socialmedia.SocialMediaNavigator;
import cm.aptoide.pt.store.view.StoreFragment;
import cm.aptoide.pt.themes.ThemeManager;

/* JADX INFO: loaded from: classes.dex */
public class MyAccountNavigator {
    private final AppNavigator appNavigator;
    private final FragmentNavigator fragmentNavigator;
    private final AccountNavigator navigator;
    private final SocialMediaNavigator socialMediaNavigator;
    private final ThemeManager themeManager;
    private final String UPLOADER_UNAME = "aptoide-uploader";
    private final String BACKUP_APPS_UNAME = "aptoide-backup-apps";

    public MyAccountNavigator(FragmentNavigator fragmentNavigator, AccountNavigator accountNavigator, AppNavigator appNavigator, ThemeManager themeManager, SocialMediaNavigator socialMediaNavigator) {
        this.fragmentNavigator = fragmentNavigator;
        this.navigator = accountNavigator;
        this.appNavigator = appNavigator;
        this.themeManager = themeManager;
        this.socialMediaNavigator = socialMediaNavigator;
    }

    public rx.e<Boolean> editStoreResult(int i2) {
        return this.fragmentNavigator.results(i2).X(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Result) obj).getResultCode() == -1);
            }
        });
    }

    public void navigateToAppView(String str) {
        this.appNavigator.navigateWithUname(str);
    }

    public void navigateToBackupApps() {
        this.appNavigator.navigateWithUname("aptoide-backup-apps");
    }

    public void navigateToCreateStore() {
        this.fragmentNavigator.navigateTo(ManageStoreFragment.newInstance(new ManageStoreViewModel(), false), true);
    }

    public void navigateToEditProfileView() {
        this.fragmentNavigator.navigateTo(ManageUserFragment.newInstanceToEdit(), true);
    }

    public void navigateToEditStoreView(Store store, int i2) {
        this.fragmentNavigator.navigateForResult(ManageStoreFragment.newInstance(new ManageStoreViewModel(store.getId(), this.themeManager.getStoreTheme(store.getAppearance().getTheme()), store.getName(), store.getAppearance().getDescription(), store.getAvatar()), false), i2, true);
    }

    public void navigateToLoginView(AccountAnalytics.AccountOrigins accountOrigins) {
        this.navigator.navigateToAccountView(accountOrigins);
    }

    public void navigateToSettings() {
        this.fragmentNavigator.navigateTo(SettingsFragment.newInstance(), true);
    }

    public void navigateToSocialMedia(SocialMediaView.SocialMediaType socialMediaType) {
        this.socialMediaNavigator.navigateToSocialMediaWebsite(socialMediaType);
    }

    public void navigateToStoreView(String str, String str2) {
        this.fragmentNavigator.navigateTo(StoreFragment.newInstance(str, str2, StoreFragment.OpenType.GetStore), true);
    }

    public void navigateToUploader() {
        this.appNavigator.navigateWithUname("aptoide-uploader");
    }

    public void navigateToUserView(String str, String str2) {
        this.fragmentNavigator.navigateTo(StoreFragment.newInstance(str, str2, StoreFragment.OpenType.GetHome), true);
    }
}
