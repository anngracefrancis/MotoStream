package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbmd implements zzbro {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzcxo f14527f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcxu f14528g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzdae f14529h;

    public zzbmd(zzcxu zzcxuVar, zzdae zzdaeVar) {
        this.f14528g = zzcxuVar;
        this.f14529h = zzdaeVar;
        this.f14527f = zzcxuVar.f15747b.f15744b;
    }

    @Override // com.google.android.gms.internal.ads.zzbro
    public final void onAdFailedToLoad(int i2) {
        this.f14529h.a(this.f14528g, null, this.f14527f.a);
    }
}
