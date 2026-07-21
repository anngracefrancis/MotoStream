package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbwd implements zzdti<zzbuz<zzbsr>> {
    private final zzbvz a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Context> f14767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbai> f14768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzcxm> f14769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzcxv> f14770e;

    private zzbwd(zzbvz zzbvzVar, zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzcxm> zzdtuVar3, zzdtu<zzcxv> zzdtuVar4) {
        this.a = zzbvzVar;
        this.f14767b = zzdtuVar;
        this.f14768c = zzdtuVar2;
        this.f14769d = zzdtuVar3;
        this.f14770e = zzdtuVar4;
    }

    public static zzbwd a(zzbvz zzbvzVar, zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzcxm> zzdtuVar3, zzdtu<zzcxv> zzdtuVar4) {
        return new zzbwd(zzbvzVar, zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        final Context context = this.f14767b.get();
        final zzbai zzbaiVar = this.f14768c.get();
        final zzcxm zzcxmVar = this.f14769d.get();
        final zzcxv zzcxvVar = this.f14770e.get();
        return (zzbuz) zzdto.b(new zzbuz(new zzbsr(context, zzbaiVar, zzcxmVar, zzcxvVar) { // from class: com.google.android.gms.internal.ads.kf

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final Context f12874f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzbai f12875g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final zzcxm f12876h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private final zzcxv f12877i;

            {
                this.f12874f = context;
                this.f12875g = zzbaiVar;
                this.f12876h = zzcxmVar;
                this.f12877i = zzcxvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbsr
            public final void onAdLoaded() {
                zzk.zzlq().c(this.f12874f, this.f12875g.f14326f, this.f12876h.z.toString(), this.f12877i.f15752f);
            }
        }, zzbbm.f14331b), "Cannot return null from a non-@Nullable @Provides method");
    }
}
