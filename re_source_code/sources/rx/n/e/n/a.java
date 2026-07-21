package rx.n.e.n;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.n.e.o.j;

/* JADX INFO: compiled from: AtomicReferenceArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class a<E> extends AbstractQueue<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final AtomicReferenceArray<E> f26788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final int f26789g;

    public a(int i2) {
        int iB = j.b(i2);
        this.f26789g = iB - 1;
        this.f26788f = new AtomicReferenceArray<>(iB);
    }

    protected final int c(long j2) {
        return this.f26789g & ((int) j2);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    protected final int f(long j2, int i2) {
        return ((int) j2) & i2;
    }

    protected final E g(int i2) {
        return h(this.f26788f, i2);
    }

    protected final E h(AtomicReferenceArray<E> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    protected final void i(AtomicReferenceArray<E> atomicReferenceArray, int i2, E e2) {
        atomicReferenceArray.lazySet(i2, e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
