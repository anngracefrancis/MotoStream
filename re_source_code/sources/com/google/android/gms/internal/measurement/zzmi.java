package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmi implements zzcz<zzmh> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzmi f17548f = new zzmi();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzmh> f17549g;

    private zzmi(zzcz<zzmh> zzczVar) {
        this.f17549g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzmh) f17548f.a()).a();
    }

    public static boolean c() {
        return ((zzmh) f17548f.a()).b();
    }

    public static boolean d() {
        return ((zzmh) f17548f.a()).c();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzmh a() {
        return this.f17549g.a();
    }

    public zzmi() {
        this(zzdc.b(new zzmk()));
    }
}
