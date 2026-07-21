package rx;

import rx.n.e.l;

/* JADX INFO: compiled from: Subscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j<T> implements f<T>, k {
    private static final long NOT_SET = Long.MIN_VALUE;
    private g producer;
    private long requested;
    private final j<?> subscriber;
    private final l subscriptions;

    protected j() {
        this(null, false);
    }

    private void addToRequested(long j2) {
        long j3 = this.requested;
        if (j3 == NOT_SET) {
            this.requested = j2;
            return;
        }
        long j4 = j3 + j2;
        if (j4 < 0) {
            this.requested = Long.MAX_VALUE;
        } else {
            this.requested = j4;
        }
    }

    public final void add(k kVar) {
        this.subscriptions.a(kVar);
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    public void onStart() {
    }

    protected final void request(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("number requested cannot be negative: " + j2);
        }
        synchronized (this) {
            g gVar = this.producer;
            if (gVar != null) {
                gVar.request(j2);
            } else {
                addToRequested(j2);
            }
        }
    }

    public void setProducer(g gVar) {
        long j2;
        j<?> jVar;
        boolean z;
        synchronized (this) {
            j2 = this.requested;
            this.producer = gVar;
            jVar = this.subscriber;
            z = jVar != null && j2 == NOT_SET;
        }
        if (z) {
            jVar.setProducer(gVar);
        } else if (j2 == NOT_SET) {
            gVar.request(Long.MAX_VALUE);
        } else {
            gVar.request(j2);
        }
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    protected j(j<?> jVar) {
        this(jVar, true);
    }

    protected j(j<?> jVar, boolean z) {
        this.requested = NOT_SET;
        this.subscriber = jVar;
        this.subscriptions = (!z || jVar == null) ? new l() : jVar.subscriptions;
    }
}
