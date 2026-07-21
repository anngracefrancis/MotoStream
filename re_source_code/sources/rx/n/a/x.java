package rx.n.a;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: OnSubscribeRange.java */
/* JADX INFO: loaded from: classes3.dex */
public final class x implements rx.e.a<Integer> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f26536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f26537g;

    /* JADX INFO: compiled from: OnSubscribeRange.java */
    static final class a extends AtomicLong implements rx.g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final rx.j<? super Integer> f26538f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f26539g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f26540h;

        a(rx.j<? super Integer> jVar, int i2, int i3) {
            this.f26538f = jVar;
            this.f26540h = i2;
            this.f26539g = i3;
        }

        void a() {
            long j2 = ((long) this.f26539g) + 1;
            rx.j<? super Integer> jVar = this.f26538f;
            for (long j3 = this.f26540h; j3 != j2; j3++) {
                if (jVar.isUnsubscribed()) {
                    return;
                }
                jVar.onNext(Integer.valueOf((int) j3));
            }
            if (jVar.isUnsubscribed()) {
                return;
            }
            jVar.onCompleted();
        }

        void b(long j2) {
            long j3 = ((long) this.f26539g) + 1;
            long j4 = this.f26540h;
            rx.j<? super Integer> jVar = this.f26538f;
            do {
                long j5 = 0;
                while (true) {
                    if (j5 == j2 || j4 == j3) {
                        if (jVar.isUnsubscribed()) {
                            return;
                        }
                        if (j4 == j3) {
                            jVar.onCompleted();
                            return;
                        } else {
                            j2 = get();
                            if (j2 == j5) {
                                break;
                            }
                        }
                    } else {
                        if (jVar.isUnsubscribed()) {
                            return;
                        }
                        jVar.onNext(Integer.valueOf((int) j4));
                        j4++;
                        j5++;
                    }
                }
                this.f26540h = j4;
                j2 = addAndGet(-j5);
            } while (j2 != 0);
        }

        @Override // rx.g
        public void request(long j2) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j2 == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                a();
            } else {
                if (j2 <= 0 || rx.n.a.a.b(this, j2) != 0) {
                    return;
                }
                b(j2);
            }
        }
    }

    public x(int i2, int i3) {
        this.f26536f = i2;
        this.f26537g = i3;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super Integer> jVar) {
        jVar.setProducer(new a(jVar, this.f26536f, this.f26537g));
    }
}
