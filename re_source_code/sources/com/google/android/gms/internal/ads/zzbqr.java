package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbqr implements zzbtk {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f14693f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcxv f14694g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzbai f14695h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzaxb f14696i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzcgb f14697j;

    public zzbqr(Context context, zzcxv zzcxvVar, zzbai zzbaiVar, zzaxb zzaxbVar, zzcgb zzcgbVar) {
        this.f14693f = context;
        this.f14694g = zzcxvVar;
        this.f14695h = zzbaiVar;
        this.f14696i = zzaxbVar;
        this.f14697j = zzcgbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void N(zzarx zzarxVar) {
        if (((Boolean) zzyt.e().c(zzacu.c3)).booleanValue()) {
            zzk.zzlo().zza(this.f14693f, this.f14695h, this.f14694g.f15752f, this.f14696i.q());
        }
        this.f14697j.k();
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void q(zzcxu zzcxuVar) {
    }
}
