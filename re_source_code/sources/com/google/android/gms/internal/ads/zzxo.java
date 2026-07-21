package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzxo extends zzdrr<zzxo> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f16951c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f16952d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f16953e = null;

    public zzxo() {
        this.f16072b = null;
        this.a = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void a(zzdrp zzdrpVar) throws IOException {
        Integer num = this.f16951c;
        if (num != null) {
            zzdrpVar.x(1, num.intValue());
        }
        Integer num2 = this.f16952d;
        if (num2 != null) {
            zzdrpVar.x(2, num2.intValue());
        }
        Integer num3 = this.f16953e;
        if (num3 != null) {
            zzdrpVar.x(3, num3.intValue());
        }
        super.a(zzdrpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    protected final int e() {
        int iE = super.e();
        Integer num = this.f16951c;
        if (num != null) {
            iE += zzdrp.d(1, num.intValue());
        }
        Integer num2 = this.f16952d;
        if (num2 != null) {
            iE += zzdrp.d(2, num2.intValue());
        }
        Integer num3 = this.f16953e;
        return num3 != null ? iE + zzdrp.d(3, num3.intValue()) : iE;
    }
}
