package com.flurry.sdk;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class u3 extends r6 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicInteger f11076e = new AtomicInteger(0);

    private u3(t6 t6Var) {
        super(t6Var);
    }

    public static e.d.a.d h(String str, v3.a aVar, Map<String, String> map, boolean z, boolean z2, long j2, long j3) {
        HashMap map2;
        if (map.size() > 10) {
            map2 = new HashMap();
            map2.put("fl.parameter.limit.exceeded", String.valueOf(map.size()));
            map.clear();
        } else {
            map2 = null;
        }
        m2.a().b(new u3(new v3(c2.b(str), f11076e.incrementAndGet(), aVar, map, map2, new ArrayList(), z, z2, j2, j3)));
        return e.d.a.d.kFlurryEventRecorded;
    }

    public static u3 i(String str, int i2, Map<String, String> map, Map<String, String> map2, long j2, long j3) {
        return new u3(new v3(str, i2, v3.a.CUSTOM, map, map2, true, false, j2, SystemClock.elapsedRealtime(), j3));
    }

    @Override // com.flurry.sdk.u6
    public final s6 a() {
        return s6.ANALYTICS_EVENT;
    }
}
