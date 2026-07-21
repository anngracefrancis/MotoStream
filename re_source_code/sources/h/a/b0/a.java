package h.a.b0;

import h.a.r;
import h.a.z.g.l;
import h.a.z.g.m;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Schedulers.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    static final r a = h.a.a0.a.h(new h());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final r f21436b = h.a.a0.a.e(new b());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final r f21437c = h.a.a0.a.f(new c());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final r f21438d = m.d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final r f21439e = h.a.a0.a.g(new f());

    /* JADX INFO: renamed from: h.a.b0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Schedulers.java */
    static final class C0290a {
        static final r a = new h.a.z.g.b();
    }

    /* JADX INFO: compiled from: Schedulers.java */
    static final class b implements Callable<r> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public r call() throws Exception {
            return C0290a.a;
        }
    }

    /* JADX INFO: compiled from: Schedulers.java */
    static final class c implements Callable<r> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public r call() throws Exception {
            return d.a;
        }
    }

    /* JADX INFO: compiled from: Schedulers.java */
    static final class d {
        static final r a = new h.a.z.g.e();
    }

    /* JADX INFO: compiled from: Schedulers.java */
    static final class e {
        static final r a = new h.a.z.g.f();
    }

    /* JADX INFO: compiled from: Schedulers.java */
    static final class f implements Callable<r> {
        f() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public r call() throws Exception {
            return e.a;
        }
    }

    /* JADX INFO: compiled from: Schedulers.java */
    static final class g {
        static final r a = new l();
    }

    /* JADX INFO: compiled from: Schedulers.java */
    static final class h implements Callable<r> {
        h() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public r call() throws Exception {
            return g.a;
        }
    }

    public static r a(Executor executor) {
        return new h.a.z.g.d(executor, false);
    }

    public static r b() {
        return h.a.a0.a.p(f21437c);
    }

    public static r c() {
        return h.a.a0.a.r(a);
    }
}
