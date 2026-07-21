package cm.aptoide.pt.account.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.pt.R;
import cm.aptoide.pt.presenter.LoginSignUpView;
import cm.aptoide.pt.view.NotBottomNavigationView;
import cm.aptoide.pt.view.fragment.BaseToolbarFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class LoginSignUpFragment extends BaseToolbarFragment implements LoginSignUpView, NotBottomNavigationView {
    private static final String ACCOUNT_TYPE = "account_type";
    private static final String AUTH_TYPE = "auth_type";
    private static final String BOTTOM_SHEET_WITH_BOTTOM_BAR = "bottom_sheet_expanded";
    private static final String DISMISS_TO_NAVIGATE_TO_MAIN_VIEW = "dismiss_to_navigate_to_main_view";
    public static final String HAS_MAGIC_LINK_ERROR = "has_magic_link_error";
    private static final String IS_NEW_ACCOUNT = "is_new_account";
    private static final String IS_WIZARD = "is_wizard";
    public static final String MAGIC_LINK_ERROR_MESSAGE = "magic_link_error_message";
    private static final String NAVIGATE_TO_HOME = "clean_back_stack";
    private BottomSheetBehavior<View> bottomSheetBehavior;
    private boolean dismissToNavigateToMainView;
    private boolean hasMagicLinkError;
    private boolean isWizard;
    private LoginBottomSheet loginBottomSheet;
    private String magicLinkErrorMessage;
    private View mainContent;
    private boolean navigateToHome;
    private int originalBottomPadding;
    private LoginSignUpPresenter presenter;
    private String toolbarTitle;
    private boolean withBottomBar;

    public static LoginSignUpFragment newInstance(boolean z, boolean z2, boolean z3, boolean z4) {
        return newInstance(z, z2, z3, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, true, z4, false, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void bindViews(View view) {
        super.bindViews(view);
        try {
            this.bottomSheetBehavior = BottomSheetBehavior.T(view.findViewById(R.id.login_signup_layout));
        } catch (IllegalArgumentException unused) {
        }
        if (this.bottomSheetBehavior != null) {
            View viewFindViewById = view.findViewById(R.id.main_content);
            this.mainContent = viewFindViewById;
            this.originalBottomPadding = this.withBottomBar ? viewFindViewById.getPaddingBottom() : 0;
            this.toolbarTitle = getString(R.string.my_account_title_my_account);
            this.mainContent.setPadding(0, 0, 0, this.originalBottomPadding);
            this.bottomSheetBehavior.l0(4);
        }
    }

    @Override // cm.aptoide.pt.presenter.LoginSignUpView
    public boolean bottomSheetIsExpanded() {
        BottomSheetBehavior<View> bottomSheetBehavior = this.bottomSheetBehavior;
        return bottomSheetBehavior != null && bottomSheetBehavior.V() == 3;
    }

    @Override // cm.aptoide.pt.presenter.LoginSignUpView
    public void collapseBottomSheet() {
        this.loginBottomSheet.collapse();
        this.mainContent.setPadding(0, 0, 0, this.originalBottomPadding);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment
    protected boolean displayHomeUpAsEnabled() {
        return hasToolbar();
    }

    @Override // cm.aptoide.pt.presenter.LoginSignUpView
    public void expandBottomSheet() {
        this.loginBottomSheet.expand();
        this.mainContent.setPadding(0, 0, 0, 0);
    }

    @Override // cm.aptoide.pt.view.fragment.UiComponent
    public int getContentViewId() {
        return this.isWizard ? R.layout.fragment_login_signup_wizard_layout : R.layout.fragment_login_sign_up;
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName());
    }

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment
    protected boolean hasToolbar() {
        return this.toolbarTitle != null;
    }

    @Override // cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void loadExtras(Bundle bundle) {
        super.loadExtras(bundle);
        this.withBottomBar = bundle.getBoolean(BOTTOM_SHEET_WITH_BOTTOM_BAR);
        this.dismissToNavigateToMainView = bundle.getBoolean("dismiss_to_navigate_to_main_view");
        this.navigateToHome = bundle.getBoolean("clean_back_stack");
        this.isWizard = bundle.getBoolean(IS_WIZARD);
        this.hasMagicLinkError = bundle.getBoolean("has_magic_link_error");
        String string = bundle.getString("magic_link_error_message");
        this.magicLinkErrorMessage = string;
        if (string == null) {
            this.magicLinkErrorMessage = HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cm.aptoide.pt.view.BackButtonFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof LoginBottomSheet) {
            this.loginBottomSheet = (LoginBottomSheet) context;
            return;
        }
        throw new IllegalStateException("Context should implement " + LoginBottomSheet.class.getSimpleName());
    }

    @Override // cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        BottomSheetBehavior<View> bottomSheetBehavior = this.bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.a0(null);
            this.bottomSheetBehavior = null;
        }
        LoginSignUpPresenter loginSignUpPresenter = this.presenter;
        if (loginSignUpPresenter != null) {
            unregisterClickHandler(loginSignUpPresenter);
        }
        super.onDestroyView();
    }

    @Override // cm.aptoide.pt.presenter.LoginSignUpView
    public void setBottomSheetState(int i2) {
        this.bottomSheetBehavior.l0(4);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment
    public void setupToolbarDetails(Toolbar toolbar) {
        toolbar.setTitle(HttpUrl.FRAGMENT_ENCODE_SET);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void setupViews() {
        super.setupViews();
        LoginSignUpPresenter loginSignUpPresenter = new LoginSignUpPresenter(this, getFragmentChildNavigator(R.id.login_signup_layout), this.dismissToNavigateToMainView, this.navigateToHome, this.hasMagicLinkError, this.magicLinkErrorMessage);
        this.presenter = loginSignUpPresenter;
        attachPresenter(loginSignUpPresenter);
        registerClickHandler(this.presenter);
        this.bottomSheetBehavior.a0(this.presenter);
        this.bottomSheetBehavior.b0(false);
        this.bottomSheetBehavior.g0(true);
    }

    public static LoginSignUpFragment newInstance(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str) {
        return newInstance(z, z2, z3, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, true, z4, z5, str);
    }

    public static LoginSignUpFragment newInstance(boolean z, boolean z2, boolean z3, String str, String str2, boolean z4, boolean z5, boolean z6, String str3) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(BOTTOM_SHEET_WITH_BOTTOM_BAR, z);
        bundle.putBoolean("dismiss_to_navigate_to_main_view", z2);
        bundle.putBoolean("clean_back_stack", z3);
        bundle.putString("account_type", str);
        bundle.putString("auth_type", str2);
        bundle.putBoolean(IS_NEW_ACCOUNT, z4);
        bundle.putBoolean(IS_WIZARD, z5);
        bundle.putBoolean("has_magic_link_error", z6);
        bundle.putString("magic_link_error_message", str3);
        LoginSignUpFragment loginSignUpFragment = new LoginSignUpFragment();
        loginSignUpFragment.setArguments(bundle);
        return loginSignUpFragment;
    }
}
