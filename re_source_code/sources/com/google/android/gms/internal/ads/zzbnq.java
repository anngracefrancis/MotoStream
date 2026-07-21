package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbnq implements zzdti<zzbpb> {
    private final zzbnk a;

    public zzbnq(zzbnk zzbnkVar) {
        this.a = zzbnkVar;
    }

    public static zzbpb a(zzbnk zzbnkVar) {
        return (zzbpb) zzdto.b(zzbnkVar.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return a(this.a);
    }
}
