package android.support.v4.media.session;

import android.media.session.MediaSession;

/* JADX INFO: compiled from: MediaSessionCompatApi21.java */
/* JADX INFO: loaded from: classes.dex */
class f {
    public static Object a(Object obj) {
        return ((MediaSession.QueueItem) obj).getDescription();
    }

    public static long b(Object obj) {
        return ((MediaSession.QueueItem) obj).getQueueId();
    }
}
