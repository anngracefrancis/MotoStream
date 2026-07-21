package rx.n.e;

/* JADX INFO: compiled from: ActionSubscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b<T> extends rx.j<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.m.b<? super T> f26727f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final rx.m.b<Throwable> f26728g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final rx.m.a f26729h;

    public b(rx.m.b<? super T> bVar, rx.m.b<Throwable> bVar2, rx.m.a aVar) {
        this.f26727f = bVar;
        this.f26728g = bVar2;
        this.f26729h = aVar;
    }

    @Override // rx.f
    public void onCompleted() {
        this.f26729h.call();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f26728g.call(th);
    }

    @Override // rx.f
    public void onNext(T t) {
        this.f26727f.call(t);
    }
}
