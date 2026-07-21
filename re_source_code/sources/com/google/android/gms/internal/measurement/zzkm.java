package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkm implements zzcz<zzkl> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzkm f17496f = new zzkm();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzkl> f17497g;

    private zzkm(zzcz<zzkl> zzczVar) {
        this.f17497g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzkl) f17496f.a()).a();
    }

    public static boolean c() {
        return ((zzkl) f17496f.a()).b();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzkl a() {
        return this.f17497g.a();
    }

    public zzkm() {
        this(zzdc.b(new zzko()));
    }
}
