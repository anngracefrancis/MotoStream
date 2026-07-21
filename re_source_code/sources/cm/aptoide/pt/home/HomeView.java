package cm.aptoide.pt.home;

import cm.aptoide.pt.home.apps.BundleView;
import cm.aptoide.pt.home.bundles.HomeBundlesModel;
import cm.aptoide.pt.home.bundles.base.AppComingSoonPromotionalBundle;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import cm.aptoide.pt.home.bundles.editorial.EditorialHomeEvent;
import cm.aptoide.pt.reactions.ReactionsHomeEvent;

/* JADX INFO: loaded from: classes.dex */
public interface HomeView extends BundleView {
    rx.e<HomeEvent> cancelNotifyMeClicked();

    rx.e<HomeEvent> dismissBundleClicked();

    rx.e<EditorialHomeEvent> editorialCardClicked();

    void hideBundle(int i2);

    rx.e<Void> imageClick();

    rx.e<HomeEvent> infoBundleKnowMoreClicked();

    rx.e<HomeEvent> notifyMeClicked();

    rx.e<HomeEvent> onLoadMoreRetryClicked();

    rx.e<EditorialHomeEvent> reactionButtonLongPress();

    rx.e<ReactionsHomeEvent> reactionClicked();

    rx.e<EditorialHomeEvent> reactionsButtonClicked();

    void removeLoadMoreError();

    void scrollToTop();

    void sendDeeplinkToWalletAppView(String str);

    void setAdsTest(boolean z);

    void setUserImage(String str);

    void showBundlesSkeleton(HomeBundlesModel homeBundlesModel);

    void showConsentDialog();

    void showGenericErrorToast();

    void showLoadMoreError();

    void showLogInDialog();

    void showNetworkErrorToast();

    void showReactionsPopup(String str, String str2, int i2);

    rx.e<Void> snackLogInClick();

    void updateAppComingSoonStatus(AppComingSoonPromotionalBundle appComingSoonPromotionalBundle, boolean z);

    rx.e<HomeEvent> walletOfferCardInstallWalletClick();
}
