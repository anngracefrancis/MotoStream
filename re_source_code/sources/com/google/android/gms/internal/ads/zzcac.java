package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcac implements zzbrw {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbyt f14957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbyx f14958g;

    public zzcac(zzbyt zzbytVar, zzbyx zzbyxVar) {
        this.f14957f = zzbytVar;
        this.f14958g = zzbyxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrw
    public final void onAdImpression() {
        if (this.f14957f.C() == null) {
            return;
        }
        zzbgz zzbgzVarB = this.f14957f.B();
        zzbgz zzbgzVarA = this.f14957f.A();
        if (zzbgzVarB == null) {
            zzbgzVarB = zzbgzVarA != null ? zzbgzVarA : null;
        }
        if (!this.f14958g.d() || zzbgzVarB == null) {
            return;
        }
        zzbgzVarB.y("onSdkImpression", new c.e.a());
    }
}
