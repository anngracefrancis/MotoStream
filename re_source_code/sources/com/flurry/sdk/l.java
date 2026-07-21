package com.flurry.sdk;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    protected Map<m, String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10893b;

    l() {
        this.a = new HashMap();
    }

    public final Map<m, String> a() {
        return this.a;
    }

    final void b(m mVar, String str) {
        this.a.put(mVar, str);
    }

    final l c() {
        return new l(Collections.unmodifiableMap(this.a), this.f10893b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(this.f10893b);
        return sb.toString();
    }

    private l(Map<m, String> map, boolean z) {
        this.a = map;
        this.f10893b = z;
    }
}
