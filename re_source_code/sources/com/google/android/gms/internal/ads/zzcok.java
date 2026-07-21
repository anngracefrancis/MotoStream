package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcok implements zzcjv<zzbnf> {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzboc f15468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzado f15469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbbl f15470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzczt f15471e;

    public zzcok(Context context, zzboc zzbocVar, zzczt zzcztVar, zzbbl zzbblVar, zzado zzadoVar) {
        this.a = context;
        this.f15468b = zzbocVar;
        this.f15471e = zzcztVar;
        this.f15470d = zzbblVar;
        this.f15469c = zzadoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<zzbnf> a(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        zzbng zzbngVarA = this.f15468b.a(new zzbpr(zzcxuVar, zzcxmVar, null), new nm(this, new View(this.a), null, lm.a, zzcxmVar.r.get(0)));
        zzcoo zzcooVarJ = zzbngVarA.j();
        zzcxq zzcxqVar = zzcxmVar.p;
        final zzadj zzadjVar = new zzadj(zzcooVarJ, zzcxqVar.f15741b, zzcxqVar.a);
        return this.f15471e.g(zzczs.CUSTOM_RENDER_SYN).a(new zzczd(this, zzadjVar) { // from class: com.google.android.gms.internal.ads.mm
            private final zzcok a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final zzadj f12992b;

            {
                this.a = this;
                this.f12992b = zzadjVar;
            }

            @Override // com.google.android.gms.internal.ads.zzczd
            public final void run() throws Exception {
                this.a.c(this.f12992b);
            }
        }, this.f15470d).j(zzczs.CUSTOM_RENDER_ACK).g(zzbar.o(zzbngVarA.g())).f();
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean b(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        zzcxq zzcxqVar;
        return (this.f15469c == null || (zzcxqVar = zzcxmVar.p) == null || zzcxqVar.a == null) ? false : true;
    }

    final /* synthetic */ void c(zzadj zzadjVar) throws Exception {
        this.f15469c.O2(zzadjVar);
    }
}
