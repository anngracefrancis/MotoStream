package cm.aptoide.pt.account.view.user;

import cm.aptoide.pt.presenter.View;

/* JADX INFO: loaded from: classes.dex */
interface ProfileStepTwoView extends View {
    rx.e<Boolean> continueButtonClick();

    void dismissWaitDialog();

    rx.e<Boolean> makePrivateProfileButtonClick();

    rx.b showGenericErrorMessage();

    void showWaitDialog();
}
