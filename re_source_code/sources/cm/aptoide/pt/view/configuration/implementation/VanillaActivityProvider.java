package cm.aptoide.pt.view.configuration.implementation;

import androidx.appcompat.app.d;
import cm.aptoide.pt.view.ActivityProvider;
import cm.aptoide.pt.view.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public class VanillaActivityProvider implements ActivityProvider {
    @Override // cm.aptoide.pt.view.ActivityProvider
    public Class<? extends d> getMainActivityFragmentClass() {
        return MainActivity.class;
    }
}
