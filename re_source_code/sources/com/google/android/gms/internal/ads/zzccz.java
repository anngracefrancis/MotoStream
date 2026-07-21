package com.google.android.gms.internal.ads;

import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzccz implements zzahy {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbse f15082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzato f15083g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f15084h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f15085i;

    public zzccz(zzbse zzbseVar, zzcxm zzcxmVar) {
        this.f15082f = zzbseVar;
        this.f15083g = zzcxmVar.l;
        this.f15084h = zzcxmVar.f15732j;
        this.f15085i = zzcxmVar.f15733k;
    }

    @Override // com.google.android.gms.internal.ads.zzahy
    public final void P(zzato zzatoVar) {
        String str;
        int i2;
        zzato zzatoVar2 = this.f15083g;
        if (zzatoVar2 != null) {
            zzatoVar = zzatoVar2;
        }
        if (zzatoVar != null) {
            str = zzatoVar.f14157f;
            i2 = zzatoVar.f14158g;
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
            i2 = 1;
        }
        this.f15082f.q0(new zzasp(str, i2), this.f15084h, this.f15085i);
    }

    @Override // com.google.android.gms.internal.ads.zzahy
    public final void j() {
        this.f15082f.i0();
    }

    @Override // com.google.android.gms.internal.ads.zzahy
    public final void r() {
        this.f15082f.o0();
    }
}
