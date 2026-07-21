package rx;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import rx.n.a.h1;
import rx.n.a.i1;
import rx.n.a.j1;
import rx.n.a.m1;
import rx.n.a.n1;
import rx.n.a.o1;
import rx.n.a.p1;
import rx.n.a.q1;
import rx.n.a.r1;
import rx.n.a.s1;
import rx.n.a.t1;
import rx.n.e.m;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class Single<T> {
    final j<T> a;

    /* JADX INFO: loaded from: classes3.dex */
    class a extends rx.i<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ rx.m.b f25984g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ rx.m.b f25985h;

        a(rx.m.b bVar, rx.m.b bVar2) {
            this.f25984g = bVar;
            this.f25985h = bVar2;
        }

        @Override // rx.i
        public final void c(T t) {
            try {
                this.f25985h.call(t);
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.i
        public final void onError(Throwable th) {
            try {
                this.f25984g.call(th);
            } finally {
                unsubscribe();
            }
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    class b implements j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.h f25987f;

        class a implements rx.m.a {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ rx.i f25989f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ rx.h.a f25990g;

            /* JADX INFO: renamed from: rx.Single$b$a$a, reason: collision with other inner class name */
            class C0428a extends rx.i<T> {
                C0428a() {
                }

                @Override // rx.i
                public void c(T t) {
                    try {
                        a.this.f25989f.c(t);
                    } finally {
                        a.this.f25990g.unsubscribe();
                    }
                }

                @Override // rx.i
                public void onError(Throwable th) {
                    try {
                        a.this.f25989f.onError(th);
                    } finally {
                        a.this.f25990g.unsubscribe();
                    }
                }
            }

            a(rx.i iVar, rx.h.a aVar) {
                this.f25989f = iVar;
                this.f25990g = aVar;
            }

            @Override // rx.m.a
            public void call() {
                C0428a c0428a = new C0428a();
                this.f25989f.b(c0428a);
                Single.this.t(c0428a);
            }
        }

        b(rx.h hVar) {
            this.f25987f = hVar;
        }

        @Override // rx.m.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.i<? super T> iVar) {
            rx.h.a aVarCreateWorker = this.f25987f.createWorker();
            iVar.b(aVarCreateWorker);
            aVarCreateWorker.c(new a(iVar, aVarCreateWorker));
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    class c implements rx.m.d<Single<T>> {
        c() {
        }

        @Override // rx.m.d, java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Single<T> call() {
            return Single.h(new TimeoutException());
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    class d implements rx.m.b<Throwable> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.m.b f25994f;

        d(rx.m.b bVar) {
            this.f25994f = bVar;
        }

        @Override // rx.m.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
            this.f25994f.call(th);
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    static class e implements j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Callable f25996f;

        e(Callable callable) {
            this.f25996f = callable;
        }

        @Override // rx.m.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.i<? super T> iVar) {
            try {
                ((Single) this.f25996f.call()).t(iVar);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                iVar.onError(th);
            }
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    static class f implements j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Throwable f25997f;

        f(Throwable th) {
            this.f25997f = th;
        }

        @Override // rx.m.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.i<? super T> iVar) {
            iVar.onError(this.f25997f);
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    static class g implements j<T> {

        class a extends rx.i<Single<? extends T>> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ rx.i f25999g;

            a(rx.i iVar) {
                this.f25999g = iVar;
            }

            @Override // rx.i
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void c(Single<? extends T> single) {
                single.t(this.f25999g);
            }

            @Override // rx.i
            public void onError(Throwable th) {
                this.f25999g.onError(th);
            }
        }

        g() {
        }

        @Override // rx.m.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.i<? super T> iVar) {
            a aVar = new a(iVar);
            iVar.b(aVar);
            Single.this.t(aVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: loaded from: classes3.dex */
    static class h<R> implements rx.m.h<R> {
        final /* synthetic */ rx.m.f a;

        h(rx.m.f fVar) {
            this.a = fVar;
        }

        @Override // rx.m.h
        public R call(Object... objArr) {
            return (R) this.a.a(objArr[0], objArr[1]);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: loaded from: classes3.dex */
    static class i<R> implements rx.m.h<R> {
        final /* synthetic */ rx.m.g a;

        i(rx.m.g gVar) {
            this.a = gVar;
        }

        @Override // rx.m.h
        public R call(Object... objArr) {
            return (R) this.a.a(objArr[0], objArr[1], objArr[2]);
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface j<T> extends rx.m.b<rx.i<? super T>> {
    }

    protected Single(j<T> jVar) {
        this.a = rx.q.c.i(jVar);
    }

    public static <T1, T2, T3, R> Single<R> B(Single<? extends T1> single, Single<? extends T2> single2, Single<? extends T3> single3, rx.m.g<? super T1, ? super T2, ? super T3, ? extends R> gVar) {
        return r1.a(new Single[]{single, single2, single3}, new i(gVar));
    }

    public static <T1, T2, R> Single<R> C(Single<? extends T1> single, Single<? extends T2> single2, rx.m.f<? super T1, ? super T2, ? extends R> fVar) {
        return r1.a(new Single[]{single, single2}, new h(fVar));
    }

    private static <T> rx.e<T> a(Single<T> single) {
        return rx.e.b1(new t1(single.a));
    }

    public static <T> Single<T> b(j<T> jVar) {
        return new Single<>(jVar);
    }

    public static <T> Single<T> c(Callable<Single<T>> callable) {
        return b(new e(callable));
    }

    public static <T> Single<T> h(Throwable th) {
        return b(new f(th));
    }

    public static <T> Single<T> l(Callable<? extends T> callable) {
        return b(new j1(callable));
    }

    public static <T> Single<T> m(T t) {
        return rx.n.e.k.D(t);
    }

    public static <T> Single<T> o(Single<? extends Single<? extends T>> single) {
        return single instanceof rx.n.e.k ? ((rx.n.e.k) single).E(m.b()) : b(new g());
    }

    public final rx.e<T> A() {
        return a(this);
    }

    public final Single<T> d(rx.e<?> eVar) {
        eVar.getClass();
        return b(new o1(this, eVar));
    }

    public final Single<T> e(rx.m.b<Throwable> bVar) {
        if (bVar != null) {
            return b(new h1(this, rx.m.c.a(), new d(bVar)));
        }
        throw new IllegalArgumentException("onError is null");
    }

    public final Single<T> f(rx.m.a aVar) {
        return b(new i1(this.a, aVar));
    }

    public final Single<T> g(rx.m.b<? super T> bVar) {
        if (bVar != null) {
            return b(new h1(this, bVar, rx.m.c.a()));
        }
        throw new IllegalArgumentException("onSuccess is null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Single<R> i(rx.m.e<? super T, ? extends Single<? extends R>> eVar) {
        return this instanceof rx.n.e.k ? ((rx.n.e.k) this).E(eVar) : o(n(eVar));
    }

    public final rx.b j(rx.m.e<? super T, ? extends rx.b> eVar) {
        return rx.b.h(new rx.n.a.c(this, eVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> rx.e<R> k(rx.m.e<? super T, ? extends rx.e<? extends R>> eVar) {
        return rx.e.Z(a(n(eVar)));
    }

    public final <R> Single<R> n(rx.m.e<? super T, ? extends R> eVar) {
        return b(new p1(this, eVar));
    }

    public final Single<T> p(rx.h hVar) {
        if (this instanceof rx.n.e.k) {
            return ((rx.n.e.k) this).F(hVar);
        }
        if (hVar != null) {
            return b(new m1(this.a, hVar));
        }
        throw new NullPointerException("scheduler is null");
    }

    public final Single<T> q(rx.m.e<Throwable, ? extends Single<? extends T>> eVar) {
        return new Single<>(q1.b(this, eVar));
    }

    public final Single<T> r(rx.m.e<Throwable, ? extends T> eVar) {
        return b(new n1(this.a, eVar));
    }

    public final Single<T> s(rx.m.e<rx.e<? extends Throwable>, ? extends rx.e<?>> eVar) {
        return A().t0(eVar).Z0();
    }

    public final k t(rx.i<? super T> iVar) {
        if (iVar == null) {
            throw new IllegalArgumentException("te is null");
        }
        try {
            rx.q.c.t(this, this.a).call(iVar);
            return rx.q.c.s(iVar);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            try {
                iVar.onError(rx.q.c.r(th));
                return rx.t.e.b();
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                rx.q.c.r(runtimeException);
                throw runtimeException;
            }
        }
    }

    public final k u(rx.m.b<? super T> bVar, rx.m.b<Throwable> bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        if (bVar2 != null) {
            return t(new a(bVar2, bVar));
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    public final Single<T> v(rx.h hVar) {
        return this instanceof rx.n.e.k ? ((rx.n.e.k) this).F(hVar) : b(new b(hVar));
    }

    public final Single<T> w(long j2, TimeUnit timeUnit) {
        return x(j2, timeUnit, null, Schedulers.computation());
    }

    public final Single<T> x(long j2, TimeUnit timeUnit, Single<? extends T> single, rx.h hVar) {
        if (single == null) {
            single = c(new c());
        }
        return b(new s1(this.a, j2, timeUnit, hVar, single.a));
    }

    public final rx.r.a<T> y() {
        return rx.r.a.a(this);
    }

    public final rx.b z() {
        return rx.b.w(this);
    }
}
