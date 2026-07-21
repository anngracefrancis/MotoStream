package rx.n.a;

/* JADX INFO: compiled from: OnSubscribeDelaySubscriptionOther.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m<T, U> implements rx.e.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.e<? extends T> f26332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final rx.e<U> f26333g;

    /* JADX INFO: compiled from: OnSubscribeDelaySubscriptionOther.java */
    class a extends rx.j<U> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f26334f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ rx.j f26335g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ rx.t.d f26336h;

        a(rx.j jVar, rx.t.d dVar) {
            this.f26335g = jVar;
            this.f26336h = dVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f26334f) {
                return;
            }
            this.f26334f = true;
            this.f26336h.b(rx.t.e.c());
            m.this.f26332f.c1(this.f26335g);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f26334f) {
                rx.q.c.j(th);
            } else {
                this.f26334f = true;
                this.f26335g.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(U u) {
            onCompleted();
        }
    }

    public m(rx.e<? extends T> eVar, rx.e<U> eVar2) {
        this.f26332f = eVar;
        this.f26333g = eVar2;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super T> jVar) {
        rx.t.d dVar = new rx.t.d();
        jVar.add(dVar);
        a aVar = new a(rx.p.f.c(jVar), dVar);
        dVar.b(aVar);
        this.f26333g.c1(aVar);
    }
}
