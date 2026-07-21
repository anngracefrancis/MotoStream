package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzxk extends zzdrr<zzxk> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16929c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzwt.zza[] f16930d = new zzwt.zza[0];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzwx f16931e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzwx f16932f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzwx f16933g = null;

    public zzxk() {
        this.f16072b = null;
        this.a = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void a(zzdrp zzdrpVar) throws IOException {
        String str = this.f16929c;
        if (str != null) {
            zzdrpVar.k(1, str);
        }
        zzwt.zza[] zzaVarArr = this.f16930d;
        if (zzaVarArr != null && zzaVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzwt.zza[] zzaVarArr2 = this.f16930d;
                if (i2 >= zzaVarArr2.length) {
                    break;
                }
                zzwt.zza zzaVar = zzaVarArr2[i2];
                if (zzaVar != null) {
                    zzdrpVar.j(2, zzaVar);
                }
                i2++;
            }
        }
        super.a(zzdrpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    protected final int e() {
        int iE = super.e();
        String str = this.f16929c;
        if (str != null) {
            iE += zzdrp.n(1, str);
        }
        zzwt.zza[] zzaVarArr = this.f16930d;
        if (zzaVarArr != null && zzaVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzwt.zza[] zzaVarArr2 = this.f16930d;
                if (i2 >= zzaVarArr2.length) {
                    break;
                }
                zzwt.zza zzaVar = zzaVarArr2[i2];
                if (zzaVar != null) {
                    iE += zzdni.K(2, zzaVar);
                }
                i2++;
            }
        }
        return iE;
    }
}
