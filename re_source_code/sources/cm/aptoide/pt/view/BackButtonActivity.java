package cm.aptoide.pt.view;

import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class BackButtonActivity extends ThemedActivityView implements BackButton {
    private Set<BackButton.ClickHandler> clickHandlers;

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Iterator<BackButton.ClickHandler> it = this.clickHandlers.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().handle()) {
                z = true;
            }
        }
        if (z) {
            return;
        }
        super.onBackPressed();
    }

    @Override // cm.aptoide.pt.view.ThemedActivityView, cm.aptoide.pt.analytics.view.AnalyticsActivity, cm.aptoide.pt.permission.PermissionProviderActivity, cm.aptoide.pt.permission.PermissionServiceActivity, cm.aptoide.pt.navigator.ActivityResultNavigator, cm.aptoide.pt.view.BaseActivity, com.trello.rxlifecycle.h.a.a, androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.clickHandlers = new HashSet();
    }

    @Override // cm.aptoide.pt.view.BackButton
    public void registerClickHandler(BackButton.ClickHandler clickHandler) {
        this.clickHandlers.add(clickHandler);
    }

    @Override // cm.aptoide.pt.view.BackButton
    public void unregisterClickHandler(BackButton.ClickHandler clickHandler) {
        this.clickHandlers.remove(clickHandler);
    }
}
