package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class jc implements zzcdg {
    private zzbtv a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzcyg f12817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzcyo f12818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzbqy f12819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzcfp f12820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzbpx f12821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzbqt f12822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzbkc f12823h;

    private jc(zzbkc zzbkcVar) {
        this.f12823h = zzbkcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcdg
    public final /* synthetic */ zzcdg a(zzbqy zzbqyVar) {
        this.f12819d = (zzbqy) zzdto.a(zzbqyVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcdg
    public final zzcdf b() {
        zzdto.c(this.a, zzbtv.class);
        if (this.f12817b == null) {
            this.f12817b = new zzcyg();
        }
        if (this.f12818c == null) {
            this.f12818c = new zzcyo();
        }
        zzdto.c(this.f12819d, zzbqy.class);
        if (this.f12820e == null) {
            this.f12820e = new zzcfp();
        }
        if (this.f12821f == null) {
            this.f12821f = new zzbpx();
        }
        if (this.f12822g == null) {
            this.f12822g = new zzbqt();
        }
        return new kc(this.f12823h, this.a, this.f12817b, this.f12818c, this.f12819d, this.f12820e, this.f12821f, this.f12822g);
    }

    @Override // com.google.android.gms.internal.ads.zzcdg
    public final /* synthetic */ zzcdg c(zzbtv zzbtvVar) {
        this.a = (zzbtv) zzdto.a(zzbtvVar);
        return this;
    }
}
