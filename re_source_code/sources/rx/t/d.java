package rx.t;

import rx.k;

/* JADX INFO: compiled from: SerialSubscription.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.n.d.a f26911f = new rx.n.d.a();

    public k a() {
        return this.f26911f.a();
    }

    public void b(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.f26911f.c(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.f26911f.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.f26911f.unsubscribe();
    }
}
