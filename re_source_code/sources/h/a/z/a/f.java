package h.a.z.a;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SequentialDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends AtomicReference<h.a.x.c> implements h.a.x.c {
    public f() {
    }

    public boolean a(h.a.x.c cVar) {
        return c.v(this, cVar);
    }

    @Override // h.a.x.c
    public void k() {
        c.g(this);
    }

    @Override // h.a.x.c
    public boolean q() {
        return c.u(get());
    }

    public f(h.a.x.c cVar) {
        lazySet(cVar);
    }
}
