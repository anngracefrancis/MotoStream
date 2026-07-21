package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzces implements zzdti<zzcez> {
    private static final zzces a = new zzces();

    public static zzces a() {
        return a;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcez) zzdto.b(new zzcez(zzwl.zza.zzb.REQUEST_WILL_BUILD_URL, zzwl.zza.zzb.REQUEST_DID_BUILD_URL, zzwl.zza.zzb.REQUEST_FAILED_TO_BUILD_URL), "Cannot return null from a non-@Nullable @Provides method");
    }
}
