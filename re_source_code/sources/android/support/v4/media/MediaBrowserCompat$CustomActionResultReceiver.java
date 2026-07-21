package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
class MediaBrowserCompat$CustomActionResultReceiver extends ResultReceiver {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Bundle f2i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final a f3j;

    @Override // android.support.v4.os.ResultReceiver
    protected void a(int i2, Bundle bundle) {
        if (this.f3j == null) {
            return;
        }
        MediaSessionCompat.a(bundle);
        if (i2 == -1 || i2 == 0 || i2 == 1) {
            throw null;
        }
        Log.w("MediaBrowserCompat", "Unknown result code: " + i2 + " (extras=" + this.f2i + ", resultData=" + bundle + ")");
    }
}
