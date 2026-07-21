package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class gc implements zzbwt {
    private zzbtv a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzcyg f12645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzcyo f12646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzbqy f12647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzcfp f12648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzbpx f12649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzbqt f12650g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzcow f12651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzbkc f12652i;

    private gc(zzbkc zzbkcVar) {
        this.f12652i = zzbkcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final zzbws a() {
        zzdto.c(this.a, zzbtv.class);
        if (this.f12645b == null) {
            this.f12645b = new zzcyg();
        }
        if (this.f12646c == null) {
            this.f12646c = new zzcyo();
        }
        zzdto.c(this.f12647d, zzbqy.class);
        if (this.f12648e == null) {
            this.f12648e = new zzcfp();
        }
        if (this.f12649f == null) {
            this.f12649f = new zzbpx();
        }
        if (this.f12650g == null) {
            this.f12650g = new zzbqt();
        }
        zzdto.c(this.f12651h, zzcow.class);
        return new hc(this.f12652i, this.a, this.f12645b, this.f12646c, this.f12647d, this.f12648e, this.f12649f, this.f12650g, this.f12651h);
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final /* synthetic */ zzbwt b(zzcow zzcowVar) {
        this.f12651h = (zzcow) zzdto.a(zzcowVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final /* synthetic */ zzbwt c(zzbqy zzbqyVar) {
        this.f12647d = (zzbqy) zzdto.a(zzbqyVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final /* synthetic */ zzbwt d(zzbtv zzbtvVar) {
        this.a = (zzbtv) zzdto.a(zzbtvVar);
        return this;
    }
}
