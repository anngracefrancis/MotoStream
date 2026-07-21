package cm.aptoide.pt.view.settings;

import cm.aptoide.accountmanager.Account;
import cm.aptoide.aptoideviews.socialmedia.SocialMediaView;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStore;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.presenter.View;

/* JADX INFO: loaded from: classes.dex */
public interface MyAccountView extends View {
    rx.e<Void> aptoideBackupCardViewClick();

    rx.e<Void> aptoideTvCardViewClick();

    rx.e<Void> aptoideUploaderCardViewClick();

    rx.e<Void> createStoreClick();

    rx.e<Void> editStoreClick();

    rx.e<Void> editUserProfileClick();

    rx.e<GetStore> getStore();

    rx.e<Void> loginClick();

    void refreshUI(Store store);

    rx.e<Void> settingsClicked();

    void showAccount(Account account);

    void showLoginAccountDisplayable();

    rx.e<Void> signOutClick();

    rx.e<SocialMediaView.SocialMediaType> socialMediaClick();

    void startAptoideTvWebView();

    rx.e<Void> storeClick();

    rx.e<Void> userClick();
}
