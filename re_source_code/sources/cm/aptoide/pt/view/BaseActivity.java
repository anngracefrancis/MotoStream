package cm.aptoide.pt.view;

import android.os.Bundle;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.FlavourActivityModule;
import cm.aptoide.pt.presenter.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseActivity extends com.trello.rxlifecycle.h.a.a {
    private ActivityComponent activityComponent;
    private boolean firstCreated;

    /* JADX WARN: Multi-variable type inference failed */
    public ActivityComponent getActivityComponent() {
        if (this.activityComponent == null) {
            AptoideApplication aptoideApplication = (AptoideApplication) getApplication();
            this.activityComponent = aptoideApplication.getApplicationComponent().plus(aptoideApplication.getActivityModule(this, getIntent(), aptoideApplication.getNotificationSyncScheduler(), (View) this, this.firstCreated, "cm.aptoide.pt.provider"), new FlavourActivityModule());
        }
        return this.activityComponent;
    }

    @Override // com.trello.rxlifecycle.h.a.a, androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.firstCreated = bundle == null;
        getActivityComponent().inject(this);
    }

    @Override // com.trello.rxlifecycle.h.a.a, androidx.appcompat.app.d, androidx.fragment.app.d, android.app.Activity
    protected void onDestroy() {
        this.activityComponent = null;
        super.onDestroy();
    }
}
