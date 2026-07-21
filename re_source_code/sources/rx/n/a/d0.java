package rx.n.a;

/* JADX INFO: compiled from: OnSubscribeThrow.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d0<T> implements rx.e.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Throwable f26169f;

    public d0(Throwable th) {
        this.f26169f = th;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super T> jVar) {
        jVar.onError(this.f26169f);
    }
}
