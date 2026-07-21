package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmo implements zzcz<zzmn> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzmo f17557f = new zzmo();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzmn> f17558g;

    private zzmo(zzcz<zzmn> zzczVar) {
        this.f17558g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzmn) f17557f.a()).a();
    }

    public static boolean c() {
        return ((zzmn) f17557f.a()).b();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzmn a() {
        return this.f17558g.a();
    }

    public zzmo() {
        this(zzdc.b(new zzmq()));
    }
}
