package rx;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorFailedException;
import rx.n.a.a0;
import rx.n.a.a1;
import rx.n.a.b0;
import rx.n.a.b1;
import rx.n.a.c0;
import rx.n.a.c1;
import rx.n.a.d0;
import rx.n.a.d1;
import rx.n.a.e0;
import rx.n.a.e1;
import rx.n.a.f0;
import rx.n.a.f1;
import rx.n.a.g0;
import rx.n.a.g1;
import rx.n.a.i0;
import rx.n.a.j0;
import rx.n.a.k0;
import rx.n.a.l;
import rx.n.a.l0;
import rx.n.a.m0;
import rx.n.a.n;
import rx.n.a.n0;
import rx.n.a.o;
import rx.n.a.o0;
import rx.n.a.p;
import rx.n.a.p0;
import rx.n.a.q;
import rx.n.a.q0;
import rx.n.a.r;
import rx.n.a.r0;
import rx.n.a.s;
import rx.n.a.s0;
import rx.n.a.t;
import rx.n.a.t0;
import rx.n.a.u;
import rx.n.a.u0;
import rx.n.a.v;
import rx.n.a.v0;
import rx.n.a.w;
import rx.n.a.w0;
import rx.n.a.x;
import rx.n.a.x0;
import rx.n.a.y;
import rx.n.a.y0;
import rx.n.a.z0;
import rx.n.e.m;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: Observable.java */
/* JADX INFO: loaded from: classes.dex */
public class e<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final a<T> f26090f;

    /* JADX INFO: compiled from: Observable.java */
    /* JADX INFO: loaded from: classes3.dex */
    public interface a<T> extends rx.m.b<j<? super T>> {
    }

    /* JADX INFO: compiled from: Observable.java */
    /* JADX INFO: loaded from: classes3.dex */
    public interface b<R, T> extends rx.m.e<j<? super R>, j<? super T>> {
    }

    /* JADX INFO: compiled from: Observable.java */
    public interface c<T, R> extends rx.m.e<e<T>, e<R>> {
    }

    protected e(a<T> aVar) {
        this.f26090f = aVar;
    }

    public static <T> e<T> B() {
        return rx.n.a.g.k();
    }

    public static <T> e<T> C(Throwable th) {
        return b1(new d0(th));
    }

    static <T> k F0(j<? super T> jVar, e<T> eVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("subscriber can not be null");
        }
        if (eVar.f26090f == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        jVar.onStart();
        if (!(jVar instanceof rx.p.c)) {
            jVar = new rx.p.c(jVar);
        }
        try {
            rx.q.c.p(eVar, eVar.f26090f).call(jVar);
            return rx.q.c.o(jVar);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            if (jVar.isUnsubscribed()) {
                rx.q.c.j(rx.q.c.m(th));
            } else {
                try {
                    jVar.onError(rx.q.c.m(th));
                } catch (Throwable th2) {
                    rx.exceptions.a.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    rx.q.c.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
            return rx.t.e.c();
        }
    }

    public static <T> e<T> M0(e<? extends e<? extends T>> eVar) {
        return (e<T>) eVar.W(a1.b(false));
    }

    public static <T> e<T> N(Iterable<? extends T> iterable) {
        return b1(new u(iterable));
    }

    public static <T> e<T> O(T[] tArr) {
        int length = tArr.length;
        if (length == 0) {
            return B();
        }
        return length == 1 ? S(tArr[0]) : b1(new s(tArr));
    }

    public static <T> e<T> P(Callable<? extends T> callable) {
        return b1(new t(callable));
    }

    public static e<Long> Q(long j2, long j3, TimeUnit timeUnit) {
        return R(j2, j3, timeUnit, Schedulers.computation());
    }

    public static e<Long> R(long j2, long j3, TimeUnit timeUnit, h hVar) {
        return b1(new g0(j2, j3, timeUnit, hVar));
    }

    public static <T> e<T> S(T t) {
        return rx.n.e.j.f1(t);
    }

    public static <T> e<T> T(T t, T t2) {
        return O(new Object[]{t, t2});
    }

    public static <T> e<T> U(T t, T t2, T t3) {
        return O(new Object[]{t, t2, t3});
    }

    public static e<Long> U0(long j2, TimeUnit timeUnit) {
        return V0(j2, timeUnit, Schedulers.computation());
    }

    public static <T> e<T> V(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        return O(new Object[]{t, t2, t3, t4, t5, t6, t7});
    }

    public static e<Long> V0(long j2, TimeUnit timeUnit, h hVar) {
        return b1(new f0(j2, timeUnit, hVar));
    }

    public static <T> e<T> Y(Iterable<? extends e<? extends T>> iterable) {
        return Z(N(iterable));
    }

    public static <T> e<T> Z(e<? extends e<? extends T>> eVar) {
        return eVar.getClass() == rx.n.e.j.class ? ((rx.n.e.j) eVar).i1(m.b()) : (e<T>) eVar.W(q0.b(false));
    }

    public static <T> e<T> a0(e<? extends T> eVar, e<? extends T> eVar2) {
        return d0(new e[]{eVar, eVar2});
    }

    public static <T> e<T> b0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3) {
        return d0(new e[]{eVar, eVar2, eVar3});
    }

    public static <T> e<T> b1(a<T> aVar) {
        return new e<>(rx.q.c.h(aVar));
    }

    public static <T, R> e<R> c(List<? extends e<? extends T>> list, rx.m.h<? extends R> hVar) {
        return b1(new rx.n.a.j(list, hVar));
    }

    public static <T> e<T> c0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4) {
        return d0(new e[]{eVar, eVar2, eVar3, eVar4});
    }

    public static <T1, T2, T3, R> e<R> d(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, rx.m.g<? super T1, ? super T2, ? super T3, ? extends R> gVar) {
        return c(Arrays.asList(eVar, eVar2, eVar3), rx.m.i.b(gVar));
    }

    public static <T> e<T> d0(e<? extends T>[] eVarArr) {
        return Z(O(eVarArr));
    }

    public static <T1, T2, R> e<R> d1(e<? extends T1> eVar, e<? extends T2> eVar2, rx.m.f<? super T1, ? super T2, ? extends R> fVar) {
        return S(new e[]{eVar, eVar2}).W(new g1(fVar));
    }

    public static <T1, T2, R> e<R> e(e<? extends T1> eVar, e<? extends T2> eVar2, rx.m.f<? super T1, ? super T2, ? extends R> fVar) {
        return c(Arrays.asList(eVar, eVar2), rx.m.i.a(fVar));
    }

    public static <T> e<T> e0(e<? extends e<? extends T>> eVar) {
        return (e<T>) eVar.W(q0.b(true));
    }

    public static <T> e<T> f0(e<? extends T> eVar, e<? extends T> eVar2) {
        return e0(T(eVar, eVar2));
    }

    public static <T> e<T> g(e<? extends e<? extends T>> eVar) {
        return (e<T>) eVar.i(m.b());
    }

    public static <T> e<T> g0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3) {
        return e0(U(eVar, eVar2, eVar3));
    }

    public static <T> e<T> h(e<? extends T> eVar, e<? extends T> eVar2) {
        return g(T(eVar, eVar2));
    }

    public static <T> e<T> h0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7) {
        return e0(V(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7));
    }

    @Deprecated
    public static <T> e<T> l(a<T> aVar) {
        return new e<>(rx.q.c.h(aVar));
    }

    public static <T> e<T> p(rx.m.d<e<T>> dVar) {
        return b1(new l(dVar));
    }

    public static e<Integer> r0(int i2, int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("Count can not be negative");
        }
        if (i3 == 0) {
            return B();
        }
        if (i2 <= (Integer.MAX_VALUE - i3) + 1) {
            return i3 == 1 ? S(Integer.valueOf(i2)) : b1(new x(i2, (i3 - 1) + i2));
        }
        throw new IllegalArgumentException("start + count can not exceed Integer.MAX_VALUE");
    }

    public final e<T> A(rx.m.a aVar) {
        return (e<T>) W(new o0(aVar));
    }

    public final e<T> A0(long j2, TimeUnit timeUnit, h hVar) {
        return b1(new b0(this, j2, timeUnit, hVar));
    }

    public final e<T> B0(rx.m.e<? super T, Boolean> eVar) {
        return (e<T>) W(new y0(y0.b(eVar)));
    }

    public final e<T> C0(T t) {
        return h(S(t), this);
    }

    public final e<T> D(rx.m.e<? super T, Boolean> eVar) {
        return b1(new o(this, eVar));
    }

    public final k D0() {
        return E0(new rx.n.e.b(rx.m.c.a(), rx.n.e.f.l, rx.m.c.a()));
    }

    public final e<T> E() {
        return N0(1).x0();
    }

    public final k E0(j<? super T> jVar) {
        return F0(jVar, this);
    }

    public final e<T> F(rx.m.e<? super T, Boolean> eVar) {
        return O0(eVar).x0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> e<R> G(rx.m.e<? super T, ? extends e<? extends R>> eVar) {
        return getClass() == rx.n.e.j.class ? ((rx.n.e.j) this).i1(eVar) : Z(X(eVar));
    }

    public final k G0(rx.m.b<? super T> bVar) {
        if (bVar != null) {
            return E0(new rx.n.e.b(bVar, rx.n.e.f.l, rx.m.c.a()));
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public final e<T> H(rx.m.e<? super T, ? extends rx.b> eVar) {
        return I(eVar, false, Integer.MAX_VALUE);
    }

    public final k H0(rx.m.b<? super T> bVar, rx.m.b<Throwable> bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (bVar2 != null) {
            return E0(new rx.n.e.b(bVar, bVar2, rx.m.c.a()));
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    public final e<T> I(rx.m.e<? super T, ? extends rx.b> eVar, boolean z, int i2) {
        return b1(new p(this, eVar, z, i2));
    }

    public final e<T> I0(h hVar) {
        return J0(hVar, true);
    }

    public final <R> e<R> J(rx.m.e<? super T, ? extends Iterable<? extends R>> eVar) {
        return K(eVar, rx.n.e.h.f26744f);
    }

    public final e<T> J0(h hVar, boolean z) {
        return this instanceof rx.n.e.j ? ((rx.n.e.j) this).j1(hVar) : b1(new z0(this, hVar, z));
    }

    public final <R> e<R> K(rx.m.e<? super T, ? extends Iterable<? extends R>> eVar, int i2) {
        return r.b(this, eVar, i2);
    }

    public final e<T> K0(e<? extends T> eVar) {
        if (eVar != null) {
            return b1(new c0(this, eVar));
        }
        throw new NullPointerException("alternate is null");
    }

    public final <R> e<R> L(rx.m.e<? super T, ? extends Single<? extends R>> eVar) {
        return M(eVar, false, Integer.MAX_VALUE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> e<R> L0(rx.m.e<? super T, ? extends e<? extends R>> eVar) {
        return M0(X(eVar));
    }

    public final <R> e<R> M(rx.m.e<? super T, ? extends Single<? extends R>> eVar, boolean z, int i2) {
        return b1(new q(this, eVar, z, i2));
    }

    public final e<T> N0(int i2) {
        return (e<T>) W(new b1(i2));
    }

    public final e<T> O0(rx.m.e<? super T, Boolean> eVar) {
        return D(eVar).N0(1);
    }

    public final <E> e<T> P0(e<? extends E> eVar) {
        return (e<T>) W(new c1(eVar));
    }

    public final e<T> Q0(rx.m.e<? super T, Boolean> eVar) {
        return (e<T>) W(new d1(eVar));
    }

    public final e<T> R0(long j2, TimeUnit timeUnit) {
        return u0(j2, timeUnit);
    }

    public final e<T> S0(long j2, TimeUnit timeUnit, e<? extends T> eVar) {
        return T0(j2, timeUnit, eVar, Schedulers.computation());
    }

    public final e<T> T0(long j2, TimeUnit timeUnit, e<? extends T> eVar, h hVar) {
        return b1(new e0(this, j2, timeUnit, hVar, eVar));
    }

    public final <R> e<R> W(b<? extends R, ? super T> bVar) {
        return b1(new v(this.f26090f, bVar));
    }

    public final rx.o.a<T> W0() {
        return rx.o.a.c(this);
    }

    public final <R> e<R> X(rx.m.e<? super T, ? extends R> eVar) {
        return b1(new w(this, eVar));
    }

    public rx.b X0() {
        return rx.b.v(this);
    }

    public final e<List<T>> Y0() {
        return (e<List<T>>) W(e1.b());
    }

    public Single<T> Z0() {
        return new Single<>(a0.b(this));
    }

    public final e<T> a() {
        return (e<T>) W(i0.b());
    }

    public final e<List<T>> a1(rx.m.f<? super T, ? super T, Integer> fVar) {
        return (e<List<T>>) W(new f1(fVar, 10));
    }

    public final <R> e<R> b(Class<R> cls) {
        return W(new j0(cls));
    }

    public final k c1(j<? super T> jVar) {
        try {
            jVar.onStart();
            rx.q.c.p(this, this.f26090f).call(jVar);
            return rx.q.c.o(jVar);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            try {
                jVar.onError(rx.q.c.m(th));
                return rx.t.e.c();
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                rx.q.c.m(onErrorFailedException);
                throw onErrorFailedException;
            }
        }
    }

    public final <T2, R> e<R> e1(e<? extends T2> eVar, rx.m.f<? super T, ? super T2, ? extends R> fVar) {
        return d1(this, eVar, fVar);
    }

    public <R> e<R> f(c<? super T, ? extends R> cVar) {
        return (e) cVar.call(this);
    }

    public final <R> e<R> i(rx.m.e<? super T, ? extends e<? extends R>> eVar) {
        return this instanceof rx.n.e.j ? ((rx.n.e.j) this).i1(eVar) : b1(new rx.n.a.k(this, eVar, 2, 0));
    }

    public final e<T> i0(e<? extends T> eVar) {
        return a0(this, eVar);
    }

    public final <R> e<R> j(rx.m.e<? super T, ? extends e<? extends R>> eVar) {
        return k(eVar, rx.n.e.h.f26744f);
    }

    public final e<T> j0(h hVar) {
        return k0(hVar, rx.n.e.h.f26744f);
    }

    public final <R> e<R> k(rx.m.e<? super T, ? extends e<? extends R>> eVar, int i2) {
        if (i2 >= 1) {
            return W(new p0(eVar, i2, Integer.MAX_VALUE));
        }
        throw new IllegalArgumentException("capacityHint > 0 required but it was " + i2);
    }

    public final e<T> k0(h hVar, int i2) {
        return l0(hVar, false, i2);
    }

    public final e<T> l0(h hVar, boolean z, int i2) {
        return this instanceof rx.n.e.j ? ((rx.n.e.j) this).j1(hVar) : (e<T>) W(new r0(hVar, z, i2));
    }

    public final e<T> m(long j2, TimeUnit timeUnit) {
        return n(j2, timeUnit, Schedulers.computation());
    }

    public final e<T> m0() {
        return (e<T>) W(s0.b());
    }

    public final e<T> n(long j2, TimeUnit timeUnit, h hVar) {
        return (e<T>) W(new k0(j2, timeUnit, hVar));
    }

    public final e<T> n0(e<? extends T> eVar) {
        return (e<T>) W(t0.b(eVar));
    }

    public final e<T> o(T t) {
        return K0(S(t));
    }

    public final e<T> o0(rx.m.e<? super Throwable, ? extends e<? extends T>> eVar) {
        return (e<T>) W(new t0(eVar));
    }

    public final e<T> p0(rx.m.e<? super Throwable, ? extends T> eVar) {
        return (e<T>) W(t0.c(eVar));
    }

    public final e<T> q(long j2, TimeUnit timeUnit) {
        return r(j2, timeUnit, Schedulers.computation());
    }

    public final rx.o.b<T> q0() {
        return u0.k1(this);
    }

    public final e<T> r(long j2, TimeUnit timeUnit, h hVar) {
        return (e<T>) W(new l0(j2, timeUnit, hVar));
    }

    public final <U> e<T> s(e<U> eVar) {
        eVar.getClass();
        return b1(new rx.n.a.m(this, eVar));
    }

    public final e<T> s0() {
        return y.b(this);
    }

    public final e<T> t() {
        return (e<T>) W(m0.d());
    }

    public final e<T> t0(rx.m.e<? super e<? extends Throwable>, ? extends e<?>> eVar) {
        return y.c(this, rx.n.e.f.g(eVar));
    }

    public final <U> e<T> u(rx.m.e<? super T, ? extends U> eVar) {
        return (e<T>) W(new m0(eVar));
    }

    public final e<T> u0(long j2, TimeUnit timeUnit) {
        return v0(j2, timeUnit, Schedulers.computation());
    }

    public final e<T> v(rx.m.a aVar) {
        return b1(new n(this, new rx.n.e.a(rx.m.c.a(), rx.m.c.a(), aVar)));
    }

    public final e<T> v0(long j2, TimeUnit timeUnit, h hVar) {
        return (e<T>) W(new v0(j2, timeUnit, hVar));
    }

    public final e<T> w(rx.m.b<? super Throwable> bVar) {
        return b1(new n(this, new rx.n.e.a(rx.m.c.a(), bVar, rx.m.c.a())));
    }

    public final e<T> w0() {
        return q0().j1();
    }

    public final e<T> x(rx.m.b<? super T> bVar) {
        return b1(new n(this, new rx.n.e.a(bVar, rx.m.c.a(), rx.m.c.a())));
    }

    public final e<T> x0() {
        return (e<T>) W(w0.b());
    }

    public final e<T> y(rx.m.a aVar) {
        return (e<T>) W(new n0(aVar));
    }

    public final e<T> y0(int i2) {
        return (e<T>) W(new x0(i2));
    }

    public final e<T> z(rx.m.a aVar) {
        return b1(new n(this, new rx.n.e.a(rx.m.c.a(), rx.m.c.b(aVar), aVar)));
    }

    public final e<T> z0(long j2, TimeUnit timeUnit) {
        return A0(j2, timeUnit, Schedulers.computation());
    }
}
