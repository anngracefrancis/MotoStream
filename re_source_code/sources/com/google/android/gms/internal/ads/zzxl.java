package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzxl extends zzdrr<zzxl> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16934c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzwt.zzn f16935d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Integer f16936e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public zzxo f16937f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Integer f16938g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzwx f16939h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzwx f16940i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzwx f16941j = null;

    public zzxl() {
        this.f16072b = null;
        this.a = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void a(zzdrp zzdrpVar) throws IOException {
        String str = this.f16934c;
        if (str != null) {
            zzdrpVar.k(1, str);
        }
        zzxo zzxoVar = this.f16937f;
        if (zzxoVar != null) {
            zzdrpVar.b(4, zzxoVar);
        }
        super.a(zzdrpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    protected final int e() {
        int iE = super.e();
        String str = this.f16934c;
        if (str != null) {
            iE += zzdrp.n(1, str);
        }
        zzxo zzxoVar = this.f16937f;
        return zzxoVar != null ? iE + zzdrp.g(4, zzxoVar) : iE;
    }
}
