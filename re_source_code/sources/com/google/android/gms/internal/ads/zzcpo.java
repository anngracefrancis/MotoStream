package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcpo extends zzzg {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f15510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbjm f15511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @VisibleForTesting
    private final zzcxx f15512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @VisibleForTesting
    private final zzbze f15513i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzyz f15514j;

    public zzcpo(zzbjm zzbjmVar, Context context, String str) {
        zzcxx zzcxxVar = new zzcxx();
        this.f15512h = zzcxxVar;
        this.f15513i = new zzbze();
        this.f15511g = zzbjmVar;
        zzcxxVar.t(str);
        this.f15510f = context;
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void D5(String str, zzafr zzafrVar, zzafo zzafoVar) {
        this.f15513i.g(str, zzafrVar, zzafoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void G3(zzafi zzafiVar) {
        this.f15513i.c(zzafiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final zzzc J1() {
        zzbzc zzbzcVarB = this.f15513i.b();
        this.f15512h.h(zzbzcVarB.f());
        this.f15512h.l(zzbzcVarB.g());
        zzcxx zzcxxVar = this.f15512h;
        if (zzcxxVar.G() == null) {
            zzcxxVar.n(zzyd.Y(this.f15510f));
        }
        return new zzcpp(this.f15510f, this.f15511g, this.f15512h, zzbzcVarB, this.f15514j);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void M2(zzaje zzajeVar) {
        this.f15513i.f(zzajeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void Q3(zzaiy zzaiyVar) {
        this.f15512h.g(zzaiyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void X1(PublisherAdViewOptions publisherAdViewOptions) {
        this.f15512h.e(publisherAdViewOptions);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void Z3(zzafx zzafxVar) {
        this.f15513i.e(zzafxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void e2(zzyz zzyzVar) {
        this.f15514j = zzyzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void i1(zzafu zzafuVar, zzyd zzydVar) {
        this.f15513i.a(zzafuVar);
        this.f15512h.n(zzydVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void k6(zzady zzadyVar) {
        this.f15512h.f(zzadyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void q5(zzzy zzzyVar) {
        this.f15512h.o(zzzyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void y1(zzafl zzaflVar) {
        this.f15513i.d(zzaflVar);
    }
}
