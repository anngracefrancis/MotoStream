package h.a.z.e.d;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableCreate.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b<T> extends h.a.m<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final h.a.o<T> f21504f;

    /* JADX INFO: compiled from: ObservableCreate.java */
    static final class a<T> extends AtomicReference<h.a.x.c> implements h.a.n<T>, h.a.x.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.q<? super T> f21505f;

        a(h.a.q<? super T> qVar) {
            this.f21505f = qVar;
        }

        @Override // h.a.n
        public void a(h.a.x.c cVar) {
            h.a.z.a.c.y(this, cVar);
        }

        public void b(Throwable th) {
            if (c(th)) {
                return;
            }
            h.a.a0.a.o(th);
        }

        public boolean c(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (q()) {
                return false;
            }
            try {
                this.f21505f.onError(th);
                return true;
            } finally {
                k();
            }
        }

        @Override // h.a.x.c
        public void k() {
            h.a.z.a.c.g(this);
        }

        @Override // h.a.g
        public void onNext(T t) {
            if (t == null) {
                b(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                if (q()) {
                    return;
                }
                this.f21505f.onNext(t);
            }
        }

        @Override // h.a.x.c
        public boolean q() {
            return h.a.z.a.c.u(get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", a.class.getSimpleName(), super.toString());
        }
    }

    public b(h.a.o<T> oVar) {
        this.f21504f = oVar;
    }

    @Override // h.a.m
    protected void x(h.a.q<? super T> qVar) {
        a aVar = new a(qVar);
        qVar.b(aVar);
        try {
            this.f21504f.a(aVar);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            aVar.b(th);
        }
    }
}
