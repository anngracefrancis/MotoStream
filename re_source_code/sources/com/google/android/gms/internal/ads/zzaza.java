package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaza extends zzr<zzp> {
    private final zzbbr<zzp> u;
    private final Map<String, String> v;
    private final zzazx w;

    public zzaza(String str, zzbbr<zzp> zzbbrVar) {
        this(str, null, zzbbrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzr
    protected final /* synthetic */ void F(zzp zzpVar) {
        zzp zzpVar2 = zzpVar;
        this.w.j(zzpVar2.f16553c, zzpVar2.a);
        zzazx zzazxVar = this.w;
        byte[] bArr = zzpVar2.f16552b;
        if (zzazx.a() && bArr != null) {
            zzazxVar.s(bArr);
        }
        this.u.a(zzpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzr
    protected final zzy<zzp> y(zzp zzpVar) {
        return zzy.a(zzpVar, zzaq.a(zzpVar));
    }

    private zzaza(String str, Map<String, String> map, zzbbr<zzp> zzbbrVar) {
        super(0, str, new a6(zzbbrVar));
        this.v = null;
        this.u = zzbbrVar;
        zzazx zzazxVar = new zzazx();
        this.w = zzazxVar;
        zzazxVar.f(str, "GET", null, null);
    }
}
