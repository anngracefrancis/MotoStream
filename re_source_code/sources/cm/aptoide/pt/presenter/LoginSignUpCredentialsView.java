package cm.aptoide.pt.presenter;

import android.content.Context;
import cm.aptoide.pt.account.view.GooglePlayServicesView;

/* JADX INFO: loaded from: classes.dex */
public interface LoginSignUpCredentialsView extends GooglePlayServicesView {
    void dismiss();

    Context getApplicationContext();

    rx.e<Boolean> googleSignUpEvent();

    void hideGoogleLogin();

    void hideKeyboard();

    void hideLoading();

    void lockScreenRotation();

    rx.e<Void> privacyPolicyClickEvent();

    void setCobrandText();

    void showAptoideLoginArea();

    rx.e<Boolean> showAptoideLoginAreaClick();

    void showError(String str);

    void showGoogleLogin();

    void showLoading();

    void showMagicLinkError(String str);

    void showTCandPP();

    void showTermsConditionError();

    rx.e<Void> termsAndConditionsClickEvent();

    boolean tryCloseLoginBottomSheet(boolean z);

    void unlockScreenRotation();
}
