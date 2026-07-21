package h.a.z.i;

import h.a.z.c.c;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: BasicIntQueueSubscription.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> extends AtomicInteger implements c, k.a.c {
    @Override // h.a.z.c.f
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
