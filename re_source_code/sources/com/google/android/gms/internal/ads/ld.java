package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class ld implements zzban<zzbpc> {
    private final /* synthetic */ zzban a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzbpk f12933b;

    ld(zzbpk zzbpkVar, zzban zzbanVar) {
        this.f12933b = zzbpkVar;
        this.a = zzbanVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        this.a.a(th);
        this.f12933b.g();
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(zzbpc zzbpcVar) {
        this.a.b(zzbpcVar);
        this.f12933b.g();
    }
}
