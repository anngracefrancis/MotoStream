package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class a4 implements zzban<Void> {
    private final /* synthetic */ zzbbh a;

    a4(zzauq zzauqVar, zzbbh zzbbhVar) {
        this.a = zzbbhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        zzauq.a.remove(this.a);
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(Void r2) {
        zzauq.a.remove(this.a);
    }
}
