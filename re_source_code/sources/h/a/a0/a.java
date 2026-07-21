package h.a.a0;

import h.a.b;
import h.a.d;
import h.a.h;
import h.a.j;
import h.a.k;
import h.a.m;
import h.a.q;
import h.a.r;
import h.a.s;
import h.a.u;
import h.a.y.e;
import h.a.y.f;
import h.a.z.j.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: RxJavaPlugins.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    static volatile e<? super Throwable> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile f<? super Runnable, ? extends Runnable> f21426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static volatile f<? super Callable<r>, ? extends r> f21427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static volatile f<? super Callable<r>, ? extends r> f21428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static volatile f<? super Callable<r>, ? extends r> f21429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static volatile f<? super Callable<r>, ? extends r> f21430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static volatile f<? super r, ? extends r> f21431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static volatile f<? super r, ? extends r> f21432h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static volatile f<? super h, ? extends h> f21433i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static volatile f<? super m, ? extends m> f21434j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static volatile f<? super j, ? extends j> f21435k;
    static volatile f<? super s, ? extends s> l;
    static volatile f<? super b, ? extends b> m;
    static volatile h.a.y.b<? super h, ? super k.a.b, ? extends k.a.b> n;
    static volatile h.a.y.b<? super j, ? super k, ? extends k> o;
    static volatile h.a.y.b<? super m, ? super q, ? extends q> p;
    static volatile h.a.y.b<? super s, ? super u, ? extends u> q;
    static volatile h.a.y.b<? super b, ? super d, ? extends d> r;

    static <T, U, R> R a(h.a.y.b<T, U, R> bVar, T t, U u) {
        try {
            return bVar.a(t, u);
        } catch (Throwable th) {
            throw c.c(th);
        }
    }

    static <T, R> R b(f<T, R> fVar, T t) {
        try {
            return fVar.a(t);
        } catch (Throwable th) {
            throw c.c(th);
        }
    }

    static r c(f<? super Callable<r>, ? extends r> fVar, Callable<r> callable) {
        return (r) h.a.z.b.b.c(b(fVar, callable), "Scheduler Callable result can't be null");
    }

    static r d(Callable<r> callable) {
        try {
            return (r) h.a.z.b.b.c(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw c.c(th);
        }
    }

    public static r e(Callable<r> callable) {
        h.a.z.b.b.c(callable, "Scheduler Callable can't be null");
        f<? super Callable<r>, ? extends r> fVar = f21427c;
        return fVar == null ? d(callable) : c(fVar, callable);
    }

    public static r f(Callable<r> callable) {
        h.a.z.b.b.c(callable, "Scheduler Callable can't be null");
        f<? super Callable<r>, ? extends r> fVar = f21429e;
        return fVar == null ? d(callable) : c(fVar, callable);
    }

    public static r g(Callable<r> callable) {
        h.a.z.b.b.c(callable, "Scheduler Callable can't be null");
        f<? super Callable<r>, ? extends r> fVar = f21430f;
        return fVar == null ? d(callable) : c(fVar, callable);
    }

    public static r h(Callable<r> callable) {
        h.a.z.b.b.c(callable, "Scheduler Callable can't be null");
        f<? super Callable<r>, ? extends r> fVar = f21428d;
        return fVar == null ? d(callable) : c(fVar, callable);
    }

    static boolean i(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    public static b j(b bVar) {
        f<? super b, ? extends b> fVar = m;
        return fVar != null ? (b) b(fVar, bVar) : bVar;
    }

    public static <T> h<T> k(h<T> hVar) {
        f<? super h, ? extends h> fVar = f21433i;
        return fVar != null ? (h) b(fVar, hVar) : hVar;
    }

    public static <T> j<T> l(j<T> jVar) {
        f<? super j, ? extends j> fVar = f21435k;
        return fVar != null ? (j) b(fVar, jVar) : jVar;
    }

    public static <T> m<T> m(m<T> mVar) {
        f<? super m, ? extends m> fVar = f21434j;
        return fVar != null ? (m) b(fVar, mVar) : mVar;
    }

    public static <T> s<T> n(s<T> sVar) {
        f<? super s, ? extends s> fVar = l;
        return fVar != null ? (s) b(fVar, sVar) : sVar;
    }

    public static void o(Throwable th) {
        e<? super Throwable> eVar = a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!i(th)) {
            th = new UndeliverableException(th);
        }
        if (eVar != null) {
            try {
                eVar.a(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                x(th2);
            }
        }
        th.printStackTrace();
        x(th);
    }

    public static r p(r rVar) {
        f<? super r, ? extends r> fVar = f21432h;
        return fVar == null ? rVar : (r) b(fVar, rVar);
    }

    public static Runnable q(Runnable runnable) {
        h.a.z.b.b.c(runnable, "run is null");
        f<? super Runnable, ? extends Runnable> fVar = f21426b;
        return fVar == null ? runnable : (Runnable) b(fVar, runnable);
    }

    public static r r(r rVar) {
        f<? super r, ? extends r> fVar = f21431g;
        return fVar == null ? rVar : (r) b(fVar, rVar);
    }

    public static d s(b bVar, d dVar) {
        h.a.y.b<? super b, ? super d, ? extends d> bVar2 = r;
        return bVar2 != null ? (d) a(bVar2, bVar, dVar) : dVar;
    }

    public static <T> k<? super T> t(j<T> jVar, k<? super T> kVar) {
        h.a.y.b<? super j, ? super k, ? extends k> bVar = o;
        return bVar != null ? (k) a(bVar, jVar, kVar) : kVar;
    }

    public static <T> q<? super T> u(m<T> mVar, q<? super T> qVar) {
        h.a.y.b<? super m, ? super q, ? extends q> bVar = p;
        return bVar != null ? (q) a(bVar, mVar, qVar) : qVar;
    }

    public static <T> u<? super T> v(s<T> sVar, u<? super T> uVar) {
        h.a.y.b<? super s, ? super u, ? extends u> bVar = q;
        return bVar != null ? (u) a(bVar, sVar, uVar) : uVar;
    }

    public static <T> k.a.b<? super T> w(h<T> hVar, k.a.b<? super T> bVar) {
        h.a.y.b<? super h, ? super k.a.b, ? extends k.a.b> bVar2 = n;
        return bVar2 != null ? (k.a.b) a(bVar2, hVar, bVar) : bVar;
    }

    static void x(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }
}
