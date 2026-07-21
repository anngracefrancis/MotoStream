package cm.aptoide.pt.promotions;

import cm.aptoide.pt.presenter.View;

/* JADX INFO: loaded from: classes.dex */
public interface PromotionsView extends View {
    rx.e<PromotionAppClick> appCardClick();

    rx.e<PromotionViewApp> cancelDownload();

    rx.e<PromotionViewApp> claimAppClick();

    rx.e<PromotionViewApp> installButtonClick();

    void lockPromotionApps(boolean z);

    rx.e<PromotionViewApp> pauseDownload();

    rx.e<Void> promotionOverDialogClick();

    rx.e<PromotionViewApp> resumeDownload();

    rx.e<Void> retryClicked();

    void setPromotionMessage(String str);

    void showDownloadError(PromotionViewApp promotionViewApp);

    void showErrorView();

    void showLoading();

    void showPromotionApp(PromotionViewApp promotionViewApp, boolean z);

    void showPromotionFeatureGraphic(String str);

    void showPromotionOverDialog();

    void showPromotionTitle(String str);

    rx.e<Boolean> showRootInstallWarningPopup();

    void updateClaimStatus(String str);
}
