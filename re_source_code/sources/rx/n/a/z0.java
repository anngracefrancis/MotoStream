package rx.n.a;

/* JADX INFO: compiled from: OperatorSubscribeOn.java */
/* JADX INFO: loaded from: classes3.dex */
public final class z0<T> implements rx.e.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.h f26594f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final rx.e<T> f26595g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f26596h;

    /* JADX INFO: compiled from: OperatorSubscribeOn.java */
    static final class a<T> extends rx.j<T> implements rx.m.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final rx.j<? super T> f26597f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final boolean f26598g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final rx.h.a f26599h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        rx.e<T> f26600i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Thread f26601j;

        /* JADX INFO: renamed from: rx.n.a.z0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OperatorSubscribeOn.java */
        class C0451a implements rx.g {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ rx.g f26602f;

            /* JADX INFO: renamed from: rx.n.a.z0$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: OperatorSubscribeOn.java */
            class C0452a implements rx.m.a {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ long f26604f;

                C0452a(long j2) {
                    this.f26604f = j2;
                }

                @Override // rx.m.a
                public void call() {
                    C0451a.this.f26602f.request(this.f26604f);
                }
            }

            C0451a(rx.g gVar) {
                this.f26602f = gVar;
            }

            @Override // rx.g
            public void request(long j2) {
                if (a.this.f26601j != Thread.currentThread()) {
                    a aVar = a.this;
                    if (aVar.f26598g) {
                        aVar.f26599h.c(new C0452a(j2));
                        return;
                    }
                }
                this.f26602f.request(j2);
            }
        }

        a(rx.j<? super T> jVar, boolean z, rx.h.a aVar, rx.e<T> eVar) {
            this.f26597f = jVar;
            this.f26598g = z;
            this.f26599h = aVar;
            this.f26600i = eVar;
        }

        @Override // rx.m.a
        public void call() {
            rx.e<T> eVar = this.f26600i;
            this.f26600i = null;
            this.f26601j = Thread.currentThread();
            eVar.c1(this);
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                this.f26597f.onCompleted();
            } finally {
                this.f26599h.unsubscribe();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            try {
                this.f26597f.onError(th);
            } finally {
                this.f26599h.unsubscribe();
            }
        }

        @Override // rx.f
        public void onNext(T t) {
            this.f26597f.onNext(t);
        }

        @Override // rx.j
        public void setProducer(rx.g gVar) {
            this.f26597f.setProducer(new C0451a(gVar));
        }
    }

    public z0(rx.e<T> eVar, rx.h hVar, boolean z) {
        this.f26594f = hVar;
        this.f26595g = eVar;
        this.f26596h = z;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super T> jVar) {
        rx.h.a aVarCreateWorker = this.f26594f.createWorker();
        a aVar = new a(jVar, this.f26596h, aVarCreateWorker, this.f26595g);
        jVar.add(aVar);
        jVar.add(aVarCreateWorker);
        aVarCreateWorker.c(aVar);
    }
}
