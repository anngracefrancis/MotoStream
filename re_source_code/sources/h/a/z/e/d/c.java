package h.a.z.e.d;

import io.reactivex.exceptions.CompositeException;

/* JADX INFO: compiled from: ObservableDoOnEach.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c<T> extends h.a.z.e.d.a<T, T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final h.a.y.e<? super T> f21506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final h.a.y.e<? super Throwable> f21507h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final h.a.y.a f21508i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final h.a.y.a f21509j;

    /* JADX INFO: compiled from: ObservableDoOnEach.java */
    static final class a<T> implements h.a.q<T>, h.a.x.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.q<? super T> f21510f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.y.e<? super T> f21511g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final h.a.y.e<? super Throwable> f21512h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final h.a.y.a f21513i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final h.a.y.a f21514j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        h.a.x.c f21515k;
        boolean l;

        a(h.a.q<? super T> qVar, h.a.y.e<? super T> eVar, h.a.y.e<? super Throwable> eVar2, h.a.y.a aVar, h.a.y.a aVar2) {
            this.f21510f = qVar;
            this.f21511g = eVar;
            this.f21512h = eVar2;
            this.f21513i = aVar;
            this.f21514j = aVar2;
        }

        @Override // h.a.q
        public void a() {
            if (this.l) {
                return;
            }
            try {
                this.f21513i.run();
                this.l = true;
                this.f21510f.a();
                try {
                    this.f21514j.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.a(th);
                    h.a.a0.a.o(th);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.a(th2);
                onError(th2);
            }
        }

        @Override // h.a.q
        public void b(h.a.x.c cVar) {
            if (h.a.z.a.c.D(this.f21515k, cVar)) {
                this.f21515k = cVar;
                this.f21510f.b(this);
            }
        }

        @Override // h.a.x.c
        public void k() {
            this.f21515k.k();
        }

        @Override // h.a.q
        public void onError(Throwable th) {
            if (this.l) {
                h.a.a0.a.o(th);
                return;
            }
            this.l = true;
            try {
                this.f21512h.a(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.a(th2);
                th = new CompositeException(th, th2);
            }
            this.f21510f.onError(th);
            try {
                this.f21514j.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.a(th3);
                h.a.a0.a.o(th3);
            }
        }

        @Override // h.a.q
        public void onNext(T t) {
            if (this.l) {
                return;
            }
            try {
                this.f21511g.a(t);
                this.f21510f.onNext(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.a(th);
                this.f21515k.k();
                onError(th);
            }
        }

        @Override // h.a.x.c
        public boolean q() {
            return this.f21515k.q();
        }
    }

    public c(h.a.p<T> pVar, h.a.y.e<? super T> eVar, h.a.y.e<? super Throwable> eVar2, h.a.y.a aVar, h.a.y.a aVar2) {
        super(pVar);
        this.f21506g = eVar;
        this.f21507h = eVar2;
        this.f21508i = aVar;
        this.f21509j = aVar2;
    }

    @Override // h.a.m
    public void x(h.a.q<? super T> qVar) {
        this.f21503f.a(new a(qVar, this.f21506g, this.f21507h, this.f21508i, this.f21509j));
    }
}
