package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzboe implements zzdti<zzcjv<zzbnf>> {
    private final zzdtu<zzcxv> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzckv> f14609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzckb> f14610c;

    public zzboe(zzdtu<zzcxv> zzdtuVar, zzdtu<zzckv> zzdtuVar2, zzdtu<zzckb> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f14609b = zzdtuVar2;
        this.f14610c = zzdtuVar3;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0031  */
    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzcxv zzcxvVar = this.a.get();
        zzckv zzckvVar = this.f14609b.get();
        zzckb zzckbVar = this.f14610c.get();
        if (zzcxvVar.a() != null) {
            if (!((Boolean) zzyt.e().c(zzacu.t1)).booleanValue()) {
                zzckvVar = zzckbVar;
            }
        } else {
            zzckvVar = zzckbVar;
        }
        return (zzcjv) zzdto.b(zzckvVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
