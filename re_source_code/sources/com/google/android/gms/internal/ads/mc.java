package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class mc implements zzcqp {
    private zzcyo a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzbqy f12978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzcqt f12979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzcfp f12980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzbkc f12981e;

    private mc(zzbkc zzbkcVar) {
        this.f12981e = zzbkcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcqp
    public final zzcqo a() {
        if (this.a == null) {
            this.a = new zzcyo();
        }
        zzdto.c(this.f12978b, zzbqy.class);
        zzdto.c(this.f12979c, zzcqt.class);
        if (this.f12980d == null) {
            this.f12980d = new zzcfp();
        }
        return new nc(this.f12981e, this.a, this.f12978b, this.f12979c, this.f12980d);
    }

    @Override // com.google.android.gms.internal.ads.zzcqp
    public final /* synthetic */ zzcqp b(zzbqy zzbqyVar) {
        this.f12978b = (zzbqy) zzdto.a(zzbqyVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcqp
    public final /* synthetic */ zzcqp c(zzcqt zzcqtVar) {
        this.f12979c = (zzcqt) zzdto.a(zzcqtVar);
        return this;
    }
}
