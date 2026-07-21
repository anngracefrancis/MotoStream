package rx.n.a;

/* JADX INFO: compiled from: OnSubscribeDefer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l<T> implements rx.e.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.m.d<? extends rx.e<? extends T>> f26318f;

    public l(rx.m.d<? extends rx.e<? extends T>> dVar) {
        this.f26318f = dVar;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super T> jVar) {
        try {
            this.f26318f.call().c1(rx.p.f.c(jVar));
        } catch (Throwable th) {
            rx.exceptions.a.f(th, jVar);
        }
    }
}
