package h.a.z.f;

import h.a.z.c.e;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MpscLinkedQueue.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a<T> implements e<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicReference<C0299a<T>> f21623f = new AtomicReference<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicReference<C0299a<T>> f21624g = new AtomicReference<>();

    /* JADX INFO: renamed from: h.a.z.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MpscLinkedQueue.java */
    static final class C0299a<E> extends AtomicReference<C0299a<E>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private E f21625f;

        C0299a() {
        }

        public E a() {
            E eB = b();
            e(null);
            return eB;
        }

        public E b() {
            return this.f21625f;
        }

        public C0299a<E> c() {
            return get();
        }

        public void d(C0299a<E> c0299a) {
            lazySet(c0299a);
        }

        public void e(E e2) {
            this.f21625f = e2;
        }

        C0299a(E e2) {
            e(e2);
        }
    }

    public a() {
        C0299a<T> c0299a = new C0299a<>();
        d(c0299a);
        e(c0299a);
    }

    C0299a<T> a() {
        return this.f21624g.get();
    }

    C0299a<T> b() {
        return this.f21624g.get();
    }

    C0299a<T> c() {
        return this.f21623f.get();
    }

    @Override // h.a.z.c.f
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    void d(C0299a<T> c0299a) {
        this.f21624g.lazySet(c0299a);
    }

    C0299a<T> e(C0299a<T> c0299a) {
        return this.f21623f.getAndSet(c0299a);
    }

    @Override // h.a.z.c.f
    public boolean isEmpty() {
        return b() == c();
    }

    @Override // h.a.z.c.f
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        C0299a<T> c0299a = new C0299a<>(t);
        e(c0299a).d(c0299a);
        return true;
    }

    @Override // h.a.z.c.e, h.a.z.c.f
    public T poll() {
        C0299a<T> c0299aC;
        C0299a<T> c0299aA = a();
        C0299a<T> c0299aC2 = c0299aA.c();
        if (c0299aC2 != null) {
            T tA = c0299aC2.a();
            d(c0299aC2);
            return tA;
        }
        if (c0299aA == c()) {
            return null;
        }
        do {
            c0299aC = c0299aA.c();
        } while (c0299aC == null);
        T tA2 = c0299aC.a();
        d(c0299aC);
        return tA2;
    }
}
