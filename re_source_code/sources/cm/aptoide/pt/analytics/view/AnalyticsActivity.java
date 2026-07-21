package cm.aptoide.pt.analytics.view;

import android.os.Bundle;
import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.pt.analytics.FirstLaunchAnalytics;
import cm.aptoide.pt.permission.PermissionProviderActivity;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes.dex */
public abstract class AnalyticsActivity extends PermissionProviderActivity {
    private boolean _resumed = false;

    @Inject
    AnalyticsManager analyticsManager;

    @Inject
    FirstLaunchAnalytics firstLaunchAnalytics;

    public boolean is_resumed() {
        return this._resumed;
    }

    @Override // cm.aptoide.pt.permission.PermissionProviderActivity, cm.aptoide.pt.permission.PermissionServiceActivity, cm.aptoide.pt.navigator.ActivityResultNavigator, cm.aptoide.pt.view.BaseActivity, com.trello.rxlifecycle.h.a.a, androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getActivityComponent().inject(this);
        this.firstLaunchAnalytics.setGmsPresent();
    }

    @Override // com.trello.rxlifecycle.h.a.a, androidx.fragment.app.d, android.app.Activity
    protected void onPause() {
        super.onPause();
        this._resumed = false;
    }

    @Override // com.trello.rxlifecycle.h.a.a, androidx.fragment.app.d, android.app.Activity
    protected void onResume() {
        super.onResume();
        this._resumed = true;
    }

    @Override // com.trello.rxlifecycle.h.a.a, androidx.appcompat.app.d, androidx.fragment.app.d, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.analyticsManager.startSession();
    }

    @Override // com.trello.rxlifecycle.h.a.a, androidx.appcompat.app.d, androidx.fragment.app.d, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.analyticsManager.endSession();
    }
}
