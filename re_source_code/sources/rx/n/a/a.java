package rx.n.a;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: BackpressureUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static long a(long j2, long j3) {
        long j4 = j2 + j3;
        if (j4 < 0) {
            return Long.MAX_VALUE;
        }
        return j4;
    }

    public static long b(AtomicLong atomicLong, long j2) {
        long j3;
        do {
            j3 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j3, a(j3, j2)));
        return j3;
    }

    public static long c(AtomicLong atomicLong, long j2) {
        long j3;
        long j4;
        do {
            j3 = atomicLong.get();
            if (j3 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j4 = j3 - j2;
            if (j4 < 0) {
                throw new IllegalStateException("More produced than requested: " + j4);
            }
        } while (!atomicLong.compareAndSet(j3, j4));
        return j4;
    }

    public static boolean d(long j2) {
        if (j2 >= 0) {
            return j2 != 0;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j2);
    }
}
