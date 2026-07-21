package rx.n.a;

import rx.Single;
import rx.exceptions.OnErrorThrowable;

/* JADX INFO: compiled from: SingleOnSubscribeMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p1<T, R> implements Single.j<R> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Single<T> f26400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final rx.m.e<? super T, ? extends R> f26401g;

    /* JADX INFO: compiled from: SingleOnSubscribeMap.java */
    static final class a<T, R> extends rx.i<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final rx.i<? super R> f26402g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final rx.m.e<? super T, ? extends R> f26403h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f26404i;

        public a(rx.i<? super R> iVar, rx.m.e<? super T, ? extends R> eVar) {
            this.f26402g = iVar;
            this.f26403h = eVar;
        }

        @Override // rx.i
        public void c(T t) {
            try {
                this.f26402g.c(this.f26403h.call(t));
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.a(th, t));
            }
        }

        @Override // rx.i
        public void onError(Throwable th) {
            if (this.f26404i) {
                rx.q.c.j(th);
            } else {
                this.f26404i = true;
                this.f26402g.onError(th);
            }
        }
    }

    public p1(Single<T> single, rx.m.e<? super T, ? extends R> eVar) {
        this.f26400f = single;
        this.f26401g = eVar;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.i<? super R> iVar) {
        a aVar = new a(iVar, this.f26401g);
        iVar.b(aVar);
        this.f26400f.t(aVar);
    }
}
