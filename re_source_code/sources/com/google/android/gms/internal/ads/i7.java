package com.google.android.gms.internal.ads;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes2.dex */
final class i7<T> implements zzban<T> {
    private final /* synthetic */ zzbbw a;

    i7(zzbbw zzbbwVar) {
        this.a = zzbbwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        this.a.f14340b.set(-1);
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void b(T t) {
        this.a.f14340b.set(1);
    }
}
