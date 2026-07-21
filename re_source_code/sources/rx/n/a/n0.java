package rx.n.a;

/* JADX INFO: compiled from: OperatorDoOnSubscribe.java */
/* JADX INFO: loaded from: classes3.dex */
public class n0<T> implements rx.e.b<T, T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final rx.m.a f26355f;

    public n0(rx.m.a aVar) {
        this.f26355f = aVar;
    }

    @Override // rx.m.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super T> jVar) {
        this.f26355f.call();
        return rx.p.f.c(jVar);
    }
}
