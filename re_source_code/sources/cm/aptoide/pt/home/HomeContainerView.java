package cm.aptoide.pt.home;

import cm.aptoide.pt.presenter.View;

/* JADX INFO: loaded from: classes.dex */
public interface HomeContainerView extends View {
    rx.e<Boolean> appsChipClicked();

    void dismissPromotionsDialog();

    void expandChips();

    rx.e<Boolean> gamesChipClicked();

    rx.e<String> gdprDialogClicked();

    void hidePromotionsIcon();

    rx.e<HomeContainerFragment.ChipsEvents> isChipChecked();

    rx.e<String> promotionsHomeDialogClicked();

    void setDefaultUserImage();

    void setUserImage(String str);

    void showAvatar();

    void showPromotionsHomeDialog(HomePromotionsWrapper homePromotionsWrapper);

    void showPromotionsHomeIcon(HomePromotionsWrapper homePromotionsWrapper);

    void showTermsAndConditionsDialog();

    rx.e<Void> toolbarPromotionsClick();

    rx.e<Void> toolbarUserClick();

    void uncheckChips();
}
