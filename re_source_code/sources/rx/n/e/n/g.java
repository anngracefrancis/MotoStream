package rx.n.e.n;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.n.e.o.j;

/* JADX INFO: compiled from: SpscLinkedArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g<T> implements Queue<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f26801f = Integer.getInteger("jctools.spsc.max.lookahead.step", RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT).intValue();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f26802g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final AtomicLong f26803h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f26804i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    long f26805j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f26806k;
    AtomicReferenceArray<Object> l;
    int m;
    AtomicReferenceArray<Object> n;
    final AtomicLong o;

    public g(int i2) {
        int iB = j.b(i2);
        int i3 = iB - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(iB + 1);
        this.l = atomicReferenceArray;
        this.f26806k = i3;
        c(iB);
        this.n = atomicReferenceArray;
        this.m = i3;
        this.f26805j = i3 - 1;
        this.f26803h = new AtomicLong();
        this.o = new AtomicLong();
    }

    private boolean A(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i2) {
        x(atomicReferenceArray, i2, t);
        z(j2 + 1);
        return true;
    }

    private void c(int i2) {
        this.f26804i = Math.min(i2 / 4, f26801f);
    }

    private static int f(int i2) {
        return i2;
    }

    private static int g(long j2, int i2) {
        return f(((int) j2) & i2);
    }

    private long h() {
        return this.o.get();
    }

    private long i() {
        return this.f26803h.get();
    }

    private long n() {
        return this.o.get();
    }

    private static <E> Object o(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    private AtomicReferenceArray<Object> q(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) o(atomicReferenceArray, f(atomicReferenceArray.length() - 1));
    }

    private long r() {
        return this.f26803h.get();
    }

    private T s(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.n = atomicReferenceArray;
        return (T) o(atomicReferenceArray, g(j2, i2));
    }

    private T t(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.n = atomicReferenceArray;
        int iG = g(j2, i2);
        T t = (T) o(atomicReferenceArray, iG);
        if (t == null) {
            return null;
        }
        x(atomicReferenceArray, iG, null);
        w(j2 + 1);
        return t;
    }

    private void v(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2, T t, long j3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.l = atomicReferenceArray2;
        this.f26805j = (j3 + j2) - 1;
        x(atomicReferenceArray2, i2, t);
        y(atomicReferenceArray, atomicReferenceArray2);
        x(atomicReferenceArray, i2, f26802g);
        z(j2 + 1);
    }

    private void w(long j2) {
        this.o.lazySet(j2);
    }

    private static void x(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    private void y(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        x(atomicReferenceArray, f(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void z(long j2) {
        this.f26803h.lazySet(j2);
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
        return r() == n();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.l;
        long jI = i();
        int i2 = this.f26806k;
        int iG = g(jI, i2);
        if (jI < this.f26805j) {
            return A(atomicReferenceArray, t, jI, iG);
        }
        long j2 = ((long) this.f26804i) + jI;
        if (o(atomicReferenceArray, g(j2, i2)) == null) {
            this.f26805j = j2 - 1;
            return A(atomicReferenceArray, t, jI, iG);
        }
        if (o(atomicReferenceArray, g(1 + jI, i2)) == null) {
            return A(atomicReferenceArray, t, jI, iG);
        }
        v(atomicReferenceArray, jI, iG, t, i2);
        return true;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.n;
        long jH = h();
        int i2 = this.m;
        T t = (T) o(atomicReferenceArray, g(jH, i2));
        return t == f26802g ? s(q(atomicReferenceArray), jH, i2) : t;
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.n;
        long jH = h();
        int i2 = this.m;
        int iG = g(jH, i2);
        T t = (T) o(atomicReferenceArray, iG);
        boolean z = t == f26802g;
        if (t == null || z) {
            if (z) {
                return t(q(atomicReferenceArray), jH, i2);
            }
            return null;
        }
        x(atomicReferenceArray, iG, null);
        w(jH + 1);
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
        long jN = n();
        while (true) {
            long jR = r();
            long jN2 = n();
            if (jN == jN2) {
                return (int) (jR - jN2);
            }
            jN = jN2;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public boolean u(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.l;
        long jR = r();
        int i2 = this.f26806k;
        long j2 = 2 + jR;
        if (o(atomicReferenceArray, g(j2, i2)) == null) {
            int iG = g(jR, i2);
            x(atomicReferenceArray, iG + 1, t2);
            x(atomicReferenceArray, iG, t);
            z(j2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.l = atomicReferenceArray2;
        int iG2 = g(jR, i2);
        x(atomicReferenceArray2, iG2 + 1, t2);
        x(atomicReferenceArray2, iG2, t);
        y(atomicReferenceArray, atomicReferenceArray2);
        x(atomicReferenceArray, iG2, f26802g);
        z(j2);
        return true;
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
