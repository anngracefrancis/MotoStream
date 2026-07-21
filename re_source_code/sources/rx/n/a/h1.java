package rx.n.a;

import rx.Single;
import rx.exceptions.CompositeException;

/* JADX INFO: compiled from: SingleDoOnEvent.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h1<T> implements Single.j<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Single<T> f26252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final rx.m.b<? super T> f26253g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final rx.m.b<Throwable> f26254h;

    /* JADX INFO: compiled from: SingleDoOnEvent.java */
    static final class a<T> extends rx.i<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final rx.i<? super T> f26255g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final rx.m.b<? super T> f26256h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final rx.m.b<Throwable> f26257i;

        a(rx.i<? super T> iVar, rx.m.b<? super T> bVar, rx.m.b<Throwable> bVar2) {
            this.f26255g = iVar;
            this.f26256h = bVar;
            this.f26257i = bVar2;
        }

        @Override // rx.i
        public void c(T t) {
            try {
                this.f26256h.call(t);
                this.f26255g.c(t);
            } catch (Throwable th) {
                rx.exceptions.a.i(th, this, t);
            }
        }

        @Override // rx.i
        public void onError(Throwable th) {
            try {
                this.f26257i.call(th);
                this.f26255g.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                this.f26255g.onError(new CompositeException(th, th2));
            }
        }
    }

    public h1(Single<T> single, rx.m.b<? super T> bVar, rx.m.b<Throwable> bVar2) {
        this.f26252f = single;
        this.f26253g = bVar;
        this.f26254h = bVar2;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar, this.f26253g, this.f26254h);
        iVar.b(aVar);
        this.f26252f.t(aVar);
    }
}
