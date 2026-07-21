package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcam implements zzdti<zzbuz<VideoController.VideoLifecycleCallbacks>> {
    private final zzcag a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzccw> f14981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<Executor> f14982c;

    public zzcam(zzcag zzcagVar, zzdtu<zzccw> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.a = zzcagVar;
        this.f14981b = zzdtuVar;
        this.f14982c = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.f14981b.get(), this.f14982c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
