package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkn implements zzcz<zzkq> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzkn f17498f = new zzkn();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzkq> f17499g;

    private zzkn(zzcz<zzkq> zzczVar) {
        this.f17499g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzkq) f17498f.a()).a();
    }

    public static boolean c() {
        return ((zzkq) f17498f.a()).b();
    }

    public static boolean d() {
        return ((zzkq) f17498f.a()).c();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzkq a() {
        return this.f17499g.a();
    }

    public zzkn() {
        this(zzdc.b(new zzkp()));
    }
}
