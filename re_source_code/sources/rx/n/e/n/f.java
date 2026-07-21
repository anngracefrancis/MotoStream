package rx.n.e.n;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.n.e.o.j;

/* JADX INFO: compiled from: SpscExactAtomicArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f<T> extends AtomicReferenceArray<T> implements Queue<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f26797f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f26798g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final AtomicLong f26799h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final AtomicLong f26800i;

    public f(int i2) {
        super(j.b(i2));
        int length = length();
        this.f26797f = length - 1;
        this.f26798g = length - i2;
        this.f26799h = new AtomicLong();
        this.f26800i = new AtomicLong();
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T element() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f26799h == this.f26800i;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        t.getClass();
        long j2 = this.f26799h.get();
        int i2 = this.f26797f;
        if (get(((int) (((long) this.f26798g) + j2)) & i2) != null) {
            return false;
        }
        this.f26799h.lazySet(j2 + 1);
        lazySet(i2 & ((int) j2), t);
        return true;
    }

    @Override // java.util.Queue
    public T peek() {
        return get(this.f26797f & ((int) this.f26800i.get()));
    }

    @Override // java.util.Queue
    public T poll() {
        long j2 = this.f26800i.get();
        int i2 = ((int) j2) & this.f26797f;
        T t = get(i2);
        if (t == null) {
            return null;
        }
        this.f26800i.lazySet(j2 + 1);
        lazySet(i2, null);
        return t;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public int size() {
        long j2 = this.f26800i.get();
        while (true) {
            long j3 = this.f26799h.get();
            long j4 = this.f26800i.get();
            if (j2 == j4) {
                return (int) (j3 - j4);
            }
            j2 = j4;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }
}
