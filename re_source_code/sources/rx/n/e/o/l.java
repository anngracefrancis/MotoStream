package rx.n.e.o;

/* JADX INFO: compiled from: SpmcArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class l<E> extends n<E> {
    protected static final long l = z.a(l.class, "consumerIndex");
    private volatile long consumerIndex;

    public l(int i2) {
        super(i2);
    }

    protected final boolean s(long j2, long j3) {
        return z.a.compareAndSwapLong(this, l, j2, j3);
    }

    protected final long t() {
        return this.consumerIndex;
    }
}
