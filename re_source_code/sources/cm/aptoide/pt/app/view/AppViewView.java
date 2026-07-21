package cm.aptoide.pt.app.view;

import android.util.Pair;
import android.view.MenuItem;
import cm.aptoide.pt.app.AppModel;
import cm.aptoide.pt.app.DownloadModel;
import cm.aptoide.pt.app.ReviewsViewModel;
import cm.aptoide.pt.app.view.screenshots.ScreenShotClickEvent;
import cm.aptoide.pt.app.view.similar.SimilarAppClickEvent;
import cm.aptoide.pt.app.view.similar.SimilarAppsBundle;
import cm.aptoide.pt.appview.InstallAppView;
import cm.aptoide.pt.bonus.BonusAppcModel;
import cm.aptoide.pt.promotions.Promotion;
import cm.aptoide.pt.promotions.WalletApp;
import cm.aptoide.pt.search.model.SearchAdResult;
import cm.aptoide.pt.utils.GenericDialogs;
import cm.aptoide.pt.view.app.DetailedAppRequestResult;
import cm.aptoide.pt.view.app.FlagsVote;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface AppViewView extends InstallAppView {
    rx.e<String> apkfyDialogPositiveClick();

    rx.e<WalletApp> cancelPromotionDownload();

    rx.e<Promotion> claimAppClick();

    rx.e<Void> clickBonusAppcFlair();

    rx.e<Void> clickCatappultCard();

    rx.e<Void> clickDeveloperEmail();

    rx.e<Void> clickDeveloperPermissions();

    rx.e<Void> clickDeveloperPrivacy();

    rx.e<Void> clickDeveloperWebsite();

    rx.e<Void> clickErrorRetry();

    rx.e<FlagsVote.VoteType> clickFakeFlag();

    rx.e<Void> clickFollowStore();

    rx.e<Void> clickGetAppcInfo();

    rx.e<FlagsVote.VoteType> clickLicenseFlag();

    rx.e<Void> clickLoginSnack();

    rx.e<Void> clickOtherVersions();

    rx.e<Void> clickRateApp();

    rx.e<Void> clickRateAppLarge();

    rx.e<Void> clickRateAppLayout();

    rx.e<Void> clickReadAllReviews();

    rx.e<Void> clickReviewsLayout();

    rx.e<SimilarAppClickEvent> clickSimilarApp();

    rx.e<Void> clickStoreLayout();

    rx.e<MenuItem> clickToolbar();

    rx.e<Void> clickTrustedBadge();

    rx.e<FlagsVote.VoteType> clickVirusFlag();

    rx.e<FlagsVote.VoteType> clickWorkingFlag();

    rx.e<ReadMoreClickEvent> clickedReadMore();

    void defaultShare(String str, String str2);

    void disableFlags();

    rx.e<Promotion> dismissWalletPromotionClick();

    void dismissWalletPromotionView();

    void displayNotLoggedInSnack();

    void displayStoreFollowedSnack(String str);

    void enableFlags();

    void extractReferrer(SearchAdResult searchAdResult);

    String getLanguageFilter();

    rx.e<ScreenShotClickEvent> getScreenshotClickEvent();

    void handleError(DetailedAppRequestResult.Error error);

    void hideReviews();

    void hideSimilarApps();

    rx.e<Void> iabInfoClick();

    void incrementFlags(FlagsVote.VoteType voteType);

    rx.e<Pair<Promotion, WalletApp>> installWalletButtonClick();

    boolean isSimilarAppsVisible();

    void navigateToDeveloperEmail(AppModel appModel);

    void navigateToDeveloperPermissions(AppModel appModel);

    void navigateToDeveloperPrivacy(AppModel appModel);

    void navigateToDeveloperWebsite(AppModel appModel);

    rx.e<WalletApp> pausePromotionDownload();

    void populateReviews(ReviewsViewModel reviewsViewModel, AppModel appModel);

    void populateSimilar(List<SimilarAppsBundle> list);

    void recoverScrollViewState();

    rx.e<WalletApp> resumePromotionDownload();

    void scrollReviews(Integer num);

    rx.e<Integer> scrollReviewsResponse();

    rx.e<e.g.a.c.f> scrollVisibleSimilarApps();

    void setFollowButton(boolean z);

    void setInstallButton(AppCoinsViewModel appCoinsViewModel);

    void setupAppcAppView(boolean z, BonusAppcModel bonusAppcModel);

    void showApkfyElement(String str);

    void showAppView(AppModel appModel);

    void showAppcWalletPromotionView(Promotion promotion, WalletApp walletApp, Promotion.ClaimAction claimAction, DownloadModel downloadModel);

    void showDownloadError(DownloadModel downloadModel);

    void showDownloadingSimilarApps(boolean z);

    void showFlagVoteSubmittedMessage();

    void showLoading();

    rx.e<Void> showOpenAndInstallApkFyDialog(String str, String str2, double d2, float f2, String str3, int i2);

    rx.e<Void> showOpenAndInstallDialog(String str, String str2);

    rx.e<GenericDialogs.EResponse> showRateDialog(String str, String str2, String str3);

    void showShareOnTvDialog(long j2);

    void showTrustedDialog(AppModel appModel);

    rx.e<Boolean> similarAppsVisibilityFromInstallClick();
}
