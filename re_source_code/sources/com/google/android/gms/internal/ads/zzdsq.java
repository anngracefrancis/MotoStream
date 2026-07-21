package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdsq extends zzdrr<zzdsq> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16140c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f16141d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f16142e = null;

    public zzdsq() {
        this.f16072b = null;
        this.a = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void a(zzdrp zzdrpVar) throws IOException {
        String str = this.f16140c;
        if (str != null) {
            zzdrpVar.k(1, str);
        }
        Long l = this.f16141d;
        if (l != null) {
            long jLongValue = l.longValue();
            zzdrpVar.w(2, 0);
            zzdrpVar.l(jLongValue);
        }
        Boolean bool = this.f16142e;
        if (bool != null) {
            zzdrpVar.u(3, bool.booleanValue());
        }
        super.a(zzdrpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    protected final int e() {
        int iE = super.e();
        String str = this.f16140c;
        if (str != null) {
            iE += zzdrp.n(1, str);
        }
        Long l = this.f16141d;
        if (l != null) {
            iE += zzdrp.o(2) + zzdrp.m(l.longValue());
        }
        Boolean bool = this.f16142e;
        if (bool == null) {
            return iE;
        }
        bool.booleanValue();
        return iE + zzdrp.o(3) + 1;
    }
}
