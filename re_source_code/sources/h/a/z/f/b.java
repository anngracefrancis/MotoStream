package h.a.z.f;

import androidx.recyclerview.widget.RecyclerView;
import h.a.z.c.e;
import h.a.z.j.f;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: SpscArrayQueue.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b<E> extends AtomicReferenceArray<E> implements e<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Integer f21626f = Integer.getInteger("jctools.spsc.max.lookahead.step", RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f21627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final AtomicLong f21628h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f21629i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final AtomicLong f21630j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final int f21631k;

    public b(int i2) {
        super(f.a(i2));
        this.f21627g = length() - 1;
        this.f21628h = new AtomicLong();
        this.f21630j = new AtomicLong();
        this.f21631k = Math.min(i2 / 4, f21626f.intValue());
    }

    int a(long j2) {
        return this.f21627g & ((int) j2);
    }

    int b(long j2, int i2) {
        return ((int) j2) & i2;
    }

    E c(int i2) {
        return get(i2);
    }

    @Override // h.a.z.c.f
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    void d(long j2) {
        this.f21630j.lazySet(j2);
    }

    void e(int i2, E e2) {
        lazySet(i2, e2);
    }

    void f(long j2) {
        this.f21628h.lazySet(j2);
    }

    @Override // h.a.z.c.f
    public boolean isEmpty() {
        return this.f21628h.get() == this.f21630j.get();
    }

    @Override // h.a.z.c.f
    public boolean offer(E e2) {
        if (e2 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        int i2 = this.f21627g;
        long j2 = this.f21628h.get();
        int iB = b(j2, i2);
        if (j2 >= this.f21629i) {
            long j3 = ((long) this.f21631k) + j2;
            if (c(b(j3, i2)) == null) {
                this.f21629i = j3;
            } else if (c(iB) != null) {
                return false;
            }
        }
        e(iB, e2);
        f(j2 + 1);
        return true;
    }

    @Override // h.a.z.c.e, h.a.z.c.f
    public E poll() {
        long j2 = this.f21630j.get();
        int iA = a(j2);
        E eC = c(iA);
        if (eC == null) {
            return null;
        }
        d(j2 + 1);
        e(iA, null);
        return eC;
    }
}
