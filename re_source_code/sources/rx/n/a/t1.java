package rx.n.a;

import rx.Single;

/* JADX INFO: compiled from: SingleToObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t1<T> implements rx.e.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Single.j<T> f26499f;

    public t1(Single.j<T> jVar) {
        this.f26499f = jVar;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super T> jVar) {
        l1 l1Var = new l1(jVar);
        jVar.add(l1Var);
        this.f26499f.call(l1Var);
    }
}
