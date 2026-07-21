package e.g.b;

/* JADX INFO: compiled from: PublishRelay.java */
/* JADX INFO: loaded from: classes.dex */
public class c<T> extends d<T, T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e<T> f21196g;

    protected c(rx.e.a<T> aVar, e<T> eVar) {
        super(aVar);
        this.f21196g = eVar;
    }

    public static <T> c<T> f1() {
        e eVar = new e();
        return new c<>(eVar, eVar);
    }

    @Override // rx.m.b
    public void call(T t) {
        for (e.b<T> bVar : this.f21196g.f()) {
            bVar.onNext(t);
        }
    }
}
