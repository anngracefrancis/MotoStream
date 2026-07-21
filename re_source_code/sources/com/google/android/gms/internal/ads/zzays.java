package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class zzays {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f14286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f14287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f14288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14289e;

    public zzays(String str, double d2, double d3, double d4, int i2) {
        this.a = str;
        this.f14287c = d2;
        this.f14286b = d3;
        this.f14288d = d4;
        this.f14289e = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzays)) {
            return false;
        }
        zzays zzaysVar = (zzays) obj;
        return Objects.a(this.a, zzaysVar.a) && this.f14286b == zzaysVar.f14286b && this.f14287c == zzaysVar.f14287c && this.f14289e == zzaysVar.f14289e && Double.compare(this.f14288d, zzaysVar.f14288d) == 0;
    }

    public final int hashCode() {
        return Objects.b(this.a, Double.valueOf(this.f14286b), Double.valueOf(this.f14287c), Double.valueOf(this.f14288d), Integer.valueOf(this.f14289e));
    }

    public final String toString() {
        return Objects.c(this).a("name", this.a).a("minBound", Double.valueOf(this.f14287c)).a("maxBound", Double.valueOf(this.f14286b)).a("percent", Double.valueOf(this.f14288d)).a("count", Integer.valueOf(this.f14289e)).toString();
    }
}
