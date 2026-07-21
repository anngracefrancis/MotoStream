package rx.n.a;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: OperatorTake.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b1<T> implements rx.e.b<T, T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f26137f;

    /* JADX INFO: compiled from: OperatorTake.java */
    class a extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f26138f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f26139g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ rx.j f26140h;

        /* JADX INFO: renamed from: rx.n.a.b1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OperatorTake.java */
        class C0441a implements rx.g {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final AtomicLong f26142f = new AtomicLong(0);

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ rx.g f26143g;

            C0441a(rx.g gVar) {
                this.f26143g = gVar;
            }

            @Override // rx.g
            public void request(long j2) {
                long j3;
                long jMin;
                if (j2 <= 0 || a.this.f26139g) {
                    return;
                }
                do {
                    j3 = this.f26142f.get();
                    jMin = Math.min(j2, ((long) b1.this.f26137f) - j3);
                    if (jMin == 0) {
                        return;
                    }
                } while (!this.f26142f.compareAndSet(j3, j3 + jMin));
                this.f26143g.request(jMin);
            }
        }

        a(rx.j jVar) {
            this.f26140h = jVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f26139g) {
                return;
            }
            this.f26139g = true;
            this.f26140h.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f26139g) {
                rx.q.c.j(th);
                return;
            }
            this.f26139g = true;
            try {
                this.f26140h.onError(th);
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onNext(T t) {
            if (isUnsubscribed()) {
                return;
            }
            int i2 = this.f26138f;
            int i3 = i2 + 1;
            this.f26138f = i3;
            int i4 = b1.this.f26137f;
            if (i2 < i4) {
                boolean z = i3 == i4;
                this.f26140h.onNext(t);
                if (!z || this.f26139g) {
                    return;
                }
                this.f26139g = true;
                try {
                    this.f26140h.onCompleted();
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.j
        public void setProducer(rx.g gVar) {
            this.f26140h.setProducer(new C0441a(gVar));
        }
    }

    public b1(int i2) {
        if (i2 >= 0) {
            this.f26137f = i2;
            return;
        }
        throw new IllegalArgumentException("limit >= 0 required but it was " + i2);
    }

    @Override // rx.m.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar);
        if (this.f26137f == 0) {
            jVar.onCompleted();
            aVar.unsubscribe();
        }
        jVar.add(aVar);
        return aVar;
    }
}
