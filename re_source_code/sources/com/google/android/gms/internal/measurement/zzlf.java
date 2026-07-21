package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlf implements zzcz<zzli> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzlf f17512f = new zzlf();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzli> f17513g;

    private zzlf(zzcz<zzli> zzczVar) {
        this.f17513g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzli) f17512f.a()).a();
    }

    public static boolean c() {
        return ((zzli) f17512f.a()).b();
    }

    public static boolean d() {
        return ((zzli) f17512f.a()).c();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzli a() {
        return this.f17513g.a();
    }

    public zzlf() {
        this(zzdc.b(new zzlh()));
    }
}
