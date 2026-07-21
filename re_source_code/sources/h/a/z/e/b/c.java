package h.a.z.e.b;

import h.a.h;
import h.a.i;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: FlowableOnBackpressureBuffer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c<T> extends h.a.z.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f21476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f21477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f21478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final h.a.y.a f21479f;

    /* JADX INFO: compiled from: FlowableOnBackpressureBuffer.java */
    static final class a<T> extends h.a.z.i.a<T> implements i<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final k.a.b<? super T> f21480f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.z.c.e<T> f21481g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final boolean f21482h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final h.a.y.a f21483i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        k.a.c f21484j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f21485k;
        volatile boolean l;
        Throwable m;
        final AtomicLong n = new AtomicLong();
        boolean o;

        a(k.a.b<? super T> bVar, int i2, boolean z, boolean z2, h.a.y.a aVar) {
            this.f21480f = bVar;
            this.f21483i = aVar;
            this.f21482h = z2;
            this.f21481g = z ? new h.a.z.f.c<>(i2) : new h.a.z.f.b<>(i2);
        }

        @Override // k.a.b
        public void a() {
            this.l = true;
            if (this.o) {
                this.f21480f.a();
            } else {
                d();
            }
        }

        @Override // k.a.b
        public void b(k.a.c cVar) {
            if (h.a.z.i.b.y(this.f21484j, cVar)) {
                this.f21484j = cVar;
                this.f21480f.b(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        boolean c(boolean z, boolean z2, k.a.b<? super T> bVar) {
            if (this.f21485k) {
                this.f21481g.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.f21482h) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.m;
                if (th != null) {
                    bVar.onError(th);
                } else {
                    bVar.a();
                }
                return true;
            }
            Throwable th2 = this.m;
            if (th2 != null) {
                this.f21481g.clear();
                bVar.onError(th2);
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
            if (this.f21485k) {
                return;
            }
            this.f21485k = true;
            this.f21484j.cancel();
            if (this.o || getAndIncrement() != 0) {
                return;
            }
            this.f21481g.clear();
        }

        @Override // h.a.z.c.f
        public void clear() {
            this.f21481g.clear();
        }

        void d() {
            if (getAndIncrement() == 0) {
                h.a.z.c.e<T> eVar = this.f21481g;
                k.a.b<? super T> bVar = this.f21480f;
                int iAddAndGet = 1;
                while (!c(this.l, eVar.isEmpty(), bVar)) {
                    long j2 = this.n.get();
                    long j3 = 0;
                    while (j3 != j2) {
                        boolean z = this.l;
                        T tPoll = eVar.poll();
                        boolean z2 = tPoll == null;
                        if (c(z, z2, bVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        bVar.onNext(tPoll);
                        j3++;
                    }
                    if (j3 == j2 && c(this.l, eVar.isEmpty(), bVar)) {
                        return;
                    }
                    if (j3 != 0 && j2 != Long.MAX_VALUE) {
                        this.n.addAndGet(-j3);
                    }
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // h.a.z.c.f
        public boolean isEmpty() {
            return this.f21481g.isEmpty();
        }

        @Override // k.a.b
        public void onError(Throwable th) {
            this.m = th;
            this.l = true;
            if (this.o) {
                this.f21480f.onError(th);
            } else {
                d();
            }
        }

        @Override // k.a.b
        public void onNext(T t) {
            if (this.f21481g.offer(t)) {
                if (this.o) {
                    this.f21480f.onNext(null);
                    return;
                } else {
                    d();
                    return;
                }
            }
            this.f21484j.cancel();
            MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
            try {
                this.f21483i.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.a(th);
                missingBackpressureException.initCause(th);
            }
            onError(missingBackpressureException);
        }

        @Override // h.a.z.c.f
        public T poll() throws Exception {
            return this.f21481g.poll();
        }

        @Override // k.a.c
        public void request(long j2) {
            if (this.o || !h.a.z.i.b.x(j2)) {
                return;
            }
            h.a.z.j.b.a(this.n, j2);
            d();
        }
    }

    public c(h<T> hVar, int i2, boolean z, boolean z2, h.a.y.a aVar) {
        super(hVar);
        this.f21476c = i2;
        this.f21477d = z;
        this.f21478e = z2;
        this.f21479f = aVar;
    }

    @Override // h.a.h
    protected void i(k.a.b<? super T> bVar) {
        this.f21472b.h(new a(bVar, this.f21476c, this.f21477d, this.f21478e, this.f21479f));
    }
}
