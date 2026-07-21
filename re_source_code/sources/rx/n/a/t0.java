package rx.n.a;

/* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t0<T> implements rx.e.b<T, T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.m.e<? super Throwable, ? extends rx.e<? extends T>> f26489f;

    /* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
    static class a implements rx.m.e<Throwable, rx.e<? extends T>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.m.e f26490f;

        a(rx.m.e eVar) {
            this.f26490f = eVar;
        }

        @Override // rx.m.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public rx.e<? extends T> call(Throwable th) {
            return rx.e.S(this.f26490f.call(th));
        }
    }

    /* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
    static class b implements rx.m.e<Throwable, rx.e<? extends T>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.e f26491f;

        b(rx.e eVar) {
            this.f26491f = eVar;
        }

        @Override // rx.m.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public rx.e<? extends T> call(Throwable th) {
            return this.f26491f;
        }
    }

    /* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
    class c extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f26492f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f26493g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ rx.j f26494h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ rx.n.b.a f26495i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ rx.t.d f26496j;

        /* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
        class a extends rx.j<T> {
            a() {
            }

            @Override // rx.f
            public void onCompleted() {
                c.this.f26494h.onCompleted();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                c.this.f26494h.onError(th);
            }

            @Override // rx.f
            public void onNext(T t) {
                c.this.f26494h.onNext(t);
            }

            @Override // rx.j
            public void setProducer(rx.g gVar) {
                c.this.f26495i.c(gVar);
            }
        }

        c(rx.j jVar, rx.n.b.a aVar, rx.t.d dVar) {
            this.f26494h = jVar;
            this.f26495i = aVar;
            this.f26496j = dVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f26492f) {
                return;
            }
            this.f26492f = true;
            this.f26494h.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f26492f) {
                rx.exceptions.a.e(th);
                rx.q.c.j(th);
                return;
            }
            this.f26492f = true;
            try {
                unsubscribe();
                a aVar = new a();
                this.f26496j.b(aVar);
                long j2 = this.f26493g;
                if (j2 != 0) {
                    this.f26495i.b(j2);
                }
                t0.this.f26489f.call(th).c1(aVar);
            } catch (Throwable th2) {
                rx.exceptions.a.f(th2, this.f26494h);
            }
        }

        @Override // rx.f
        public void onNext(T t) {
            if (this.f26492f) {
                return;
            }
            this.f26493g++;
            this.f26494h.onNext(t);
        }

        @Override // rx.j
        public void setProducer(rx.g gVar) {
            this.f26495i.c(gVar);
        }
    }

    public t0(rx.m.e<? super Throwable, ? extends rx.e<? extends T>> eVar) {
        this.f26489f = eVar;
    }

    public static <T> t0<T> b(rx.e<? extends T> eVar) {
        return new t0<>(new b(eVar));
    }

    public static <T> t0<T> c(rx.m.e<? super Throwable, ? extends T> eVar) {
        return new t0<>(new a(eVar));
    }

    @Override // rx.m.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super T> jVar) {
        rx.n.b.a aVar = new rx.n.b.a();
        rx.t.d dVar = new rx.t.d();
        c cVar = new c(jVar, aVar, dVar);
        dVar.b(cVar);
        jVar.add(dVar);
        jVar.setProducer(aVar);
        return cVar;
    }
}
