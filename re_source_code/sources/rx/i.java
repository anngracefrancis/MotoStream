package rx;

import rx.n.e.l;

/* JADX INFO: compiled from: SingleSubscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i<T> implements k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final l f26095f = new l();

    public final void b(k kVar) {
        this.f26095f.a(kVar);
    }

    public abstract void c(T t);

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.f26095f.isUnsubscribed();
    }

    public abstract void onError(Throwable th);

    @Override // rx.k
    public final void unsubscribe() {
        this.f26095f.unsubscribe();
    }
}
