package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzceu implements zzdti<zzcez> {
    private static final zzceu a = new zzceu();

    public static zzceu a() {
        return a;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcez) zzdto.b(new zzcez(zzwl.zza.zzb.REQUEST_WILL_MAKE_NETWORK_REQUEST, zzwl.zza.zzb.REQUEST_DID_RECEIVE_NETWORK_RESPONSE, zzwl.zza.zzb.REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST), "Cannot return null from a non-@Nullable @Provides method");
    }
}
