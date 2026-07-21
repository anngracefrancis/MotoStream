package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbtr implements zzdti<zzbtp> {
    private final zzdtu<Set<zzbuz<AppEventListener>>> a;

    private zzbtr(zzdtu<Set<zzbuz<AppEventListener>>> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzbtr a(zzdtu<Set<zzbuz<AppEventListener>>> zzdtuVar) {
        return new zzbtr(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbtp(this.a.get());
    }
}
