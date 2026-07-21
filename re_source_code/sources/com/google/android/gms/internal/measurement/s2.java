package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class s2 {
    private static final s2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final s2 f17254b;

    static {
        r2 r2Var = null;
        a = new u2();
        f17254b = new t2();
    }

    private s2() {
    }

    static s2 a() {
        return a;
    }

    static s2 d() {
        return f17254b;
    }

    abstract <L> List<L> b(Object obj, long j2);

    abstract <L> void c(Object obj, Object obj2, long j2);

    abstract void e(Object obj, long j2);
}
