package rx.n.a;

/* JADX INFO: compiled from: OperatorDoOnUnsubscribe.java */
/* JADX INFO: loaded from: classes3.dex */
public class o0<T> implements rx.e.b<T, T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final rx.m.a f26365f;

    public o0(rx.m.a aVar) {
        this.f26365f = aVar;
    }

    @Override // rx.m.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super T> jVar) {
        jVar.add(rx.t.e.a(this.f26365f));
        return rx.p.f.c(jVar);
    }
}
