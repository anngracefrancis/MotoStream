package h.a.z.e.b;

import h.a.h;
import h.a.i;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableOnBackpressureLatest.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f<T> extends h.a.z.e.b.a<T, T> {

    /* JADX INFO: compiled from: FlowableOnBackpressureLatest.java */
    static final class a<T> extends AtomicInteger implements i<T>, k.a.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final k.a.b<? super T> f21494f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        k.a.c f21495g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f21496h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Throwable f21497i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f21498j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final AtomicLong f21499k = new AtomicLong();
        final AtomicReference<T> l = new AtomicReference<>();

        a(k.a.b<? super T> bVar) {
            this.f21494f = bVar;
        }

        @Override // k.a.b
        public void a() {
            this.f21496h = true;
            d();
        }

        @Override // k.a.b
        public void b(k.a.c cVar) {
            if (h.a.z.i.b.y(this.f21495g, cVar)) {
                this.f21495g = cVar;
                this.f21494f.b(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        boolean c(boolean z, boolean z2, k.a.b<?> bVar, AtomicReference<T> atomicReference) {
            if (this.f21498j) {
                atomicReference.lazySet(null);
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.f21497i;
            if (th != null) {
                atomicReference.lazySet(null);
                bVar.onError(th);
                return true;
            }
            if (!z2) {
                return false;
            }
            bVar.a();
            return true;
        }

        @Override // k.a.c
        public void cancel() {
            if (this.f21498j) {
                return;
            }
            this.f21498j = true;
            this.f21495g.cancel();
            if (getAndIncrement() == 0) {
                this.l.lazySet(null);
            }
        }

        void d() {
            if (getAndIncrement() != 0) {
                return;
            }
            k.a.b<? super T> bVar = this.f21494f;
            AtomicLong atomicLong = this.f21499k;
            AtomicReference<T> atomicReference = this.l;
            int iAddAndGet = 1;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == atomicLong.get()) {
                        break;
                    }
                    boolean z = this.f21496h;
                    T andSet = atomicReference.getAndSet(null);
                    boolean z2 = andSet == null;
                    if (c(z, z2, bVar, atomicReference)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    bVar.onNext(andSet);
                    j2++;
                }
                if (j2 == atomicLong.get()) {
                    if (c(this.f21496h, atomicReference.get() == null, bVar, atomicReference)) {
                        return;
                    }
                }
                if (j2 != 0) {
                    h.a.z.j.b.c(atomicLong, j2);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // k.a.b
        public void onError(Throwable th) {
            this.f21497i = th;
            this.f21496h = true;
            d();
        }

        @Override // k.a.b
        public void onNext(T t) {
            this.l.lazySet(t);
            d();
        }

        @Override // k.a.c
        public void request(long j2) {
            if (h.a.z.i.b.x(j2)) {
                h.a.z.j.b.a(this.f21499k, j2);
                d();
            }
        }
    }

    public f(h<T> hVar) {
        super(hVar);
    }

    @Override // h.a.h
    protected void i(k.a.b<? super T> bVar) {
        this.f21472b.h(new a(bVar));
    }
}
