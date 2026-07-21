package cm.aptoide.pt.view;

import android.os.Bundle;
import cm.aptoide.aptoideviews.socialmedia.SocialMediaView;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.CatappultNavigator;
import cm.aptoide.pt.app.view.AppViewFragment;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.socialmedia.SocialMediaNavigator;

/* JADX INFO: loaded from: classes.dex */
public class AppCoinsInfoNavigator {
    private final CatappultNavigator catappultNavigator;
    private final FragmentNavigator fragmentNavigator;
    private final SocialMediaNavigator socialMediaNavigator;

    public AppCoinsInfoNavigator(FragmentNavigator fragmentNavigator, SocialMediaNavigator socialMediaNavigator, CatappultNavigator catappultNavigator) {
        this.fragmentNavigator = fragmentNavigator;
        this.socialMediaNavigator = socialMediaNavigator;
        this.catappultNavigator = catappultNavigator;
    }

    public void navigateToAppCoinsWallet() {
        AppViewFragment appViewFragment = new AppViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppViewFragment.BundleKeys.PACKAGE_NAME.name(), AptoideApplication.APPCOINS_WALLET_PACKAGE_NAME);
        bundle.putString(AppViewFragment.BundleKeys.STORE_NAME.name(), "catappult");
        appViewFragment.setArguments(bundle);
        this.fragmentNavigator.navigateTo(appViewFragment, true);
    }

    public void navigateToCatappultWebsite() {
        this.catappultNavigator.navigateToCatappultWebsite();
    }

    public void navigateToSocialMedia(SocialMediaView.SocialMediaType socialMediaType) {
        this.socialMediaNavigator.navigateToSocialMediaWebsite(socialMediaType);
    }
}
