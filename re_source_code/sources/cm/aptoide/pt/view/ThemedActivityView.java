package cm.aptoide.pt.view;

import android.os.Bundle;
import cm.aptoide.pt.themes.ThemeManager;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes.dex */
public abstract class ThemedActivityView extends ActivityView {

    @Inject
    public ThemeManager themeManager;

    @Override // cm.aptoide.pt.analytics.view.AnalyticsActivity, cm.aptoide.pt.permission.PermissionProviderActivity, cm.aptoide.pt.permission.PermissionServiceActivity, cm.aptoide.pt.navigator.ActivityResultNavigator, cm.aptoide.pt.view.BaseActivity, com.trello.rxlifecycle.h.a.a, androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getActivityComponent().inject(this);
        this.themeManager.resetToBaseTheme();
    }
}
