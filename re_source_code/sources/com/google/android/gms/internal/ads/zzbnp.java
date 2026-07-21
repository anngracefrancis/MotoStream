package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbnp implements zzdti<zzcxn> {
    private final zzbnk a;

    public zzbnp(zzbnk zzbnkVar) {
        this.a = zzbnkVar;
    }

    public static zzcxn a(zzbnk zzbnkVar) {
        return (zzcxn) zzdto.b(zzbnkVar.e(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return a(this.a);
    }
}
