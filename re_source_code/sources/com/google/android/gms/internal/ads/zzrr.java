package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzrr {
    public final zzrb a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzro f16676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f16677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zzlq[] f16678d;

    public zzrr(zzrb zzrbVar, zzro zzroVar, Object obj, zzlq[] zzlqVarArr) {
        this.a = zzrbVar;
        this.f16676b = zzroVar;
        this.f16677c = obj;
        this.f16678d = zzlqVarArr;
    }

    public final boolean a(zzrr zzrrVar, int i2) {
        return zzrrVar != null && zzsy.g(this.f16676b.a(i2), zzrrVar.f16676b.a(i2)) && zzsy.g(this.f16678d[i2], zzrrVar.f16678d[i2]);
    }
}
