package rx.n.e.o;

/* JADX INFO: compiled from: SpmcArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class q<E> extends m<E> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected static final long f26820k = z.a(q.class, "producerIndex");
    private volatile long producerIndex;

    public q(int i2) {
        super(i2);
    }

    protected final long q() {
        return this.producerIndex;
    }

    protected final void r(long j2) {
        z.a.putOrderedLong(this, f26820k, j2);
    }
}
