package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class kv {
    private static final kv a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kv f12896b;

    static {
        lv lvVar = null;
        a = new mv();
        f12896b = new nv();
    }

    private kv() {
    }

    static kv c() {
        return a;
    }

    static kv d() {
        return f12896b;
    }

    abstract <L> List<L> a(Object obj, long j2);

    abstract <L> void b(Object obj, Object obj2, long j2);

    abstract void e(Object obj, long j2);
}
