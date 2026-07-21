package cm.aptoide.pt.account.view;

import android.content.Intent;
import android.os.Bundle;
import cm.aptoide.pt.R;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class LoginActivity extends LoginBottomSheetActivity {
    public static final String ACCOUNT_TYPE = "account_type";
    public static final String AUTH_TYPE = "auth_type";
    public static final String IS_ADDING_NEW_ACCOUNT = "is_adding_new_account";
    private String accountType;
    private String authType;
    private boolean isNewAccount;

    private int getLayoutId() {
        return R.layout.empty_frame;
    }

    private void loadExtras(Intent intent) {
        this.accountType = intent.getStringExtra(ACCOUNT_TYPE);
        this.authType = intent.getStringExtra(AUTH_TYPE);
        this.isNewAccount = intent.getBooleanExtra(IS_ADDING_NEW_ACCOUNT, false);
    }

    @Override // cm.aptoide.pt.account.view.LoginBottomSheetActivity, cm.aptoide.pt.view.BackButtonActivity, cm.aptoide.pt.view.ThemedActivityView, cm.aptoide.pt.analytics.view.AnalyticsActivity, cm.aptoide.pt.permission.PermissionProviderActivity, cm.aptoide.pt.permission.PermissionServiceActivity, cm.aptoide.pt.navigator.ActivityResultNavigator, cm.aptoide.pt.view.BaseActivity, com.trello.rxlifecycle.h.a.a, androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getLayoutId());
        loadExtras(getIntent());
        if (bundle == null) {
            getFragmentNavigator().navigateToWithoutBackSave(LoginSignUpFragment.newInstance(false, true, false, this.accountType, this.authType, this.isNewAccount, false, false, HttpUrl.FRAGMENT_ENCODE_SET), true);
        }
    }
}
