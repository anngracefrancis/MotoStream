package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class g0 implements zzaho<Object> {
    g0() {
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void a(Object obj, Map<String, String> map) {
        String strValueOf = String.valueOf(map.get("string"));
        zzbad.h(strValueOf.length() != 0 ? "Received log message: ".concat(strValueOf) : new String("Received log message: "));
    }
}
