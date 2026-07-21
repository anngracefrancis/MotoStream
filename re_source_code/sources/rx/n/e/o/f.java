package rx.n.e.o;

import java.util.Iterator;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: ConcurrentCircularArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f<E> extends g<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final int f26815f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f26816g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f26817h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final long f26818i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final E[] f26819j;

    static {
        int iIntValue = Integer.getInteger("sparse.shift", 0).intValue();
        f26815f = iIntValue;
        Unsafe unsafe = z.a;
        int iArrayIndexScale = unsafe.arrayIndexScale(Object[].class);
        if (4 == iArrayIndexScale) {
            f26817h = iIntValue + 2;
        } else {
            if (8 != iArrayIndexScale) {
                throw new IllegalStateException("Unknown pointer size");
            }
            f26817h = iIntValue + 3;
        }
        f26816g = unsafe.arrayBaseOffset(Object[].class) + (32 << (f26817h - iIntValue));
    }

    public f(int i2) {
        int iB = j.b(i2);
        this.f26818i = iB - 1;
        this.f26819j = (E[]) new Object[(iB << f26815f) + 64];
    }

    protected final long c(long j2) {
        return f(j2, this.f26818i);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    protected final long f(long j2, long j3) {
        return f26816g + ((j2 & j3) << f26817h);
    }

    protected final E g(E[] eArr, long j2) {
        return (E) z.a.getObject(eArr, j2);
    }

    protected final E h(long j2) {
        return i(this.f26819j, j2);
    }

    protected final E i(E[] eArr, long j2) {
        return (E) z.a.getObjectVolatile(eArr, j2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    protected final void n(E[] eArr, long j2, E e2) {
        z.a.putOrderedObject(eArr, j2, e2);
    }

    protected final void o(E[] eArr, long j2, E e2) {
        z.a.putObject(eArr, j2, e2);
    }
}
