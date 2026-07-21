package rx.n.e.n;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: LinkedQueueNode.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c<E> extends AtomicReference<c<E>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private E f26792f;

    public c() {
    }

    public E a() {
        E eB = b();
        e(null);
        return eB;
    }

    public E b() {
        return this.f26792f;
    }

    public c<E> c() {
        return get();
    }

    public void d(c<E> cVar) {
        lazySet(cVar);
    }

    public void e(E e2) {
        this.f26792f = e2;
    }

    public c(E e2) {
        e(e2);
    }
}
