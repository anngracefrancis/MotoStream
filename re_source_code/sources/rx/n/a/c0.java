package rx.n.a;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: OnSubscribeSwitchIfEmpty.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c0<T> implements rx.e.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.e<? extends T> f26149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final rx.e<? extends T> f26150g;

    /* JADX INFO: compiled from: OnSubscribeSwitchIfEmpty.java */
    static final class a<T> extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final rx.n.b.a f26151f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final rx.j<? super T> f26152g;

        a(rx.j<? super T> jVar, rx.n.b.a aVar) {
            this.f26152g = jVar;
            this.f26151f = aVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f26152g.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26152g.onError(th);
        }

        @Override // rx.f
        public void onNext(T t) {
            this.f26152g.onNext(t);
            this.f26151f.b(1L);
        }

        @Override // rx.j
        public void setProducer(rx.g gVar) {
            this.f26151f.c(gVar);
        }
    }

    /* JADX INFO: compiled from: OnSubscribeSwitchIfEmpty.java */
    static final class b<T> extends rx.j<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final rx.j<? super T> f26154g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final rx.t.d f26155h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final rx.n.b.a f26156i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final rx.e<? extends T> f26157j;
        volatile boolean l;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f26153f = true;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final AtomicInteger f26158k = new AtomicInteger();

        b(rx.j<? super T> jVar, rx.t.d dVar, rx.n.b.a aVar, rx.e<? extends T> eVar) {
            this.f26154g = jVar;
            this.f26155h = dVar;
            this.f26156i = aVar;
            this.f26157j = eVar;
        }

        void c(rx.e<? extends T> eVar) {
            if (this.f26158k.getAndIncrement() == 0) {
                while (!this.f26154g.isUnsubscribed()) {
                    if (!this.l) {
                        if (eVar == null) {
                            a aVar = new a(this.f26154g, this.f26156i);
                            this.f26155h.b(aVar);
                            this.l = true;
                            this.f26157j.c1(aVar);
                        } else {
                            this.l = true;
                            eVar.c1(this);
                            eVar = null;
                        }
                    }
                    if (this.f26158k.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (!this.f26153f) {
                this.f26154g.onCompleted();
            } else {
                if (this.f26154g.isUnsubscribed()) {
                    return;
                }
                this.l = false;
                c(null);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26154g.onError(th);
        }

        @Override // rx.f
        public void onNext(T t) {
            this.f26153f = false;
            this.f26154g.onNext(t);
            this.f26156i.b(1L);
        }

        @Override // rx.j
        public void setProducer(rx.g gVar) {
            this.f26156i.c(gVar);
        }
    }

    public c0(rx.e<? extends T> eVar, rx.e<? extends T> eVar2) {
        this.f26149f = eVar;
        this.f26150g = eVar2;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super T> jVar) {
        rx.t.d dVar = new rx.t.d();
        rx.n.b.a aVar = new rx.n.b.a();
        b bVar = new b(jVar, dVar, aVar, this.f26150g);
        dVar.b(bVar);
        jVar.add(dVar);
        jVar.setProducer(aVar);
        bVar.c(this.f26149f);
    }
}
