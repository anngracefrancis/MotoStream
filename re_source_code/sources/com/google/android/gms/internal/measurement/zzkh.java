package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkh implements zzcz<zzkk> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzkh f17493f = new zzkh();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzkk> f17494g;

    private zzkh(zzcz<zzkk> zzczVar) {
        this.f17494g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzkk) f17493f.a()).a();
    }

    public static boolean c() {
        return ((zzkk) f17493f.a()).b();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzkk a() {
        return this.f17494g.a();
    }

    public zzkh() {
        this(zzdc.b(new zzkj()));
    }
}
