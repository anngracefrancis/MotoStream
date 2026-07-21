package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzir implements zzcz<zziu> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzir f17447f = new zzir();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zziu> f17448g;

    private zzir(zzcz<zziu> zzczVar) {
        this.f17448g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zziu) f17447f.a()).a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zziu a() {
        return this.f17448g.a();
    }

    public zzir() {
        this(zzdc.b(new zzit()));
    }
}
