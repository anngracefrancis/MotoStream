package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbuj implements zzdti<Set<zzbuz<AppEventListener>>> {
    private final zzbtv a;

    private zzbuj(zzbtv zzbtvVar) {
        this.a = zzbtvVar;
    }

    public static zzbuj a(zzbtv zzbtvVar) {
        return new zzbuj(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.b(this.a.g(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
