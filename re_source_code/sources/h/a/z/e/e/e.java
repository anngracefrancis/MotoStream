package h.a.z.e.e;

import h.a.r;
import h.a.s;
import h.a.u;
import h.a.w;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleSubscribeOn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e<T> extends s<T> {
    final w<? extends T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final r f21617b;

    /* JADX INFO: compiled from: SingleSubscribeOn.java */
    static final class a<T> extends AtomicReference<h.a.x.c> implements u<T>, h.a.x.c, Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final u<? super T> f21618f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.z.a.f f21619g = new h.a.z.a.f();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final w<? extends T> f21620h;

        a(u<? super T> uVar, w<? extends T> wVar) {
            this.f21618f = uVar;
            this.f21620h = wVar;
        }

        @Override // h.a.u
        public void b(h.a.x.c cVar) {
            h.a.z.a.c.A(this, cVar);
        }

        @Override // h.a.x.c
        public void k() {
            h.a.z.a.c.g(this);
            this.f21619g.k();
        }

        @Override // h.a.u
        public void onError(Throwable th) {
            this.f21618f.onError(th);
        }

        @Override // h.a.u
        public void onSuccess(T t) {
            this.f21618f.onSuccess(t);
        }

        @Override // h.a.x.c
        public boolean q() {
            return h.a.z.a.c.u(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21620h.b(this);
        }
    }

    public e(w<? extends T> wVar, r rVar) {
        this.a = wVar;
        this.f21617b = rVar;
    }

    @Override // h.a.s
    protected void h(u<? super T> uVar) {
        a aVar = new a(uVar, this.a);
        uVar.b(aVar);
        aVar.f21619g.a(this.f21617b.b(aVar));
    }
}
