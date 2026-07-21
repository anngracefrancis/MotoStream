package h.a;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: Maybe.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class j<T> implements l<T> {
    public static <T> j<T> b() {
        return h.a.a0.a.l(h.a.z.e.c.a.f21500f);
    }

    public static <T> j<T> c(Callable<? extends T> callable) {
        h.a.z.b.b.c(callable, "callable is null");
        return h.a.a0.a.l(new h.a.z.e.c.b(callable));
    }

    public static <T> j<T> d(T t) {
        h.a.z.b.b.c(t, "item is null");
        return h.a.a0.a.l(new h.a.z.e.c.c(t));
    }

    @Override // h.a.l
    public final void a(k<? super T> kVar) {
        h.a.z.b.b.c(kVar, "observer is null");
        k<? super T> kVarT = h.a.a0.a.t(this, kVar);
        h.a.z.b.b.c(kVarT, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            e(kVarT);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    protected abstract void e(k<? super T> kVar);
}
