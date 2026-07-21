package h.a;

/* JADX INFO: compiled from: Flowable.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h<T> implements k.a.a<T> {
    static final int a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static int c() {
        return a;
    }

    @Override // k.a.a
    public final void b(k.a.b<? super T> bVar) {
        if (bVar instanceof i) {
            h((i) bVar);
        } else {
            h.a.z.b.b.c(bVar, "s is null");
            h(new h.a.z.h.a(bVar));
        }
    }

    public final h<T> d() {
        return e(c(), false, true);
    }

    public final h<T> e(int i2, boolean z, boolean z2) {
        h.a.z.b.b.d(i2, "capacity");
        return h.a.a0.a.k(new h.a.z.e.b.c(this, i2, z2, z, h.a.z.b.a.f21453c));
    }

    public final h<T> f() {
        return h.a.a0.a.k(new h.a.z.e.b.d(this));
    }

    public final h<T> g() {
        return h.a.a0.a.k(new h.a.z.e.b.f(this));
    }

    public final void h(i<? super T> iVar) {
        h.a.z.b.b.c(iVar, "s is null");
        try {
            k.a.b<? super T> bVarW = h.a.a0.a.w(this, iVar);
            h.a.z.b.b.c(bVarW, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            i(bVarW);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            h.a.a0.a.o(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    protected abstract void i(k.a.b<? super T> bVar);
}
