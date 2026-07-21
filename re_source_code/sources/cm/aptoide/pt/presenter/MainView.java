package cm.aptoide.pt.presenter;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public interface MainView extends View {
    void dismissAutoUpdateDialog();

    void dismissInstallationError();

    rx.e<Void> getInstallErrorsDismiss();

    Intent getIntentAfterCreate();

    void hideLoadingView();

    rx.e<String> onAuthenticationIntent();

    void showGenericErrorMessage();

    void showInstallationError(int i2);

    void showInstallationSuccessMessage();

    void showLoadingView();

    void showUnknownErrorMessage();

    void showUpdatesBadge(int i2);
}
