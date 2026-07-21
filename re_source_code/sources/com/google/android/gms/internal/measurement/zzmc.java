package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmc implements zzcz<zzmb> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzmc f17536f = new zzmc();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzmb> f17537g;

    private zzmc(zzcz<zzmb> zzczVar) {
        this.f17537g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzmb) f17536f.a()).a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzmb a() {
        return this.f17537g.a();
    }

    public zzmc() {
        this(zzdc.b(new zzme()));
    }
}
