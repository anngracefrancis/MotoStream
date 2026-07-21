package h.a.z.b;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: Functions.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    static final h.a.y.f<Object, Object> a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Runnable f21452b = new e();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h.a.y.a f21453c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final h.a.y.e<Object> f21454d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h.a.y.e<Throwable> f21455e = new f();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h.a.y.e<Throwable> f21456f = new m();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final h.a.y.g f21457g = new d();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final h.a.y.h<Object> f21458h = new n();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final h.a.y.h<Object> f21459i = new g();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final Callable<Object> f21460j = new l();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final Comparator<Object> f21461k = new k();
    public static final h.a.y.e<k.a.c> l = new j();

    /* JADX INFO: renamed from: h.a.z.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Functions.java */
    static final class CallableC0291a<T> implements Callable<List<T>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f21462f;

        CallableC0291a(int i2) {
            this.f21462f = i2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<T> call() throws Exception {
            return new ArrayList(this.f21462f);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class b implements h.a.y.a {
        b() {
        }

        @Override // h.a.y.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class c implements h.a.y.e<Object> {
        c() {
        }

        @Override // h.a.y.e
        public void a(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class d implements h.a.y.g {
        d() {
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class f implements h.a.y.e<Throwable> {
        f() {
        }

        @Override // h.a.y.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Throwable th) {
            h.a.a0.a.o(th);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class g implements h.a.y.h<Object> {
        g() {
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class h implements h.a.y.f<Object, Object> {
        h() {
        }

        @Override // h.a.y.f
        public Object a(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class i<T, U> implements Callable<U>, h.a.y.f<T, U> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final U f21463f;

        i(U u) {
            this.f21463f = u;
        }

        @Override // h.a.y.f
        public U a(T t) throws Exception {
            return this.f21463f;
        }

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.f21463f;
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class j implements h.a.y.e<k.a.c> {
        j() {
        }

        @Override // h.a.y.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k.a.c cVar) throws Exception {
            cVar.request(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class k implements Comparator<Object> {
        k() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class l implements Callable<Object> {
        l() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class m implements h.a.y.e<Throwable> {
        m() {
        }

        @Override // h.a.y.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Throwable th) {
            h.a.a0.a.o(new OnErrorNotImplementedException(th));
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class n implements h.a.y.h<Object> {
        n() {
        }
    }

    public static <T> Callable<List<T>> a(int i2) {
        return new CallableC0291a(i2);
    }

    public static <T> h.a.y.e<T> b() {
        return (h.a.y.e<T>) f21454d;
    }

    public static <T> Callable<T> c(T t) {
        return new i(t);
    }
}
