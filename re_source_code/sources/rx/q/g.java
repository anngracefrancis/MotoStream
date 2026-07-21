package rx.q;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: RxJavaSchedulersHook.java */
/* JADX INFO: loaded from: classes3.dex */
public class g {
    private static final g a = new g();

    public static rx.h a() {
        return b(new rx.n.e.i("RxComputationScheduler-"));
    }

    public static rx.h b(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new rx.n.c.b(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    public static rx.h c() {
        return d(new rx.n.e.i("RxIoScheduler-"));
    }

    public static rx.h d(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new rx.n.c.a(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    public static rx.h e() {
        return f(new rx.n.e.i("RxNewThreadScheduler-"));
    }

    public static rx.h f(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new rx.n.c.g(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    public static g h() {
        return a;
    }

    public rx.h g() {
        return null;
    }

    public rx.h i() {
        return null;
    }

    public rx.h j() {
        return null;
    }

    @Deprecated
    public rx.m.a k(rx.m.a aVar) {
        return aVar;
    }
}
