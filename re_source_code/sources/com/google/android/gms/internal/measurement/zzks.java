package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzks implements zzcz<zzkr> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzks f17501f = new zzks();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzkr> f17502g;

    private zzks(zzcz<zzkr> zzczVar) {
        this.f17502g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzkr) f17501f.a()).a();
    }

    public static boolean c() {
        return ((zzkr) f17501f.a()).b();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzkr a() {
        return this.f17502g.a();
    }

    public zzks() {
        this(zzdc.b(new zzku()));
    }
}
