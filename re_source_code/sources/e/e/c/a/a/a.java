package e.e.c.a.a;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: ListenableFuture.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a<V> extends Future<V> {
    void g(Runnable runnable, Executor executor);
}
