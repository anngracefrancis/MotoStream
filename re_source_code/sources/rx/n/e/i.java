package rx.n.e;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: RxThreadFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends AtomicLong implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ThreadFactory f26748f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final String f26749g;

    /* JADX INFO: compiled from: RxThreadFactory.java */
    static class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            throw new AssertionError("No threads allowed.");
        }
    }

    public i(String str) {
        this.f26749g = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f26749g + incrementAndGet());
        thread.setDaemon(true);
        return thread;
    }
}
