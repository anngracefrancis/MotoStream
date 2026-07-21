package h.a.z.e.d;

/* JADX INFO: compiled from: ObservableJust.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m<T> extends h.a.m<T> implements h.a.z.c.d<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final T f21572f;

    public m(T t) {
        this.f21572f = t;
    }

    @Override // h.a.z.c.d, java.util.concurrent.Callable
    public T call() {
        return this.f21572f;
    }

    @Override // h.a.m
    protected void x(h.a.q<? super T> qVar) {
        p.a aVar = new p.a(qVar, this.f21572f);
        qVar.b(aVar);
        aVar.run();
    }
}
