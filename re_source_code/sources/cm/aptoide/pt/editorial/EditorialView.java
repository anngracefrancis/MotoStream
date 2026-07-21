package cm.aptoide.pt.editorial;

import cm.aptoide.aptoideviews.socialmedia.SocialMediaView;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.reactions.ReactionEvent;
import cm.aptoide.pt.reactions.data.TopReaction;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface EditorialView extends View {
    rx.e<EditorialEvent> actionButtonClicked();

    void addBottomCardAnimation();

    rx.e<EditorialEvent> appCardClicked(EditorialViewModel editorialViewModel);

    rx.e<EditorialDownloadEvent> cancelDownload(EditorialViewModel editorialViewModel);

    String getAction();

    rx.e<Boolean> handleMovingCollapse();

    void hideLoading();

    rx.e<EditorialDownloadEvent> installButtonClick(EditorialViewModel editorialViewModel);

    rx.e<Void> isViewReady();

    void manageMediaListDescriptionAnimationVisibility(EditorialEvent editorialEvent);

    void managePlaceHolderVisibity();

    rx.e<EditorialEvent> mediaContentClicked();

    rx.e<EditorialEvent> mediaListDescriptionChanged();

    void openApp(String str);

    rx.e<EditorialDownloadEvent> pauseDownload(EditorialViewModel editorialViewModel);

    rx.e<ScrollEvent> placeHolderVisibilityChange();

    void populateView(EditorialViewModel editorialViewModel);

    rx.e<ReactionEvent> reactionClicked();

    rx.e<Void> reactionsButtonClicked();

    rx.e<Void> reactionsButtonLongPressed();

    void removeBottomCardAnimation();

    rx.e<EditorialDownloadEvent> resumeDownload(EditorialViewModel editorialViewModel);

    rx.e<Void> retryClicked();

    void setMediaListDescriptionsVisible(EditorialEvent editorialEvent);

    void setUserReaction(String str);

    rx.e<Boolean> showDowngradeMessage();

    void showDowngradingMessage();

    void showDownloadError(EditorialDownloadModel editorialDownloadModel);

    void showDownloadModel(EditorialDownloadModel editorialDownloadModel);

    void showError(EditorialViewModel.Error error);

    void showGenericErrorToast();

    void showLoading();

    void showLoginDialog();

    void showNetworkErrorToast();

    void showReactionsPopup(String str, String str2);

    rx.e<Boolean> showRootInstallWarningPopup();

    void showTopReactions(String str, List<TopReaction> list, int i2);

    rx.e<Void> snackLoginClick();

    rx.e<SocialMediaView.SocialMediaType> socialMediaClick();
}
