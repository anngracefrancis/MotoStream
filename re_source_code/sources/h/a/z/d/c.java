package h.a.z.d;

import h.a.q;

/* JADX INFO: compiled from: DeferredScalarDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
public class c<T> extends a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final q<? super T> f21464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected T f21465g;

    public c(q<? super T> qVar) {
        this.f21464f = qVar;
    }

    public final void c(T t) {
        int i2 = get();
        if ((i2 & 54) != 0) {
            return;
        }
        q<? super T> qVar = this.f21464f;
        if (i2 == 8) {
            this.f21465g = t;
            lazySet(16);
            qVar.onNext(null);
        } else {
            lazySet(2);
            qVar.onNext(t);
        }
        if (get() != 4) {
            qVar.a();
        }
    }

    @Override // h.a.z.c.f
    public final void clear() {
        lazySet(32);
        this.f21465g = null;
    }

    public final void d(Throwable th) {
        if ((get() & 54) != 0) {
            h.a.a0.a.o(th);
        } else {
            lazySet(2);
            this.f21464f.onError(th);
        }
    }

    @Override // h.a.z.c.c
    public final int g(int i2) {
        if ((i2 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    @Override // h.a.z.c.f
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // h.a.x.c
    public void k() {
        set(4);
        this.f21465g = null;
    }

    @Override // h.a.z.c.f
    public final T poll() throws Exception {
        if (get() != 16) {
            return null;
        }
        T t = this.f21465g;
        this.f21465g = null;
        lazySet(32);
        return t;
    }

    @Override // h.a.x.c
    public final boolean q() {
        return get() == 4;
    }
}
