package rx.n.a;

/* JADX INFO: compiled from: OperatorTakeUntilPredicate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d1<T> implements rx.e.b<T, T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.m.e<? super T, Boolean> f26170f;

    /* JADX INFO: compiled from: OperatorTakeUntilPredicate.java */
    class a implements rx.g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f26171f;

        a(b bVar) {
            this.f26171f = bVar;
        }

        @Override // rx.g
        public void request(long j2) {
            this.f26171f.c(j2);
        }
    }

    /* JADX INFO: compiled from: OperatorTakeUntilPredicate.java */
    final class b extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final rx.j<? super T> f26173f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f26174g;

        b(rx.j<? super T> jVar) {
            this.f26173f = jVar;
        }

        void c(long j2) {
            request(j2);
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f26174g) {
                return;
            }
            this.f26173f.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f26174g) {
                return;
            }
            this.f26173f.onError(th);
        }

        @Override // rx.f
        public void onNext(T t) {
            this.f26173f.onNext(t);
            try {
                if (d1.this.f26170f.call(t).booleanValue()) {
                    this.f26174g = true;
                    this.f26173f.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                this.f26174g = true;
                rx.exceptions.a.g(th, this.f26173f, t);
                unsubscribe();
            }
        }
    }

    public d1(rx.m.e<? super T, Boolean> eVar) {
        this.f26170f = eVar;
    }

    @Override // rx.m.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super T> jVar) {
        b bVar = new b(jVar);
        jVar.add(bVar);
        jVar.setProducer(new a(bVar));
        return bVar;
    }
}
