package h.a.z.g;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: DisposeOnCancel.java */
/* JADX INFO: loaded from: classes2.dex */
final class c implements Future<Object> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final h.a.x.c f21655f;

    c(h.a.x.c cVar) {
        this.f21655f = cVar;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        this.f21655f.k();
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get() throws ExecutionException, InterruptedException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return false;
    }
}
