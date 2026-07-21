package rx.n.a;

/* JADX INFO: compiled from: SingleLiftObservableOperator.java */
/* JADX INFO: loaded from: classes3.dex */
final class l1<T> extends rx.i<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final rx.j<? super T> f26331g;

    l1(rx.j<? super T> jVar) {
        this.f26331g = jVar;
    }

    @Override // rx.i
    public void c(T t) {
        this.f26331g.setProducer(new rx.n.b.c(this.f26331g, t));
    }

    @Override // rx.i
    public void onError(Throwable th) {
        this.f26331g.onError(th);
    }
}
