package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class a2 implements zzbbv<zzajw> {
    final /* synthetic */ zzala a;

    a2(zzala zzalaVar) {
        this.a = zzalaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbv
    public final /* synthetic */ void a(zzajw zzajwVar) {
        final zzajw zzajwVar2 = zzajwVar;
        zzbbm.a.execute(new Runnable(this, zzajwVar2) { // from class: com.google.android.gms.internal.ads.b2

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final a2 f12298f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzajw f12299g;

            {
                this.f12298f = this;
                this.f12299g = zzajwVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a2 a2Var = this.f12298f;
                zzajw zzajwVar3 = this.f12299g;
                a2Var.a.f13947d.a(zzajwVar3);
                zzajwVar3.destroy();
            }
        });
    }
}
