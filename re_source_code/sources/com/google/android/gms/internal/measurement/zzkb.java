package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkb implements zzcz<zzke> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzkb f17489f = new zzkb();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzke> f17490g;

    private zzkb(zzcz<zzke> zzczVar) {
        this.f17490g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzke) f17489f.a()).a();
    }

    public static boolean c() {
        return ((zzke) f17489f.a()).b();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzke a() {
        return this.f17490g.a();
    }

    public zzkb() {
        this(zzdc.b(new zzkd()));
    }
}
