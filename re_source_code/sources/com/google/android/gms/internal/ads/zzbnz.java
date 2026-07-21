package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbnz implements zzdti<zzbuz<zzbto>> {
    private final zzbnk a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbtb> f14607b;

    public zzbnz(zzbnk zzbnkVar, zzdtu<zzbtb> zzdtuVar) {
        this.a = zzbnkVar;
        this.f14607b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        final zzbtb zzbtbVar = this.f14607b.get();
        return (zzbuz) zzdto.b(new zzbuz(new zzbto(zzbtbVar) { // from class: com.google.android.gms.internal.ads.bd

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbtb f12350f;

            {
                this.f12350f = zzbtbVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbto
            public final void u() {
                this.f12350f.f0();
            }
        }, zzbbm.f14331b), "Cannot return null from a non-@Nullable @Provides method");
    }
}
