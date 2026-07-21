package com.google.android.gms.internal.ads;

import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class zzkt {
    public static final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final UUID f16407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final UUID f16408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final UUID f16409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final UUID f16410e;

    static {
        a = zzsy.a < 23 ? 1020 : 6396;
        f16407b = new UUID(0L, 0L);
        f16408c = new UUID(1186680826959645954L, -5988876978535335093L);
        f16409d = new UUID(-1301668207276963122L, -6645017420763422227L);
        f16410e = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long a(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j2 / 1000;
    }

    public static long b(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j2 * 1000;
    }
}
