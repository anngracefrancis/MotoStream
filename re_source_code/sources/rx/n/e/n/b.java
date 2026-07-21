package rx.n.e.n;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: BaseLinkedAtomicQueue.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class b<E> extends AbstractQueue<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicReference<c<E>> f26790f = new AtomicReference<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicReference<c<E>> f26791g = new AtomicReference<>();

    protected final c<E> c() {
        return this.f26791g.get();
    }

    protected final c<E> f() {
        return this.f26791g.get();
    }

    protected final c<E> g() {
        return this.f26790f.get();
    }

    protected final void h(c<E> cVar) {
        this.f26791g.lazySet(cVar);
    }

    protected final c<E> i(c<E> cVar) {
        return this.f26790f.getAndSet(cVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return f() == g();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        c<E> cVarC;
        c<E> cVarF = f();
        c<E> cVarG = g();
        int i2 = 0;
        while (cVarF != cVarG && i2 < Integer.MAX_VALUE) {
            do {
                cVarC = cVarF.c();
            } while (cVarC == null);
            i2++;
            cVarF = cVarC;
        }
        return i2;
    }
}
