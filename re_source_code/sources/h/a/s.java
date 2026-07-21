package h.a;

/* JADX INFO: compiled from: Single.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class s<T> implements w<T> {
    public static <T> s<T> c(v<T> vVar) {
        h.a.z.b.b.c(vVar, "source is null");
        return h.a.a0.a.n(new h.a.z.e.e.a(vVar));
    }

    public static <T> s<T> f(T t) {
        h.a.z.b.b.c(t, "item is null");
        return h.a.a0.a.n(new h.a.z.e.e.c(t));
    }

    @Override // h.a.w
    public final void b(u<? super T> uVar) {
        h.a.z.b.b.c(uVar, "observer is null");
        u<? super T> uVarV = h.a.a0.a.v(this, uVar);
        h.a.z.b.b.c(uVarV, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            h(uVarV);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final <R> s<R> d(h.a.y.f<? super T, ? extends w<? extends R>> fVar) {
        h.a.z.b.b.c(fVar, "mapper is null");
        return h.a.a0.a.n(new h.a.z.e.e.b(this, fVar));
    }

    public final b e() {
        return h.a.a0.a.j(new h.a.z.e.a.c(this));
    }

    public final <R> s<R> g(h.a.y.f<? super T, ? extends R> fVar) {
        h.a.z.b.b.c(fVar, "mapper is null");
        return h.a.a0.a.n(new h.a.z.e.e.d(this, fVar));
    }

    protected abstract void h(u<? super T> uVar);

    public final s<T> i(r rVar) {
        h.a.z.b.b.c(rVar, "scheduler is null");
        return h.a.a0.a.n(new h.a.z.e.e.e(this, rVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final m<T> j() {
        return this instanceof h.a.z.c.a ? ((h.a.z.c.a) this).a() : h.a.a0.a.m(new h.a.z.e.e.f(this));
    }
}
