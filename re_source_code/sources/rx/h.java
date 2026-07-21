package rx;

import java.util.concurrent.TimeUnit;
import rx.n.c.l;

/* JADX INFO: compiled from: Scheduler.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: compiled from: Scheduler.java */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class a implements k {
        public long b() {
            return System.currentTimeMillis();
        }

        public abstract k c(rx.m.a aVar);

        public abstract k d(rx.m.a aVar, long j2, TimeUnit timeUnit);

        public k e(rx.m.a aVar, long j2, long j3, TimeUnit timeUnit) {
            return rx.n.c.i.a(this, aVar, j2, j3, timeUnit, null);
        }
    }

    public abstract a createWorker();

    public long now() {
        return System.currentTimeMillis();
    }

    public <S extends h & k> S when(rx.m.e<e<e<b>>, b> eVar) {
        return new l(eVar, this);
    }
}
