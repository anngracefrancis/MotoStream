package rx.n.e;

/* JADX INFO: compiled from: ActionObserver.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a<T> implements rx.f<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.m.b<? super T> f26724f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final rx.m.b<? super Throwable> f26725g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final rx.m.a f26726h;

    public a(rx.m.b<? super T> bVar, rx.m.b<? super Throwable> bVar2, rx.m.a aVar) {
        this.f26724f = bVar;
        this.f26725g = bVar2;
        this.f26726h = aVar;
    }

    @Override // rx.f
    public void onCompleted() {
        this.f26726h.call();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f26725g.call(th);
    }

    @Override // rx.f
    public void onNext(T t) {
        this.f26724f.call(t);
    }
}
