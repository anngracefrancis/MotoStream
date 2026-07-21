package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class kd implements zzban<zzbph> {
    private final /* synthetic */ zzban a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzbpk f12873b;

    kd(zzbpk zzbpkVar, zzban zzbanVar) {
        this.f12873b = zzbpkVar;
        this.a = zzbanVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        this.a.a(th);
        this.f12873b.g();
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(zzbph zzbphVar) {
        this.f12873b.f(zzbphVar.a, this.a);
    }
}
