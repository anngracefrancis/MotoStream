package h.a;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: Observable.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class m<T> implements p<T> {

    /* JADX INFO: compiled from: Observable.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[h.a.a.values().length];
            a = iArr;
            try {
                iArr[h.a.a.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[h.a.a.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[h.a.a.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[h.a.a.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static <T> m<T> D(p<T> pVar) {
        h.a.z.b.b.c(pVar, "source is null");
        return pVar instanceof m ? h.a.a0.a.m((m) pVar) : h.a.a0.a.m(new h.a.z.e.d.l(pVar));
    }

    public static int b() {
        return h.c();
    }

    public static <T> m<T> c(o<T> oVar) {
        h.a.z.b.b.c(oVar, "source is null");
        return h.a.a0.a.m(new h.a.z.e.d.b(oVar));
    }

    private m<T> d(h.a.y.e<? super T> eVar, h.a.y.e<? super Throwable> eVar2, h.a.y.a aVar, h.a.y.a aVar2) {
        h.a.z.b.b.c(eVar, "onNext is null");
        h.a.z.b.b.c(eVar2, "onError is null");
        h.a.z.b.b.c(aVar, "onComplete is null");
        h.a.z.b.b.c(aVar2, "onAfterTerminate is null");
        return h.a.a0.a.m(new h.a.z.e.d.c(this, eVar, eVar2, aVar, aVar2));
    }

    public static <T> m<T> g() {
        return h.a.a0.a.m(h.a.z.e.d.d.f21516f);
    }

    public static <T> m<T> h(Throwable th) {
        h.a.z.b.b.c(th, "exception is null");
        return i(h.a.z.b.a.c(th));
    }

    public static <T> m<T> i(Callable<? extends Throwable> callable) {
        h.a.z.b.b.c(callable, "errorSupplier is null");
        return h.a.a0.a.m(new h.a.z.e.d.e(callable));
    }

    public static <T> m<T> s(Iterable<? extends T> iterable) {
        h.a.z.b.b.c(iterable, "source is null");
        return h.a.a0.a.m(new h.a.z.e.d.k(iterable));
    }

    public static <T> m<T> t(T t) {
        h.a.z.b.b.c(t, "item is null");
        return h.a.a0.a.m(new h.a.z.e.d.m(t));
    }

    public final s<List<T>> A() {
        return B(16);
    }

    public final s<List<T>> B(int i2) {
        h.a.z.b.b.d(i2, "capacityHint");
        return h.a.a0.a.n(new h.a.z.e.d.s(this, i2));
    }

    public final m<T> C(r rVar) {
        h.a.z.b.b.c(rVar, "scheduler is null");
        return h.a.a0.a.m(new h.a.z.e.d.t(this, rVar));
    }

    @Override // h.a.p
    public final void a(q<? super T> qVar) {
        h.a.z.b.b.c(qVar, "observer is null");
        try {
            q<? super T> qVarU = h.a.a0.a.u(this, qVar);
            h.a.z.b.b.c(qVarU, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            x(qVarU);
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

    public final m<T> e(h.a.y.e<? super Throwable> eVar) {
        h.a.y.e<? super T> eVarB = h.a.z.b.a.b();
        h.a.y.a aVar = h.a.z.b.a.f21453c;
        return d(eVarB, eVar, aVar, aVar);
    }

    public final m<T> f(h.a.y.e<? super T> eVar) {
        h.a.y.e<? super Throwable> eVarB = h.a.z.b.a.b();
        h.a.y.a aVar = h.a.z.b.a.f21453c;
        return d(eVar, eVarB, aVar, aVar);
    }

    public final <R> m<R> j(h.a.y.f<? super T, ? extends p<? extends R>> fVar) {
        return k(fVar, false);
    }

    public final <R> m<R> k(h.a.y.f<? super T, ? extends p<? extends R>> fVar, boolean z) {
        return l(fVar, z, Integer.MAX_VALUE);
    }

    public final <R> m<R> l(h.a.y.f<? super T, ? extends p<? extends R>> fVar, boolean z, int i2) {
        return m(fVar, z, i2, b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> m<R> m(h.a.y.f<? super T, ? extends p<? extends R>> fVar, boolean z, int i2, int i3) {
        h.a.z.b.b.c(fVar, "mapper is null");
        h.a.z.b.b.d(i2, "maxConcurrency");
        h.a.z.b.b.d(i3, "bufferSize");
        if (!(this instanceof h.a.z.c.d)) {
            return h.a.a0.a.m(new h.a.z.e.d.f(this, fVar, z, i2, i3));
        }
        Object objCall = ((h.a.z.c.d) this).call();
        return objCall == null ? g() : h.a.z.e.d.p.a(objCall, fVar);
    }

    public final b n(h.a.y.f<? super T, ? extends f> fVar) {
        return o(fVar, false);
    }

    public final b o(h.a.y.f<? super T, ? extends f> fVar, boolean z) {
        h.a.z.b.b.c(fVar, "mapper is null");
        return h.a.a0.a.j(new h.a.z.e.d.h(this, fVar, z));
    }

    public final <U> m<U> p(h.a.y.f<? super T, ? extends Iterable<? extends U>> fVar) {
        h.a.z.b.b.c(fVar, "mapper is null");
        return h.a.a0.a.m(new h.a.z.e.d.j(this, fVar));
    }

    public final <R> m<R> q(h.a.y.f<? super T, ? extends l<? extends R>> fVar) {
        return r(fVar, false);
    }

    public final <R> m<R> r(h.a.y.f<? super T, ? extends l<? extends R>> fVar, boolean z) {
        h.a.z.b.b.c(fVar, "mapper is null");
        return h.a.a0.a.m(new h.a.z.e.d.i(this, fVar, z));
    }

    public final m<T> u(r rVar) {
        return v(rVar, false, b());
    }

    public final m<T> v(r rVar, boolean z, int i2) {
        h.a.z.b.b.c(rVar, "scheduler is null");
        h.a.z.b.b.d(i2, "bufferSize");
        return h.a.a0.a.m(new h.a.z.e.d.n(this, rVar, z, i2));
    }

    public final m<T> w(h.a.y.f<? super Throwable, ? extends T> fVar) {
        h.a.z.b.b.c(fVar, "valueSupplier is null");
        return h.a.a0.a.m(new h.a.z.e.d.o(this, fVar));
    }

    protected abstract void x(q<? super T> qVar);

    public final m<T> y(r rVar) {
        h.a.z.b.b.c(rVar, "scheduler is null");
        return h.a.a0.a.m(new h.a.z.e.d.q(this, rVar));
    }

    public final h<T> z(h.a.a aVar) {
        h.a.z.e.b.b bVar = new h.a.z.e.b.b(this);
        int i2 = a.a[aVar.ordinal()];
        if (i2 == 1) {
            return bVar.f();
        }
        if (i2 == 2) {
            return bVar.g();
        }
        if (i2 != 3) {
            return i2 != 4 ? bVar.d() : h.a.a0.a.k(new h.a.z.e.b.e(bVar));
        }
        return bVar;
    }
}
