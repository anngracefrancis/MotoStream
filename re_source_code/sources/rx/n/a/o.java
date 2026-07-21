package rx.n.a;

import rx.exceptions.OnErrorThrowable;

/* JADX INFO: compiled from: OnSubscribeFilter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o<T> implements rx.e.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.e<T> f26360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final rx.m.e<? super T, Boolean> f26361g;

    /* JADX INFO: compiled from: OnSubscribeFilter.java */
    static final class a<T> extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final rx.j<? super T> f26362f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final rx.m.e<? super T, Boolean> f26363g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f26364h;

        public a(rx.j<? super T> jVar, rx.m.e<? super T, Boolean> eVar) {
            this.f26362f = jVar;
            this.f26363g = eVar;
            request(0L);
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f26364h) {
                return;
            }
            this.f26362f.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f26364h) {
                rx.q.c.j(th);
            } else {
                this.f26364h = true;
                this.f26362f.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t) {
            try {
                if (this.f26363g.call(t).booleanValue()) {
                    this.f26362f.onNext(t);
                } else {
                    request(1L);
                }
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.a(th, t));
            }
        }

        @Override // rx.j
        public void setProducer(rx.g gVar) {
            super.setProducer(gVar);
            this.f26362f.setProducer(gVar);
        }
    }

    public o(rx.e<T> eVar, rx.m.e<? super T, Boolean> eVar2) {
        this.f26360f = eVar;
        this.f26361g = eVar2;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.f26361g);
        jVar.add(aVar);
        this.f26360f.c1(aVar);
    }
}
