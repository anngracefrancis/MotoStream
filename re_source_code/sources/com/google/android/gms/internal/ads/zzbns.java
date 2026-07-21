package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbns implements zzdti<zzbuz<zzbsr>> {
    private final zzbnk a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Context> f14595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbai> f14596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzcxm> f14597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzcxv> f14598e;

    public zzbns(zzbnk zzbnkVar, zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzcxm> zzdtuVar3, zzdtu<zzcxv> zzdtuVar4) {
        this.a = zzbnkVar;
        this.f14595b = zzdtuVar;
        this.f14596c = zzdtuVar2;
        this.f14597d = zzdtuVar3;
        this.f14598e = zzdtuVar4;
    }

    public static zzbuz<zzbsr> a(zzbnk zzbnkVar, final Context context, final zzbai zzbaiVar, final zzcxm zzcxmVar, final zzcxv zzcxvVar) {
        return (zzbuz) zzdto.b(new zzbuz(new zzbsr(context, zzbaiVar, zzcxmVar, zzcxvVar) { // from class: com.google.android.gms.internal.ads.ad

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final Context f12249f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzbai f12250g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final zzcxm f12251h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private final zzcxv f12252i;

            {
                this.f12249f = context;
                this.f12250g = zzbaiVar;
                this.f12251h = zzcxmVar;
                this.f12252i = zzcxvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbsr
            public final void onAdLoaded() {
                zzk.zzlq().c(this.f12249f, this.f12250g.f14326f, this.f12251h.z.toString(), this.f12252i.f15752f);
            }
        }, zzbbm.f14331b), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return a(this.a, this.f14595b.get(), this.f14596c.get(), this.f14597d.get(), this.f14598e.get());
    }
}
