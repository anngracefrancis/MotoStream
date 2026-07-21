package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbfq extends zzawv {
    final zzbdf a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final zzbft f14426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String[] f14428d;

    zzbfq(zzbdf zzbdfVar, zzbft zzbftVar, String str, String[] strArr) {
        this.a = zzbdfVar;
        this.f14426b = zzbftVar;
        this.f14427c = str;
        this.f14428d = strArr;
        zzk.zzmc().c(this);
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final void zzto() {
        try {
            this.f14426b.x(this.f14427c, this.f14428d);
        } finally {
            zzaxi.a.post(new y9(this));
        }
    }
}
