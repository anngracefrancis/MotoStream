package rx.n.c;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SchedulePeriodicHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public static final long a = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    /* JADX INFO: compiled from: SchedulePeriodicHelper.java */
    static class a implements rx.m.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f26677f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f26678g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long f26679h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f26680i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ long f26681j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ rx.m.a f26682k;
        final /* synthetic */ rx.n.d.a l;
        final /* synthetic */ b m;
        final /* synthetic */ rx.h.a n;
        final /* synthetic */ long o;

        a(long j2, long j3, rx.m.a aVar, rx.n.d.a aVar2, b bVar, rx.h.a aVar3, long j4) {
            this.f26680i = j2;
            this.f26681j = j3;
            this.f26682k = aVar;
            this.l = aVar2;
            this.m = bVar;
            this.n = aVar3;
            this.o = j4;
            this.f26678g = j2;
            this.f26679h = j3;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0042  */
        @Override // rx.m.a
        public void call() {
            long j2;
            this.f26682k.call();
            if (this.l.isUnsubscribed()) {
                return;
            }
            b bVar = this.m;
            long jA = bVar != null ? bVar.a() : TimeUnit.MILLISECONDS.toNanos(this.n.b());
            long j3 = i.a;
            long j4 = jA + j3;
            long j5 = this.f26678g;
            if (j4 >= j5) {
                long j6 = this.o;
                if (jA >= j5 + j6 + j3) {
                    long j7 = this.o;
                    long j8 = jA + j7;
                    long j9 = this.f26677f + 1;
                    this.f26677f = j9;
                    this.f26679h = j8 - (j7 * j9);
                    j2 = j8;
                } else {
                    long j10 = this.f26679h;
                    long j11 = this.f26677f + 1;
                    this.f26677f = j11;
                    j2 = j10 + (j11 * j6);
                }
            } else {
                long j12 = this.o;
                long j13 = jA + j12;
                long j14 = this.f26677f + 1;
                this.f26677f = j14;
                this.f26679h = j13 - (j12 * j14);
                j2 = j13;
            }
            this.f26678g = jA;
            this.l.b(this.n.d(this, j2 - jA, TimeUnit.NANOSECONDS));
        }
    }

    /* JADX INFO: compiled from: SchedulePeriodicHelper.java */
    public interface b {
        long a();
    }

    public static rx.k a(rx.h.a aVar, rx.m.a aVar2, long j2, long j3, TimeUnit timeUnit, b bVar) {
        long nanos = timeUnit.toNanos(j3);
        long jA = bVar != null ? bVar.a() : TimeUnit.MILLISECONDS.toNanos(aVar.b());
        long nanos2 = timeUnit.toNanos(j2) + jA;
        rx.n.d.a aVar3 = new rx.n.d.a();
        rx.n.d.a aVar4 = new rx.n.d.a(aVar3);
        aVar3.b(aVar.d(new a(jA, nanos2, aVar2, aVar4, bVar, aVar, nanos), j2, timeUnit));
        return aVar4;
    }
}
