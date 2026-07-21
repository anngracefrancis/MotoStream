package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcem implements zzdti<zzcez> {
    private static final zzcem a = new zzcem();

    public static zzcem a() {
        return a;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcez) zzdto.b(new zzcez(zzwl.zza.zzb.REQUEST_WILL_RENDER, zzwl.zza.zzb.REQUEST_DID_RENDER, zzwl.zza.zzb.REQUEST_FAILED_TO_RENDER), "Cannot return null from a non-@Nullable @Provides method");
    }
}
