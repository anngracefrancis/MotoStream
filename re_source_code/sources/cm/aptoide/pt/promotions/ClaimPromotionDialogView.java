package cm.aptoide.pt.promotions;

import android.text.Editable;
import cm.aptoide.pt.navigator.Result;
import cm.aptoide.pt.presenter.View;

/* JADX INFO: loaded from: classes.dex */
public interface ClaimPromotionDialogView extends View {
    rx.e<ClaimPromotionsClickWrapper> continueWalletClick();

    void dismissDialog();

    rx.e<Void> dismissGenericErrorClick();

    rx.e<ClaimDialogResultWrapper> dismissGenericMessage();

    rx.e<e.g.a.d.b> editTextChanges();

    void fetchWalletAddressByClipboard();

    void fetchWalletAddressByIntent();

    rx.e<Result> getActivityResults();

    rx.e<String> getWalletClick();

    void handleEmptyEditText(Editable editable);

    rx.e<Void> onCancelWalletUpdate();

    rx.e<Void> onUpdateWalletClick();

    void sendWalletIntent();

    void showCanceledVerificationError();

    void showClaimSuccess();

    void showGenericError();

    void showInvalidWalletAddress();

    void showLoading();

    void showPromotionAlreadyClaimed();

    void showUpdateWalletDialog();

    void updateWalletText(String str);

    void verifyWallet();

    rx.e<String> walletCancelClick();
}
