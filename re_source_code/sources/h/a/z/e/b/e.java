package h.a.z.e.b;

import h.a.h;
import h.a.i;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: FlowableOnBackpressureError.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e<T> extends h.a.z.e.b.a<T, T> {

    /* JADX INFO: compiled from: FlowableOnBackpressureError.java */
    static final class a<T> extends AtomicLong implements i<T>, k.a.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final k.a.b<? super T> f21491f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        k.a.c f21492g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f21493h;

        a(k.a.b<? super T> bVar) {
            this.f21491f = bVar;
        }

        @Override // k.a.b
        public void a() {
            if (this.f21493h) {
                return;
            }
            this.f21493h = true;
            this.f21491f.a();
        }

        @Override // k.a.b
        public void b(k.a.c cVar) {
            if (h.a.z.i.b.y(this.f21492g, cVar)) {
                this.f21492g = cVar;
                this.f21491f.b(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // k.a.c
        public void cancel() {
            this.f21492g.cancel();
        }

        @Override // k.a.b
        public void onError(Throwable th) {
            if (this.f21493h) {
                h.a.a0.a.o(th);
            } else {
                this.f21493h = true;
                this.f21491f.onError(th);
            }
        }

        @Override // k.a.b
        public void onNext(T t) {
            if (this.f21493h) {
                return;
            }
            if (get() == 0) {
                onError(new MissingBackpressureException("could not emit value due to lack of requests"));
            } else {
                this.f21491f.onNext(t);
                h.a.z.j.b.c(this, 1L);
            }
        }

        @Override // k.a.c
        public void request(long j2) {
            if (h.a.z.i.b.x(j2)) {
                h.a.z.j.b.a(this, j2);
            }
        }
    }

    public e(h<T> hVar) {
        super(hVar);
    }

    @Override // h.a.h
    protected void i(k.a.b<? super T> bVar) {
        this.f21472b.h(new a(bVar));
    }
}
