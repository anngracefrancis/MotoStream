package rx.n.a;

import rx.Single;

/* JADX INFO: compiled from: SingleDoOnSubscribe.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i1<T> implements Single.j<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Single.j<T> f26261f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final rx.m.a f26262g;

    public i1(Single.j<T> jVar, rx.m.a aVar) {
        this.f26261f = jVar;
        this.f26262g = aVar;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.i<? super T> iVar) {
        try {
            this.f26262g.call();
            this.f26261f.call(iVar);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            iVar.onError(th);
        }
    }
}
