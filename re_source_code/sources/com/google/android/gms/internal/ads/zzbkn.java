package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbkn {
    private zzcye a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzbjn f14506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzbld f14507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzbkw f14508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzdac f14509e;

    private zzbkn() {
    }

    public final zzbkn a(zzbkw zzbkwVar) {
        this.f14508d = (zzbkw) zzdto.a(zzbkwVar);
        return this;
    }

    public final zzbjm b() {
        if (this.a == null) {
            this.a = new zzcye();
        }
        zzdto.c(this.f14506b, zzbjn.class);
        if (this.f14507c == null) {
            this.f14507c = new zzbld();
        }
        zzdto.c(this.f14508d, zzbkw.class);
        if (this.f14509e == null) {
            this.f14509e = new zzdac();
        }
        return new zzbkc(this.a, this.f14506b, this.f14507c, this.f14508d, this.f14509e);
    }

    public final zzbkn c(zzbjn zzbjnVar) {
        this.f14506b = (zzbjn) zzdto.a(zzbjnVar);
        return this;
    }
}
