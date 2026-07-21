package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmj implements zzcz<zzmm> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzmj f17550f = new zzmj();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzmm> f17551g;

    private zzmj(zzcz<zzmm> zzczVar) {
        this.f17551g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzmm) f17550f.a()).a();
    }

    public static boolean c() {
        return ((zzmm) f17550f.a()).b();
    }

    public static boolean d() {
        return ((zzmm) f17550f.a()).c();
    }

    public static boolean e() {
        return ((zzmm) f17550f.a()).d();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzmm a() {
        return this.f17551g.a();
    }

    public zzmj() {
        this(zzdc.b(new zzml()));
    }
}
