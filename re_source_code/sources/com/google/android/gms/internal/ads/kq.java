package com.google.android.gms.internal.ads;

/* JADX INFO: Add missing generic type declarations: [O] */
/* JADX INFO: loaded from: classes2.dex */
final class kq<O> implements zzban<O> {
    private final /* synthetic */ zzcze a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzczl f12894b;

    kq(zzczl zzczlVar, zzcze zzczeVar) {
        this.f12894b = zzczlVar;
        this.a = zzczeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        this.f12894b.f15803f.f15795d.F(this.a, th);
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void b(O o) {
        this.f12894b.f15803f.f15795d.B(this.a);
    }
}
