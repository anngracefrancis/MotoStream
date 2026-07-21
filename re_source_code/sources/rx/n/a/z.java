package rx.n.a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: OnSubscribeRefCount.java */
/* JADX INFO: loaded from: classes3.dex */
public final class z<T> implements rx.e.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final rx.o.b<? extends T> f26582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile rx.t.b f26583g = new rx.t.b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final AtomicInteger f26584h = new AtomicInteger(0);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final ReentrantLock f26585i = new ReentrantLock();

    /* JADX INFO: compiled from: OnSubscribeRefCount.java */
    class a implements rx.m.b<rx.k> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.j f26586f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f26587g;

        a(rx.j jVar, AtomicBoolean atomicBoolean) {
            this.f26586f = jVar;
            this.f26587g = atomicBoolean;
        }

        @Override // rx.m.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.k kVar) {
            try {
                z.this.f26583g.a(kVar);
                z zVar = z.this;
                zVar.d(this.f26586f, zVar.f26583g);
            } finally {
                z.this.f26585i.unlock();
                this.f26587g.set(false);
            }
        }
    }

    /* JADX INFO: compiled from: OnSubscribeRefCount.java */
    class b extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.j f26589f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ rx.t.b f26590g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(rx.j jVar, rx.j jVar2, rx.t.b bVar) {
            super(jVar);
            this.f26589f = jVar2;
            this.f26590g = bVar;
        }

        void c() {
            z.this.f26585i.lock();
            try {
                if (z.this.f26583g == this.f26590g) {
                    if (z.this.f26582f instanceof rx.k) {
                        ((rx.k) z.this.f26582f).unsubscribe();
                    }
                    z.this.f26583g.unsubscribe();
                    z.this.f26583g = new rx.t.b();
                    z.this.f26584h.set(0);
                }
            } finally {
                z.this.f26585i.unlock();
            }
        }

        @Override // rx.f
        public void onCompleted() {
            c();
            this.f26589f.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            c();
            this.f26589f.onError(th);
        }

        @Override // rx.f
        public void onNext(T t) {
            this.f26589f.onNext(t);
        }
    }

    /* JADX INFO: compiled from: OnSubscribeRefCount.java */
    class c implements rx.m.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.t.b f26592f;

        c(rx.t.b bVar) {
            this.f26592f = bVar;
        }

        @Override // rx.m.a
        public void call() {
            z.this.f26585i.lock();
            try {
                if (z.this.f26583g == this.f26592f && z.this.f26584h.decrementAndGet() == 0) {
                    if (z.this.f26582f instanceof rx.k) {
                        ((rx.k) z.this.f26582f).unsubscribe();
                    }
                    z.this.f26583g.unsubscribe();
                    z.this.f26583g = new rx.t.b();
                }
            } finally {
                z.this.f26585i.unlock();
            }
        }
    }

    public z(rx.o.b<? extends T> bVar) {
        this.f26582f = bVar;
    }

    private rx.k c(rx.t.b bVar) {
        return rx.t.e.a(new c(bVar));
    }

    private rx.m.b<rx.k> e(rx.j<? super T> jVar, AtomicBoolean atomicBoolean) {
        return new a(jVar, atomicBoolean);
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super T> jVar) {
        this.f26585i.lock();
        if (this.f26584h.incrementAndGet() != 1) {
            try {
                d(jVar, this.f26583g);
            } finally {
                this.f26585i.unlock();
            }
        } else {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.f26582f.i1(e(jVar, atomicBoolean));
            } finally {
                if (atomicBoolean.get()) {
                    this.f26585i.unlock();
                }
            }
        }
    }

    void d(rx.j<? super T> jVar, rx.t.b bVar) {
        jVar.add(c(bVar));
        this.f26582f.c1(new b(jVar, jVar, bVar));
    }
}
