package rx.t;

import rx.k;

/* JADX INFO: compiled from: MultipleAssignmentSubscription.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.n.d.a f26910f = new rx.n.d.a();

    public void a(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.f26910f.b(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.f26910f.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.f26910f.unsubscribe();
    }
}
