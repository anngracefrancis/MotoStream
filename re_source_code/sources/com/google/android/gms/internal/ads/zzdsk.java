package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdsk extends zzdrr<zzdsk> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16119c = null;

    public zzdsk() {
        this.f16072b = null;
        this.a = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void a(zzdrp zzdrpVar) throws IOException {
        String str = this.f16119c;
        if (str != null) {
            zzdrpVar.k(1, str);
        }
        super.a(zzdrpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    protected final int e() {
        int iE = super.e();
        String str = this.f16119c;
        return str != null ? iE + zzdrp.n(1, str) : iE;
    }
}
