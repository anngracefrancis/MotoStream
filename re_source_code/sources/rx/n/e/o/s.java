package rx.n.e.o;

/* JADX INFO: compiled from: SpscArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s<E> extends x<E> {
    public s(int i2) {
        super(i2);
    }

    private long q() {
        return z.a.getLongVolatile(this, u.n);
    }

    private long r() {
        return z.a.getLongVolatile(this, y.m);
    }

    private void s(long j2) {
        z.a.putOrderedLong(this, u.n, j2);
    }

    private void t(long j2) {
        z.a.putOrderedLong(this, y.m, j2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return r() == q();
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        if (e2 == null) {
            throw new NullPointerException("null elements not allowed");
        }
        E[] eArr = this.f26819j;
        long j2 = this.producerIndex;
        long jC = c(j2);
        if (i(eArr, jC) != null) {
            return false;
        }
        n(eArr, jC, e2);
        t(j2 + 1);
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        return h(c(this.consumerIndex));
    }

    @Override // java.util.Queue, rx.n.e.o.h
    public E poll() {
        long j2 = this.consumerIndex;
        long jC = c(j2);
        E[] eArr = this.f26819j;
        E eI = i(eArr, jC);
        if (eI == null) {
            return null;
        }
        n(eArr, jC, null);
        s(j2 + 1);
        return eI;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long jQ = q();
        while (true) {
            long jR = r();
            long jQ2 = q();
            if (jQ == jQ2) {
                return (int) (jR - jQ2);
            }
            jQ = jQ2;
        }
    }
}
