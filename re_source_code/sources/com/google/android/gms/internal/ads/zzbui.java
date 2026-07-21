package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbui implements zzdti<Set<zzbuz<AdMetadataListener>>> {
    private final zzbtv a;

    private zzbui(zzbtv zzbtvVar) {
        this.a = zzbtvVar;
    }

    public static zzbui a(zzbtv zzbtvVar) {
        return new zzbui(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.b(this.a.f(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
