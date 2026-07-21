package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkt implements zzcz<zzkw> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzkt f17503f = new zzkt();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzkw> f17504g;

    private zzkt(zzcz<zzkw> zzczVar) {
        this.f17504g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzkw) f17503f.a()).a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzkw a() {
        return this.f17504g.a();
    }

    public zzkt() {
        this(zzdc.b(new zzkv()));
    }
}
