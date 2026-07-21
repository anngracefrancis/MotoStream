package rx.n.e.o;

/* JADX INFO: compiled from: SpmcArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class r<E> extends p<E> {
    private volatile long m;

    public r(int i2) {
        super(i2);
    }

    protected final long u() {
        return this.m;
    }

    protected final void v(long j2) {
        this.m = j2;
    }
}
