package e.g.a.a;

import rx.m.d;
import rx.m.e;

/* JADX INFO: compiled from: Functions.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final C0265a<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d<Boolean> f21131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e<Object, Boolean> f21132c;

    /* JADX INFO: renamed from: e.g.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Functions.java */
    private static final class C0265a<T> implements e<Object, T>, d<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final T f21133f;

        C0265a(T t) {
            this.f21133f = t;
        }

        @Override // rx.m.e
        public T call(Object obj) {
            return this.f21133f;
        }

        @Override // rx.m.d, java.util.concurrent.Callable
        public T call() {
            return this.f21133f;
        }
    }

    static {
        C0265a<Boolean> c0265a = new C0265a<>(Boolean.TRUE);
        a = c0265a;
        f21131b = c0265a;
        f21132c = c0265a;
    }
}
