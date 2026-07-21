package rx.n.a;

import rx.Single;

/* JADX INFO: compiled from: SingleObserveOn.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m1<T> implements Single.j<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Single.j<T> f26344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final rx.h f26345g;

    /* JADX INFO: compiled from: SingleObserveOn.java */
    static final class a<T> extends rx.i<T> implements rx.m.a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final rx.i<? super T> f26346g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final rx.h.a f26347h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        T f26348i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Throwable f26349j;

        public a(rx.i<? super T> iVar, rx.h.a aVar) {
            this.f26346g = iVar;
            this.f26347h = aVar;
        }

        @Override // rx.i
        public void c(T t) {
            this.f26348i = t;
            this.f26347h.c(this);
        }

        @Override // rx.m.a
        public void call() {
            try {
                Throwable th = this.f26349j;
                if (th != null) {
                    this.f26349j = null;
                    this.f26346g.onError(th);
                } else {
                    T t = this.f26348i;
                    this.f26348i = null;
                    this.f26346g.c(t);
                }
            } finally {
                this.f26347h.unsubscribe();
            }
        }

        @Override // rx.i
        public void onError(Throwable th) {
            this.f26349j = th;
            this.f26347h.c(this);
        }
    }

    public m1(Single.j<T> jVar, rx.h hVar) {
        this.f26344f = jVar;
        this.f26345g = hVar;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.i<? super T> iVar) {
        rx.h.a aVarCreateWorker = this.f26345g.createWorker();
        a aVar = new a(iVar, aVarCreateWorker);
        iVar.b(aVarCreateWorker);
        iVar.b(aVar);
        this.f26344f.call(aVar);
    }
}
