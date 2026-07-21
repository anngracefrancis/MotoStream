package h.a.x;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ReferenceDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class e<T> extends AtomicReference<T> implements c {
    e(T t) {
        super(h.a.z.b.b.c(t, "value is null"));
    }

    protected abstract void a(T t);

    @Override // h.a.x.c
    public final void k() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        a(andSet);
    }

    @Override // h.a.x.c
    public final boolean q() {
        return get() == null;
    }
}
