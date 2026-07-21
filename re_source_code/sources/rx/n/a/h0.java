package rx.n.a;

/* JADX INFO: compiled from: OperatorAny.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h0<T> implements rx.e.b<Boolean, T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.m.e<? super T, Boolean> f26245f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f26246g;

    /* JADX INFO: compiled from: OperatorAny.java */
    class a extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f26247f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f26248g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ rx.n.b.b f26249h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ rx.j f26250i;

        a(rx.n.b.b bVar, rx.j jVar) {
            this.f26249h = bVar;
            this.f26250i = jVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f26248g) {
                return;
            }
            this.f26248g = true;
            if (this.f26247f) {
                this.f26249h.b(Boolean.FALSE);
            } else {
                this.f26249h.b(Boolean.valueOf(h0.this.f26246g));
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f26248g) {
                rx.q.c.j(th);
            } else {
                this.f26248g = true;
                this.f26250i.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t) {
            if (this.f26248g) {
                return;
            }
            this.f26247f = true;
            try {
                if (h0.this.f26245f.call(t).booleanValue()) {
                    this.f26248g = true;
                    this.f26249h.b(Boolean.valueOf(true ^ h0.this.f26246g));
                    unsubscribe();
                }
            } catch (Throwable th) {
                rx.exceptions.a.g(th, this, t);
            }
        }
    }

    public h0(rx.m.e<? super T, Boolean> eVar, boolean z) {
        this.f26245f = eVar;
        this.f26246g = z;
    }

    @Override // rx.m.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super Boolean> jVar) {
        rx.n.b.b bVar = new rx.n.b.b(jVar);
        a aVar = new a(bVar, jVar);
        jVar.add(aVar);
        jVar.setProducer(bVar);
        return aVar;
    }
}
