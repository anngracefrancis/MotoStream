package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbvw implements zzdti<zzbvq> {
    private final zzdtu<Set<zzbuz<VideoController.VideoLifecycleCallbacks>>> a;

    private zzbvw(zzdtu<Set<zzbuz<VideoController.VideoLifecycleCallbacks>>> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzbvw a(zzdtu<Set<zzbuz<VideoController.VideoLifecycleCallbacks>>> zzdtuVar) {
        return new zzbvw(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbvq(this.a.get());
    }
}
