package h.a.z.g;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ScheduledDirectTask.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends a implements Callable<Void> {
    public i(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void call() throws Exception {
        this.f21641i = Thread.currentThread();
        try {
            this.f21640h.run();
            return null;
        } finally {
            lazySet(a.f21638f);
            this.f21641i = null;
        }
    }
}
