package rx.n.a;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: OperatorDelay.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l0<T> implements rx.e.b<T, T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final long f26319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final TimeUnit f26320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final rx.h f26321h;

    /* JADX INFO: compiled from: OperatorDelay.java */
    class a extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f26322f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ rx.h.a f26323g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ rx.j f26324h;

        /* JADX INFO: renamed from: rx.n.a.l0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OperatorDelay.java */
        class C0444a implements rx.m.a {
            C0444a() {
            }

            @Override // rx.m.a
            public void call() {
                a aVar = a.this;
                if (aVar.f26322f) {
                    return;
                }
                aVar.f26322f = true;
                aVar.f26324h.onCompleted();
            }
        }

        /* JADX INFO: compiled from: OperatorDelay.java */
        class b implements rx.m.a {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Throwable f26327f;

            b(Throwable th) {
                this.f26327f = th;
            }

            @Override // rx.m.a
            public void call() {
                a aVar = a.this;
                if (aVar.f26322f) {
                    return;
                }
                aVar.f26322f = true;
                aVar.f26324h.onError(this.f26327f);
                a.this.f26323g.unsubscribe();
            }
        }

        /* JADX INFO: compiled from: OperatorDelay.java */
        class c implements rx.m.a {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Object f26329f;

            c(Object obj) {
                this.f26329f = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.m.a
            public void call() {
                a aVar = a.this;
                if (aVar.f26322f) {
                    return;
                }
                aVar.f26324h.onNext(this.f26329f);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.j jVar, rx.h.a aVar, rx.j jVar2) {
            super(jVar);
            this.f26323g = aVar;
            this.f26324h = jVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            rx.h.a aVar = this.f26323g;
            C0444a c0444a = new C0444a();
            l0 l0Var = l0.this;
            aVar.d(c0444a, l0Var.f26319f, l0Var.f26320g);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26323g.c(new b(th));
        }

        @Override // rx.f
        public void onNext(T t) {
            rx.h.a aVar = this.f26323g;
            c cVar = new c(t);
            l0 l0Var = l0.this;
            aVar.d(cVar, l0Var.f26319f, l0Var.f26320g);
        }
    }

    public l0(long j2, TimeUnit timeUnit, rx.h hVar) {
        this.f26319f = j2;
        this.f26320g = timeUnit;
        this.f26321h = hVar;
    }

    @Override // rx.m.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super T> jVar) {
        rx.h.a aVarCreateWorker = this.f26321h.createWorker();
        jVar.add(aVarCreateWorker);
        return new a(jVar, aVarCreateWorker, jVar);
    }
}
