package h.a.z.f;

import androidx.recyclerview.widget.RecyclerView;
import h.a.z.c.e;
import h.a.z.j.f;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: SpscLinkedArrayQueue.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c<T> implements e<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f21632f = Integer.getInteger("jctools.spsc.max.lookahead.step", RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT).intValue();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f21633g = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f21635i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    long f21636j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final int f21637k;
    AtomicReferenceArray<Object> l;
    final int m;
    AtomicReferenceArray<Object> n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final AtomicLong f21634h = new AtomicLong();
    final AtomicLong o = new AtomicLong();

    public c(int i2) {
        int iA = f.a(Math.max(8, i2));
        int i3 = iA - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(iA + 1);
        this.l = atomicReferenceArray;
        this.f21637k = i3;
        a(iA);
        this.n = atomicReferenceArray;
        this.m = i3;
        this.f21636j = i3 - 1;
        p(0L);
    }

    private void a(int i2) {
        this.f21635i = Math.min(i2 / 4, f21632f);
    }

    private static int b(int i2) {
        return i2;
    }

    private static int c(long j2, int i2) {
        return b(((int) j2) & i2);
    }

    private long d() {
        return this.o.get();
    }

    private long e() {
        return this.f21634h.get();
    }

    private long f() {
        return this.o.get();
    }

    private static <E> Object h(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    private AtomicReferenceArray<Object> i(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        int iB = b(i2);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) h(atomicReferenceArray, iB);
        n(atomicReferenceArray, iB, null);
        return atomicReferenceArray2;
    }

    private long j() {
        return this.f21634h.get();
    }

    private T k(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.n = atomicReferenceArray;
        int iC = c(j2, i2);
        T t = (T) h(atomicReferenceArray, iC);
        if (t != null) {
            n(atomicReferenceArray, iC, null);
            m(j2 + 1);
        }
        return t;
    }

    private void l(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2, T t, long j3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.l = atomicReferenceArray2;
        this.f21636j = (j3 + j2) - 1;
        n(atomicReferenceArray2, i2, t);
        o(atomicReferenceArray, atomicReferenceArray2);
        n(atomicReferenceArray, i2, f21633g);
        p(j2 + 1);
    }

    private void m(long j2) {
        this.o.lazySet(j2);
    }

    private static void n(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    private void o(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        n(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void p(long j2) {
        this.f21634h.lazySet(j2);
    }

    private boolean q(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i2) {
        n(atomicReferenceArray, i2, t);
        p(j2 + 1);
        return true;
    }

    @Override // h.a.z.c.f
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // h.a.z.c.f
    public boolean isEmpty() {
        return j() == f();
    }

    @Override // h.a.z.c.f
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.l;
        long jE = e();
        int i2 = this.f21637k;
        int iC = c(jE, i2);
        if (jE < this.f21636j) {
            return q(atomicReferenceArray, t, jE, iC);
        }
        long j2 = ((long) this.f21635i) + jE;
        if (h(atomicReferenceArray, c(j2, i2)) == null) {
            this.f21636j = j2 - 1;
            return q(atomicReferenceArray, t, jE, iC);
        }
        if (h(atomicReferenceArray, c(1 + jE, i2)) == null) {
            return q(atomicReferenceArray, t, jE, iC);
        }
        l(atomicReferenceArray, jE, iC, t, i2);
        return true;
    }

    @Override // h.a.z.c.e, h.a.z.c.f
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.n;
        long jD = d();
        int i2 = this.m;
        int iC = c(jD, i2);
        T t = (T) h(atomicReferenceArray, iC);
        boolean z = t == f21633g;
        if (t == null || z) {
            if (z) {
                return k(i(atomicReferenceArray, i2 + 1), jD, i2);
            }
            return null;
        }
        n(atomicReferenceArray, iC, null);
        m(jD + 1);
        return t;
    }
}
