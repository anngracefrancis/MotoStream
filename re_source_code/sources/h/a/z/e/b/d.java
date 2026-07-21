package h.a.z.e.b;

import h.a.h;
import h.a.i;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: FlowableOnBackpressureDrop.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d<T> extends h.a.z.e.b.a<T, T> implements h.a.y.e<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.y.e<? super T> f21486c;

    /* JADX INFO: compiled from: FlowableOnBackpressureDrop.java */
    static final class a<T> extends AtomicLong implements i<T>, k.a.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final k.a.b<? super T> f21487f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.y.e<? super T> f21488g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        k.a.c f21489h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f21490i;

        a(k.a.b<? super T> bVar, h.a.y.e<? super T> eVar) {
            this.f21487f = bVar;
            this.f21488g = eVar;
        }

        @Override // k.a.b
        public void a() {
            if (this.f21490i) {
                return;
            }
            this.f21490i = true;
            this.f21487f.a();
        }

        @Override // k.a.b
        public void b(k.a.c cVar) {
            if (h.a.z.i.b.y(this.f21489h, cVar)) {
                this.f21489h = cVar;
                this.f21487f.b(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // k.a.c
        public void cancel() {
            this.f21489h.cancel();
        }

        @Override // k.a.b
        public void onError(Throwable th) {
            if (this.f21490i) {
                h.a.a0.a.o(th);
            } else {
                this.f21490i = true;
                this.f21487f.onError(th);
            }
        }

        @Override // k.a.b
        public void onNext(T t) {
            if (this.f21490i) {
                return;
            }
            if (get() != 0) {
                this.f21487f.onNext(t);
                h.a.z.j.b.c(this, 1L);
                return;
            }
            try {
                this.f21488g.a(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.a(th);
                cancel();
                onError(th);
            }
        }

        @Override // k.a.c
        public void request(long j2) {
            if (h.a.z.i.b.x(j2)) {
                h.a.z.j.b.a(this, j2);
            }
        }
    }

    public d(h<T> hVar) {
        super(hVar);
        this.f21486c = this;
    }

    @Override // h.a.y.e
    public void a(T t) {
    }

    @Override // h.a.h
    protected void i(k.a.b<? super T> bVar) {
        this.f21472b.h(new a(bVar, this.f21486c));
    }
}
