package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class xb implements zzbxp {
    private zzcyo a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzbqy f13571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzcfp f13572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzbpx f13573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzbqt f13574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzbtv f13575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzbxk f13576g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzcyg f13577h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzbkc f13578i;

    private xb(zzbkc zzbkcVar) {
        this.f13578i = zzbkcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbxp
    public final /* synthetic */ zzbxp a(zzbtv zzbtvVar) {
        this.f13575f = (zzbtv) zzdto.a(zzbtvVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbxp
    public final zzbxo b() {
        if (this.a == null) {
            this.a = new zzcyo();
        }
        zzdto.c(this.f13571b, zzbqy.class);
        if (this.f13572c == null) {
            this.f13572c = new zzcfp();
        }
        if (this.f13573d == null) {
            this.f13573d = new zzbpx();
        }
        if (this.f13574e == null) {
            this.f13574e = new zzbqt();
        }
        zzdto.c(this.f13575f, zzbtv.class);
        zzdto.c(this.f13576g, zzbxk.class);
        if (this.f13577h == null) {
            this.f13577h = new zzcyg();
        }
        return new yb(this.f13578i, this.a, this.f13571b, this.f13572c, this.f13573d, this.f13574e, this.f13575f, this.f13576g, this.f13577h);
    }

    @Override // com.google.android.gms.internal.ads.zzbxp
    public final /* synthetic */ zzbxp c(zzbqy zzbqyVar) {
        this.f13571b = (zzbqy) zzdto.a(zzbqyVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbxp
    public final /* synthetic */ zzbxp d(zzbxk zzbxkVar) {
        this.f13576g = (zzbxk) zzdto.a(zzbxkVar);
        return this;
    }
}
