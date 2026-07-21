package cm.aptoide.pt;

import android.app.Service;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseService extends Service {
    public ApplicationComponent getApplicationComponent() {
        return ((AptoideApplication) getApplication()).getApplicationComponent();
    }
}
