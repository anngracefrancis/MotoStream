package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzsd {
    private final Map<String, String> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f16711b;

    public final synchronized Map<String, String> a() {
        if (this.f16711b == null) {
            this.f16711b = Collections.unmodifiableMap(new HashMap(this.a));
        }
        return this.f16711b;
    }
}
