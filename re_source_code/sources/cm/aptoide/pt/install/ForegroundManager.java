package cm.aptoide.pt.install;

import android.content.Context;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ForegroundManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcm/aptoide/pt/install/ForegroundManager;", HttpUrl.FRAGMENT_ENCODE_SET, "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "startDownloadService", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ForegroundManager {
    private final Context context;

    public ForegroundManager(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void startDownloadService() {
        this.context.startService(DownloadService.newInstanceForDownloads(this.context));
    }
}
