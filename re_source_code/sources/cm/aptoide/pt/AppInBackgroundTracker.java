package cm.aptoide.pt;

import androidx.lifecycle.ProcessLifecycleOwner;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AppInBackgroundTracker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcm/aptoide/pt/AppInBackgroundTracker;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "appLifecycleListener", "cm/aptoide/pt/AppInBackgroundTracker$appLifecycleListener$1", "Lcm/aptoide/pt/AppInBackgroundTracker$appLifecycleListener$1;", "isAppInBackground", HttpUrl.FRAGMENT_ENCODE_SET, "initialize", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppInBackgroundTracker {
    private final AppInBackgroundTracker$appLifecycleListener$1 appLifecycleListener = new androidx.lifecycle.j() { // from class: cm.aptoide.pt.AppInBackgroundTracker$appLifecycleListener$1
        @androidx.lifecycle.s(androidx.lifecycle.g.b.ON_STOP)
        public final void onMoveToBackground() {
            this.this$0.isAppInBackground = true;
        }

        @androidx.lifecycle.s(androidx.lifecycle.g.b.ON_START)
        public final void onMoveToForeground() {
            this.this$0.isAppInBackground = false;
        }
    };
    private boolean isAppInBackground;

    public final void initialize() {
        ProcessLifecycleOwner.h().getLifecycle().a(this.appLifecycleListener);
    }

    /* JADX INFO: renamed from: isAppInBackground, reason: from getter */
    public final boolean getIsAppInBackground() {
        return this.isAppInBackground;
    }
}
