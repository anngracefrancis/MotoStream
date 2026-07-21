package h.a.z.d;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: BasicIntQueueDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> extends AtomicInteger implements h.a.z.c.b<T> {
    @Override // h.a.z.c.f
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
