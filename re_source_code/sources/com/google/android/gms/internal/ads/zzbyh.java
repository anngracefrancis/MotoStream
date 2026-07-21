package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbyh implements zzdti<zzccj> {
    private final zzbyc a;

    public zzbyh(zzbyc zzbycVar) {
        this.a = zzbycVar;
    }

    public static zzccj a(zzbyc zzbycVar) {
        return (zzccj) zzdto.b(zzbycVar.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return a(this.a);
    }
}
