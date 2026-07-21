package rx.n.a;

import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;

/* JADX INFO: compiled from: OperatorZip.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g1<R> implements rx.e.b<R, rx.e<?>[]> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.m.h<? extends R> f26228f;

    /* JADX INFO: compiled from: OperatorZip.java */
    static final class a<R> extends AtomicLong {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final int f26229f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final rx.f<? super R> f26230g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final rx.m.h<? extends R> f26231h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final rx.t.b f26232i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f26233j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private volatile Object[] f26234k;
        private AtomicLong l;

        /* JADX INFO: renamed from: rx.n.a.g1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OperatorZip.java */
        final class C0442a extends rx.j {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final rx.n.e.h f26235f = rx.n.e.h.a();

            C0442a() {
            }

            public void c(long j2) {
                request(j2);
            }

            @Override // rx.f
            public void onCompleted() {
                this.f26235f.f();
                a.this.b();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.f26230g.onError(th);
            }

            @Override // rx.f
            public void onNext(Object obj) {
                try {
                    this.f26235f.g(obj);
                } catch (MissingBackpressureException e2) {
                    onError(e2);
                }
                a.this.b();
            }

            @Override // rx.j
            public void onStart() {
                request(rx.n.e.h.f26744f);
            }
        }

        static {
            double d2 = rx.n.e.h.f26744f;
            Double.isNaN(d2);
            f26229f = (int) (d2 * 0.7d);
        }

        public a(rx.j<? super R> jVar, rx.m.h<? extends R> hVar) {
            rx.t.b bVar = new rx.t.b();
            this.f26232i = bVar;
            this.f26230g = jVar;
            this.f26231h = hVar;
            jVar.add(bVar);
        }

        public void a(rx.e[] eVarArr, AtomicLong atomicLong) {
            Object[] objArr = new Object[eVarArr.length];
            for (int i2 = 0; i2 < eVarArr.length; i2++) {
                C0442a c0442a = new C0442a();
                objArr[i2] = c0442a;
                this.f26232i.a(c0442a);
            }
            this.l = atomicLong;
            this.f26234k = objArr;
            for (int i3 = 0; i3 < eVarArr.length; i3++) {
                eVarArr[i3].c1((C0442a) objArr[i3]);
            }
        }

        void b() {
            Object[] objArr = this.f26234k;
            if (objArr == null || getAndIncrement() != 0) {
                return;
            }
            int length = objArr.length;
            rx.f<? super R> fVar = this.f26230g;
            AtomicLong atomicLong = this.l;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i2 = 0; i2 < length; i2++) {
                    rx.n.e.h hVar = ((C0442a) objArr[i2]).f26235f;
                    Object objH = hVar.h();
                    if (objH == null) {
                        z = false;
                    } else {
                        if (hVar.d(objH)) {
                            fVar.onCompleted();
                            this.f26232i.unsubscribe();
                            return;
                        }
                        objArr2[i2] = hVar.c(objH);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        fVar.onNext(this.f26231h.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.f26233j++;
                        for (Object obj : objArr) {
                            rx.n.e.h hVar2 = ((C0442a) obj).f26235f;
                            hVar2.i();
                            if (hVar2.d(hVar2.h())) {
                                fVar.onCompleted();
                                this.f26232i.unsubscribe();
                                return;
                            }
                        }
                        if (this.f26233j > f26229f) {
                            for (Object obj2 : objArr) {
                                ((C0442a) obj2).c(this.f26233j);
                            }
                            this.f26233j = 0;
                        }
                    } catch (Throwable th) {
                        rx.exceptions.a.g(th, fVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: compiled from: OperatorZip.java */
    static final class b<R> extends AtomicLong implements rx.g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final a<R> f26237f;

        public b(a<R> aVar) {
            this.f26237f = aVar;
        }

        @Override // rx.g
        public void request(long j2) {
            rx.n.a.a.b(this, j2);
            this.f26237f.b();
        }
    }

    /* JADX INFO: compiled from: OperatorZip.java */
    final class c extends rx.j<rx.e[]> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final rx.j<? super R> f26238f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final a<R> f26239g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final b<R> f26240h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f26241i;

        public c(rx.j<? super R> jVar, a<R> aVar, b<R> bVar) {
            this.f26238f = jVar;
            this.f26239g = aVar;
            this.f26240h = bVar;
        }

        @Override // rx.f
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onNext(rx.e[] eVarArr) {
            if (eVarArr == null || eVarArr.length == 0) {
                this.f26238f.onCompleted();
            } else {
                this.f26241i = true;
                this.f26239g.a(eVarArr, this.f26240h);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f26241i) {
                return;
            }
            this.f26238f.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26238f.onError(th);
        }
    }

    public g1(rx.m.f fVar) {
        this.f26228f = rx.m.i.a(fVar);
    }

    @Override // rx.m.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super rx.e[]> call(rx.j<? super R> jVar) {
        a aVar = new a(jVar, this.f26228f);
        b bVar = new b(aVar);
        c cVar = new c(jVar, aVar, bVar);
        jVar.add(cVar);
        jVar.setProducer(bVar);
        return cVar;
    }
}
