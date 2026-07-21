package rx.n.a;

/* JADX INFO: compiled from: OperatorDistinctUntilChanged.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m0<T, U> implements rx.e.b<T, T>, rx.m.f<U, U, Boolean> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.m.e<? super T, ? extends U> f26338f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final rx.m.f<? super U, ? super U, Boolean> f26339g = this;

    /* JADX INFO: compiled from: OperatorDistinctUntilChanged.java */
    class a extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        U f26340f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f26341g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ rx.j f26342h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.j jVar, rx.j jVar2) {
            super(jVar);
            this.f26342h = jVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f26342h.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26342h.onError(th);
        }

        @Override // rx.f
        public void onNext(T t) {
            try {
                U uCall = m0.this.f26338f.call(t);
                U u = this.f26340f;
                this.f26340f = uCall;
                if (!this.f26341g) {
                    this.f26341g = true;
                    this.f26342h.onNext(t);
                    return;
                }
                try {
                    if (m0.this.f26339g.a(u, uCall).booleanValue()) {
                        request(1L);
                    } else {
                        this.f26342h.onNext(t);
                    }
                } catch (Throwable th) {
                    rx.exceptions.a.g(th, this.f26342h, uCall);
                }
            } catch (Throwable th2) {
                rx.exceptions.a.g(th2, this.f26342h, t);
            }
        }
    }

    /* JADX INFO: compiled from: OperatorDistinctUntilChanged.java */
    static final class b {
        static final m0<?, ?> a = new m0<>(rx.n.e.m.b());
    }

    public m0(rx.m.e<? super T, ? extends U> eVar) {
        this.f26338f = eVar;
    }

    public static <T> m0<T, T> d() {
        return (m0<T, T>) b.a;
    }

    @Override // rx.m.f
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean a(U u, U u2) {
        return Boolean.valueOf(u == u2 || (u != null && u.equals(u2)));
    }

    @Override // rx.m.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super T> jVar) {
        return new a(jVar, jVar);
    }
}
