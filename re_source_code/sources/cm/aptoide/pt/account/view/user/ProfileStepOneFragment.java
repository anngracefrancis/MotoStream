package cm.aptoide.pt.account.view.user;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.LoginSignupManager;
import cm.aptoide.pt.R;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.orientation.ScreenOrientationManager;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.utils.GenericDialogs;
import cm.aptoide.pt.utils.design.ShowMessage;
import cm.aptoide.pt.view.NotBottomNavigationView;
import cm.aptoide.pt.view.fragment.BaseToolbarFragment;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes.dex */
public class ProfileStepOneFragment extends BaseToolbarFragment implements ProfileStepOneView, NotBottomNavigationView {
    public static final String IS_EXTERNAL_LOGIN = "facebook_google";
    private static final int LAYOUT = 2131493039;

    @Inject
    AccountAnalytics accountAnalytics;

    @Inject
    AccountNavigator accountNavigator;
    private Button continueBtn;
    private boolean externalLogin;

    @Inject
    LoginSignupManager loginSignupManager;
    private Button moreInfoBtn;

    @Inject
    ScreenOrientationManager orientationManager;

    @Inject
    ThemeManager themeManager;
    private ProgressDialog waitDialog;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$continueButtonClick$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean e(Void r1) {
        return Boolean.valueOf(this.externalLogin);
    }

    public static ProfileStepOneFragment newInstance() {
        return new ProfileStepOneFragment();
    }

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void bindViews(View view) {
        super.bindViews(view);
        this.continueBtn = (Button) view.findViewById(R.id.logged_in_continue);
        this.moreInfoBtn = (Button) view.findViewById(R.id.logged_in_more_info_button);
    }

    @Override // cm.aptoide.pt.account.view.user.ProfileStepOneView
    public rx.e<Boolean> continueButtonClick() {
        return e.g.a.c.a.a(this.continueBtn).X(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.b0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3958f.e((Void) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.account.view.user.ProfileStepOneView
    public void dismissWaitDialog() {
        this.orientationManager.unlock();
        ProgressDialog progressDialog = this.waitDialog;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.waitDialog.dismiss();
    }

    @Override // cm.aptoide.pt.view.fragment.UiComponent
    public int getContentViewId() {
        return R.layout.fragment_profile_step_one;
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName());
    }

    @Override // cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void loadExtras(Bundle bundle) {
        super.loadExtras(bundle);
        if (bundle != null) {
            this.externalLogin = bundle.getBoolean(IS_EXTERNAL_LOGIN, false);
        }
    }

    @Override // cm.aptoide.pt.account.view.user.ProfileStepOneView
    public rx.e<Void> moreInfoButtonClick() {
        return e.g.a.c.a.a(this.moreInfoBtn);
    }

    @Override // cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        this.waitDialog = GenericDialogs.createGenericPleaseWaitDialog(getContext(), this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId, getContext().getString(R.string.please_wait));
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.waitDialog;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.waitDialog.dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(IS_EXTERNAL_LOGIN, this.externalLogin);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        loadExtras(bundle);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment
    protected void setupToolbarDetails(Toolbar toolbar) {
        super.setupToolbarDetails(toolbar);
        toolbar.setTitle(R.string.create_profile_logged_in_activity_title);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void setupViews() {
        super.setupViews();
        attachPresenter(new ProfileStepOnePresenter(this, CrashReport.getInstance(), ((AptoideApplication) getActivity().getApplicationContext()).getAccountManager(), this.accountNavigator, this.accountAnalytics, this.loginSignupManager));
    }

    @Override // cm.aptoide.pt.account.view.user.ProfileStepOneView
    public rx.b showGenericErrorMessage() {
        return ShowMessage.asLongObservableSnack(this, R.string.unknown_error);
    }

    @Override // cm.aptoide.pt.account.view.user.ProfileStepOneView
    public void showWaitDialog() {
        this.orientationManager.lock();
        ProgressDialog progressDialog = this.waitDialog;
        if (progressDialog == null || progressDialog.isShowing()) {
            return;
        }
        this.waitDialog.show();
    }
}
