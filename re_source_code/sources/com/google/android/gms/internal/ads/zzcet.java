package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcet implements zzdti<zzcez> {
    private static final zzcet a = new zzcet();

    public static zzcet a() {
        return a;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcez) zzdto.b(new zzcez(zzwl.zza.zzb.REQUEST_WILL_UPDATE_GMS_SIGNALS, zzwl.zza.zzb.REQUEST_DID_UPDATE_GMS_SIGNALS, zzwl.zza.zzb.REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS), "Cannot return null from a non-@Nullable @Provides method");
    }
}
