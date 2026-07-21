package cm.aptoide.pt.app.view;

import cm.aptoide.aptoideviews.socialmedia.SocialMediaView;
import cm.aptoide.pt.editorial.ScrollEvent;
import cm.aptoide.pt.presenter.View;

/* JADX INFO: loaded from: classes.dex */
public interface AppCoinsInfoView extends View {
    void addBottomCardAnimation();

    rx.e<Void> appCoinsWalletLinkClick();

    rx.e<ScrollEvent> appItemVisibilityChanged();

    rx.e<Void> cardViewClick();

    rx.e<Void> catappultButtonClick();

    rx.e<Void> installButtonClick();

    void openApp(String str);

    void removeBottomCardAnimation();

    void setBonusAppc(int i2);

    void setButtonText(boolean z);

    void setNoBonusAppcView();

    rx.e<SocialMediaView.SocialMediaType> socialMediaClick();
}
