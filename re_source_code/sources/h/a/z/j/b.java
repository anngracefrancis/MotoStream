package h.a.z.j;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: BackpressureHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static long a(AtomicLong atomicLong, long j2) {
        long j3;
        do {
            j3 = atomicLong.get();
            if (j3 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j3, b(j3, j2)));
        return j3;
    }

    public static long b(long j2, long j3) {
        long j4 = j2 + j3;
        if (j4 < 0) {
            return Long.MAX_VALUE;
        }
        return j4;
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
                h.a.a0.a.o(new IllegalStateException("More produced than requested: " + j4));
                j4 = 0L;
            }
        } while (!atomicLong.compareAndSet(j3, j4));
        return j4;
    }
}
