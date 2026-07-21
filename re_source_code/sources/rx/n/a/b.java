package rx.n.a;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: BufferUntilSubscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b<T> extends rx.s.d<T, T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final rx.f f26123g = new a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final c<T> f26124h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f26125i;

    /* JADX INFO: compiled from: BufferUntilSubscriber.java */
    static class a implements rx.f {
        a() {
        }

        @Override // rx.f
        public void onCompleted() {
        }

        @Override // rx.f
        public void onError(Throwable th) {
        }

        @Override // rx.f
        public void onNext(Object obj) {
        }
    }

    /* JADX INFO: renamed from: rx.n.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BufferUntilSubscriber.java */
    static final class C0440b<T> implements rx.e.a<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final c<T> f26126f;

        /* JADX INFO: renamed from: rx.n.a.b$b$a */
        /* JADX INFO: compiled from: BufferUntilSubscriber.java */
        class a implements rx.m.a {
            a() {
            }

            @Override // rx.m.a
            public void call() {
                C0440b.this.f26126f.set(b.f26123g);
            }
        }

        public C0440b(c<T> cVar) {
            this.f26126f = cVar;
        }

        @Override // rx.m.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.j<? super T> jVar) {
            boolean z;
            if (!this.f26126f.a(null, jVar)) {
                jVar.onError(new IllegalStateException("Only one subscriber allowed!"));
                return;
            }
            jVar.add(rx.t.e.a(new a()));
            synchronized (this.f26126f.f26128f) {
                c<T> cVar = this.f26126f;
                z = true;
                if (cVar.f26129g) {
                    z = false;
                } else {
                    cVar.f26129g = true;
                }
            }
            if (!z) {
                return;
            }
            while (true) {
                Object objPoll = this.f26126f.f26130h.poll();
                if (objPoll != null) {
                    h.a(this.f26126f.get(), objPoll);
                } else {
                    synchronized (this.f26126f.f26128f) {
                        if (this.f26126f.f26130h.isEmpty()) {
                            this.f26126f.f26129g = false;
                            return;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: BufferUntilSubscriber.java */
    static final class c<T> extends AtomicReference<rx.f<? super T>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f26129g;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Object f26128f = new Object();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final ConcurrentLinkedQueue<Object> f26130h = new ConcurrentLinkedQueue<>();

        c() {
        }

        boolean a(rx.f<? super T> fVar, rx.f<? super T> fVar2) {
            return compareAndSet(fVar, fVar2);
        }
    }

    private b(c<T> cVar) {
        super(new C0440b(cVar));
        this.f26124h = cVar;
    }

    public static <T> b<T> g1() {
        return new b<>(new c());
    }

    private void h1(Object obj) {
        synchronized (this.f26124h.f26128f) {
            this.f26124h.f26130h.add(obj);
            if (this.f26124h.get() != null) {
                c<T> cVar = this.f26124h;
                if (!cVar.f26129g) {
                    this.f26125i = true;
                    cVar.f26129g = true;
                }
            }
        }
        if (!this.f26125i) {
            return;
        }
        while (true) {
            Object objPoll = this.f26124h.f26130h.poll();
            if (objPoll == null) {
                return;
            } else {
                h.a(this.f26124h.get(), objPoll);
            }
        }
    }

    @Override // rx.f
    public void onCompleted() {
        if (this.f26125i) {
            this.f26124h.get().onCompleted();
        } else {
            h1(h.b());
        }
    }

    @Override // rx.f
    public void onError(Throwable th) {
        if (this.f26125i) {
            this.f26124h.get().onError(th);
        } else {
            h1(h.c(th));
        }
    }

    @Override // rx.f
    public void onNext(T t) {
        if (this.f26125i) {
            this.f26124h.get().onNext(t);
        } else {
            h1(h.g(t));
        }
    }
}
