package rx.n.a;

/* JADX INFO: compiled from: OnSubscribeLift.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v<T, R> implements rx.e.a<R> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.e.a<T> f26515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final rx.e.b<? extends R, ? super T> f26516g;

    public v(rx.e.a<T> aVar, rx.e.b<? extends R, ? super T> bVar) {
        this.f26515f = aVar;
        this.f26516g = bVar;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> jVarCall = rx.q.c.n(this.f26516g).call(jVar);
            try {
                jVarCall.onStart();
                this.f26515f.call(jVarCall);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                jVarCall.onError(th);
            }
        } catch (Throwable th2) {
            rx.exceptions.a.e(th2);
            jVar.onError(th2);
        }
    }
}
