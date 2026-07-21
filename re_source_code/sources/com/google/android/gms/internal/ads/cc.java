package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class cc implements zzbod {
    private zzbtv a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzcyg f12419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzcyo f12420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzbqy f12421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzcfp f12422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzbnc f12423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzbpx f12424g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzbqt f12425h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzbox f12426i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzcow f12427j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zzbxk f12428k;
    private final /* synthetic */ zzbkc l;

    private cc(zzbkc zzbkcVar) {
        this.l = zzbkcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final /* synthetic */ zzbod a(zzbtv zzbtvVar) {
        this.a = (zzbtv) zzdto.a(zzbtvVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final zzboc b() {
        zzdto.c(this.a, zzbtv.class);
        if (this.f12419b == null) {
            this.f12419b = new zzcyg();
        }
        if (this.f12420c == null) {
            this.f12420c = new zzcyo();
        }
        zzdto.c(this.f12421d, zzbqy.class);
        if (this.f12422e == null) {
            this.f12422e = new zzcfp();
        }
        zzdto.c(this.f12423f, zzbnc.class);
        if (this.f12424g == null) {
            this.f12424g = new zzbpx();
        }
        if (this.f12425h == null) {
            this.f12425h = new zzbqt();
        }
        zzdto.c(this.f12426i, zzbox.class);
        zzdto.c(this.f12427j, zzcow.class);
        zzdto.c(this.f12428k, zzbxk.class);
        return new dc(this.l, this.a, this.f12419b, this.f12420c, this.f12421d, this.f12422e, this.f12423f, this.f12424g, this.f12425h, this.f12426i, this.f12427j, this.f12428k);
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final /* synthetic */ zzbod c(zzbox zzboxVar) {
        this.f12426i = (zzbox) zzdto.a(zzboxVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final /* synthetic */ zzbod d(zzbnc zzbncVar) {
        this.f12423f = (zzbnc) zzdto.a(zzbncVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final /* synthetic */ zzbod e(zzcow zzcowVar) {
        this.f12427j = (zzcow) zzdto.a(zzcowVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final /* synthetic */ zzbod f(zzbqy zzbqyVar) {
        this.f12421d = (zzbqy) zzdto.a(zzbqyVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final /* synthetic */ zzbod g(zzbxk zzbxkVar) {
        this.f12428k = (zzbxk) zzdto.a(zzbxkVar);
        return this;
    }
}
