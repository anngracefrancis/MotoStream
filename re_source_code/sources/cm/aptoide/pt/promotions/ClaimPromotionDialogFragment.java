package cm.aptoide.pt.promotions;

import android.content.ClipboardManager;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.navigator.ActivityResultNavigator;
import cm.aptoide.pt.navigator.Result;
import cm.aptoide.pt.networking.IdsRepository;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.view.fragment.BaseDialogView;
import javax.inject.Inject;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class ClaimPromotionDialogFragment extends BaseDialogView implements ClaimPromotionDialogView {
    private static final String CLAIMED = "claimed";
    private static final String GENERIC_ERROR = "error";
    private static final String PACKAGE_NAME = "package_name";
    private static final String SUCCESS = "success";
    private static final String VIEW = "view";
    private static final String WALLET = "wallet";
    private static final String WALLET_PERMISSIONS_INTENT_EXTRA_KEY = "PERMISSION_NAME_KEY";
    private static final String WALLET_PERMISSIONS_INTENT_EXTRA_VALUE = "WALLET_ADDRESS";
    protected static final int WALLET_PERMISSIONS_INTENT_REQUEST_CODE = 123;
    private static final String WALLET_PERMISSIONS_INTENT_URI_ACTION = "appcoins://wallet/permissions/1";
    protected static final int WALLET_VERIFICATION_INTENT_REQUEST_CODE = 124;
    private static final String WALLET_VERIFICATION_INTENT_URI_ACTION = "appcoins://wallet/validation/1";
    private Button cancelUpdateWalletButton;

    @Inject
    ClaimPromotionsManager claimPromotionsManager;
    private ClipboardManager clipboard;
    private Button genericErrorOkButton;
    private View genericErrorView;
    private TextView genericErrorViewMessage;
    private TextView genericMessageBody;
    private TextView genericMessageButton;
    private TextView genericMessageTitle;
    private View genericMessageView;
    private Button getWalletAddressButton;

    @Inject
    IdsRepository idsRepository;
    private View insertWalletView;
    private ProgressBar loading;

    @Inject
    ClaimPromotionsNavigator navigator;

    @Inject
    ClaimPromotionDialogPresenter presenter;

    @Inject
    PromotionsAnalytics promotionsAnalytics;
    private Button updateWalletButton;
    private View updateWalletView;
    private EditText walletAddressEdit;
    private Button walletCancelButton;
    private View walletErrorView;
    private ImageView walletMessageIcon;
    private Button walletNextButton;

    private void disableNextButton() {
        this.walletNextButton.setClickable(false);
        this.walletNextButton.setFocusable(false);
        this.walletNextButton.setTextColor(getResources().getColor(R.color.grey_fog_light));
    }

    private void disableWalletButton() {
        this.getWalletAddressButton.setClickable(false);
        this.getWalletAddressButton.setFocusable(false);
        this.getWalletAddressButton.setBackgroundColor(this.themeManager.getAttributeForTheme(R.attr.lockedWalletButtonColor).data);
    }

    private void enableNextButton() {
        this.walletNextButton.setClickable(true);
        this.walletNextButton.setFocusable(true);
        this.walletNextButton.setTextColor(this.themeManager.getAttributeForTheme(R.attr.colorPrimaryDark).data);
    }

    private void enableWalletButton() {
        this.getWalletAddressButton.setClickable(true);
        this.getWalletAddressButton.setFocusable(true);
        this.getWalletAddressButton.setBackgroundResource(R.drawable.aptoide_gradient);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void handleRestoreViewState(Bundle bundle) {
        if (bundle == null || bundle.getString(VIEW) == null) {
            return;
        }
        String string = bundle.getString(VIEW);
        byte b2 = -1;
        switch (string.hashCode()) {
            case -1867169789:
                if (string.equals("success")) {
                    b2 = 3;
                }
                break;
            case -795192327:
                if (string.equals(WALLET)) {
                    b2 = 1;
                }
                break;
            case 96784904:
                if (string.equals(GENERIC_ERROR)) {
                    b2 = 4;
                }
                break;
            case 853317083:
                if (string.equals(CLAIMED)) {
                    b2 = 2;
                }
                break;
        }
        if (b2 == 2) {
            showPromotionAlreadyClaimed();
            return;
        }
        if (b2 == 3) {
            showClaimSuccess();
        } else if (b2 != 4) {
            showWalletView();
        } else {
            showGenericError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$continueWalletClick$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ ClaimPromotionsClickWrapper e(Void r4) {
        return new ClaimPromotionsClickWrapper(this.walletAddressEdit.getText().toString(), getArguments().getString("package_name"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$dismissGenericMessage$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ ClaimDialogResultWrapper f(Void r3) {
        return this.genericMessageTitle.getText().equals(getResources().getString(R.string.holidayspromotion_title_completed)) ? new ClaimDialogResultWrapper(getArguments().getString("package_name"), true) : new ClaimDialogResultWrapper(getArguments().getString("package_name"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getWalletClick$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String g(Void r2) {
        return getArguments().getString("package_name");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$walletCancelClick$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String h(Void r2) {
        return getArguments().getString("package_name");
    }

    private void setInvalidWalletMessage() {
        this.walletMessageIcon.setImageDrawable(getResources().getDrawable(R.drawable.ic_info));
    }

    private void setValidWalletMessage() {
        this.walletMessageIcon.setImageDrawable(getResources().getDrawable(R.drawable.ic_check_green));
    }

    private void showErrorView(String str) {
        this.loading.setVisibility(8);
        this.genericErrorView.setVisibility(0);
        this.insertWalletView.setVisibility(8);
        this.updateWalletView.setVisibility(8);
        this.genericMessageView.setVisibility(8);
        this.genericErrorViewMessage.setText(str);
    }

    private void showGenericMessageView(String str, String str2) {
        this.walletErrorView.setVisibility(8);
        this.loading.setVisibility(8);
        this.insertWalletView.setVisibility(8);
        this.updateWalletView.setVisibility(8);
        this.genericMessageTitle.setText(str);
        this.genericMessageBody.setText(str2);
        this.genericMessageView.setVisibility(0);
    }

    private void showWalletView() {
        this.walletErrorView.setVisibility(8);
        this.loading.setVisibility(8);
        this.genericMessageView.setVisibility(8);
        this.insertWalletView.setVisibility(0);
        this.updateWalletView.setVisibility(8);
    }

    private boolean validateAddress(String str) {
        if (str != null) {
            return str.matches("(^(0x))([0-9a-f]{40})$");
        }
        return false;
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public rx.e<ClaimPromotionsClickWrapper> continueWalletClick() {
        return e.g.a.c.a.a(this.walletNextButton).X(new rx.m.e() { // from class: cm.aptoide.pt.promotions.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7005f.e((Void) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public void dismissDialog() {
        dismiss();
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public rx.e<Void> dismissGenericErrorClick() {
        return e.g.a.c.a.a(this.genericErrorOkButton);
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public rx.e<ClaimDialogResultWrapper> dismissGenericMessage() {
        return e.g.a.c.a.a(this.genericMessageButton).X(new rx.m.e() { // from class: cm.aptoide.pt.promotions.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6985f.f((Void) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public rx.e<e.g.a.d.b> editTextChanges() {
        return e.g.a.d.a.a(this.walletAddressEdit);
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public void fetchWalletAddressByClipboard() {
        if (this.clipboard.hasPrimaryClip() && this.clipboard.getPrimaryClipDescription().hasMimeType("text/plain")) {
            updateWalletText(this.clipboard.getPrimaryClip().getItemAt(0).getText().toString());
        }
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public void fetchWalletAddressByIntent() {
        if (this.walletErrorView.getVisibility() != 0) {
            this.navigator.fetchWalletAddressByIntent(WALLET_PERMISSIONS_INTENT_URI_ACTION, 123, WALLET_PERMISSIONS_INTENT_EXTRA_KEY, WALLET_PERMISSIONS_INTENT_EXTRA_VALUE);
        }
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public rx.e<Result> getActivityResults() {
        return ((ActivityResultNavigator) getContext()).results();
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public rx.e<String> getWalletClick() {
        return e.g.a.c.a.a(this.getWalletAddressButton).X(new rx.m.e() { // from class: cm.aptoide.pt.promotions.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7015f.g((Void) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public void handleEmptyEditText(Editable editable) {
        if (editable.toString().equals(HttpUrl.FRAGMENT_ENCODE_SET)) {
            this.walletMessageIcon.setVisibility(8);
        } else {
            this.walletMessageIcon.setVisibility(0);
        }
        if (validateAddress(editable.toString())) {
            enableNextButton();
            disableWalletButton();
            setValidWalletMessage();
        } else {
            disableNextButton();
            enableWalletButton();
            setInvalidWalletMessage();
        }
        this.walletErrorView.setVisibility(8);
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public rx.e<Void> onCancelWalletUpdate() {
        return e.g.a.c.a.a(this.cancelUpdateWalletButton);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseDialogFragment, com.trello.rxlifecycle.h.a.c, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        this.clipboard = (ClipboardManager) getContext().getSystemService("clipboard");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        getDialog().getWindow().requestFeature(1);
        return layoutInflater.inflate(R.layout.promotions_claim_dialog, viewGroup, false);
    }

    @Override // com.trello.rxlifecycle.h.a.c, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.trello.rxlifecycle.h.a.c, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.walletAddressEdit = null;
        this.getWalletAddressButton = null;
        this.walletNextButton = null;
        this.walletCancelButton = null;
        this.walletMessageIcon = null;
        this.walletErrorView = null;
        this.genericMessageTitle = null;
        this.genericMessageBody = null;
        this.genericMessageButton = null;
        this.genericErrorOkButton = null;
        this.insertWalletView = null;
        this.genericMessageView = null;
        this.genericErrorView = null;
        this.updateWalletView = null;
        this.cancelUpdateWalletButton = null;
        this.updateWalletButton = null;
        this.presenter.dispose();
        this.presenter = null;
    }

    @Override // com.trello.rxlifecycle.h.a.c, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Window window = getDialog().getWindow();
        Point point = new Point();
        window.getWindowManager().getDefaultDisplay().getSize(point);
        double d2 = point.x;
        Double.isNaN(d2);
        window.setLayout((int) (d2 * 0.9d), -2);
        window.setGravity(17);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.insertWalletView.getVisibility() == 0) {
            bundle.putString(VIEW, WALLET);
            return;
        }
        if (this.genericMessageView.getVisibility() == 0 && this.genericMessageTitle.getText().equals(getResources().getString(R.string.holidayspromotion_title_completed))) {
            bundle.putString(VIEW, "success");
            return;
        }
        if (this.genericMessageView.getVisibility() == 0 && this.genericMessageTitle.getText().equals(getResources().getString(R.string.holidayspromotion_title_error_claimed))) {
            bundle.putString(VIEW, CLAIMED);
        } else if (this.genericErrorView.getVisibility() == 0) {
            bundle.putString(VIEW, GENERIC_ERROR);
        }
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public rx.e<Void> onUpdateWalletClick() {
        return e.g.a.c.a.a(this.updateWalletButton);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseDialogFragment, com.trello.rxlifecycle.h.a.c, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.loading = (ProgressBar) view.findViewById(R.id.loading);
        this.walletAddressEdit = (EditText) view.findViewById(R.id.wallet_edit);
        this.getWalletAddressButton = (Button) view.findViewById(R.id.get_wallet_button);
        this.walletNextButton = (Button) view.findViewById(R.id.wallet_continue_button);
        this.walletCancelButton = (Button) view.findViewById(R.id.wallet_cancel_button);
        this.walletMessageIcon = (ImageView) view.findViewById(R.id.wallet_message_icon);
        this.walletErrorView = view.findViewById(R.id.wallet_error_view);
        this.genericMessageTitle = (TextView) view.findViewById(R.id.generic_message_title);
        this.genericMessageBody = (TextView) view.findViewById(R.id.generic_message_body);
        this.genericMessageButton = (TextView) view.findViewById(R.id.generic_message_button);
        this.genericErrorOkButton = (Button) view.findViewById(R.id.error_ok_button);
        this.insertWalletView = view.findViewById(R.id.insert_address_view);
        this.genericMessageView = view.findViewById(R.id.generic_message_view);
        this.genericErrorView = view.findViewById(R.id.generic_error);
        this.genericErrorViewMessage = (TextView) view.findViewById(R.id.generic_error_message);
        this.updateWalletView = view.findViewById(R.id.update_wallet_view);
        this.cancelUpdateWalletButton = (Button) view.findViewById(R.id.cancel_wallet_update_button);
        this.updateWalletButton = (Button) view.findViewById(R.id.update_wallet_button);
        attachPresenter(this.presenter);
        handleRestoreViewState(bundle);
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public void sendWalletIntent() {
        AptoideUtils.SystemU.openApp(AptoideApplication.APPCOINS_WALLET_PACKAGE_NAME, getContext().getPackageManager(), getContext());
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public void showCanceledVerificationError() {
        showErrorView(getString(R.string.appc_verification_cancelled_by_user_message));
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public void showClaimSuccess() {
        this.loading.setVisibility(8);
        showGenericMessageView(getResources().getString(R.string.holidayspromotion_title_completed), getResources().getString(R.string.holidayspromotion_message_completed));
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public void showGenericError() {
        showErrorView(getString(R.string.error_occured));
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public void showInvalidWalletAddress() {
        this.loading.setVisibility(8);
        showWalletView();
        this.walletAddressEdit.setText(HttpUrl.FRAGMENT_ENCODE_SET);
        this.walletMessageIcon.setVisibility(8);
        this.walletErrorView.setVisibility(0);
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public void showLoading() {
        this.loading.setVisibility(0);
        this.insertWalletView.setVisibility(8);
        this.genericMessageView.setVisibility(8);
        this.updateWalletView.setVisibility(8);
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public void showPromotionAlreadyClaimed() {
        this.loading.setVisibility(8);
        showGenericMessageView(getResources().getString(R.string.holidayspromotion_title_error_claimed), getResources().getString(R.string.holidayspromotion_short_error_claimed));
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public void showUpdateWalletDialog() {
        this.loading.setVisibility(8);
        this.genericErrorView.setVisibility(8);
        this.insertWalletView.setVisibility(8);
        this.genericMessageView.setVisibility(8);
        this.updateWalletView.setVisibility(0);
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public void updateWalletText(String str) {
        if (validateAddress(str)) {
            this.walletAddressEdit.setText(str);
        }
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public void verifyWallet() {
        if (this.walletErrorView.getVisibility() != 0) {
            this.navigator.validateWallet(WALLET_VERIFICATION_INTENT_URI_ACTION, 124);
        }
    }

    @Override // cm.aptoide.pt.promotions.ClaimPromotionDialogView
    public rx.e<String> walletCancelClick() {
        return e.g.a.c.a.a(this.walletCancelButton).X(new rx.m.e() { // from class: cm.aptoide.pt.promotions.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6995f.h((Void) obj);
            }
        });
    }
}
