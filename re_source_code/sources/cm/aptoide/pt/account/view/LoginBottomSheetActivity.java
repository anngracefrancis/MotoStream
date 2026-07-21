package cm.aptoide.pt.account.view;

import android.os.Bundle;
import cm.aptoide.pt.view.BackButtonActivity;

/* JADX INFO: loaded from: classes.dex */
public abstract class LoginBottomSheetActivity extends BackButtonActivity implements LoginBottomSheet {
    private e.g.b.a<LoginBottomSheet.State> stateSubject;

    @Override // cm.aptoide.pt.account.view.LoginBottomSheet
    public void collapse() {
        this.stateSubject.call(LoginBottomSheet.State.COLLAPSED);
    }

    @Override // cm.aptoide.pt.account.view.LoginBottomSheet
    public void expand() {
        this.stateSubject.call(LoginBottomSheet.State.EXPANDED);
    }

    @Override // cm.aptoide.pt.view.BackButtonActivity, cm.aptoide.pt.view.ThemedActivityView, cm.aptoide.pt.analytics.view.AnalyticsActivity, cm.aptoide.pt.permission.PermissionProviderActivity, cm.aptoide.pt.permission.PermissionServiceActivity, cm.aptoide.pt.navigator.ActivityResultNavigator, cm.aptoide.pt.view.BaseActivity, com.trello.rxlifecycle.h.a.a, androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.stateSubject = e.g.b.a.f1();
    }

    @Override // cm.aptoide.pt.account.view.LoginBottomSheet
    public rx.e<LoginBottomSheet.State> state() {
        return this.stateSubject;
    }
}
