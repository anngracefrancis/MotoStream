package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlq implements zzcz<zzlp> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzlq f17524f = new zzlq();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzlp> f17525g;

    private zzlq(zzcz<zzlp> zzczVar) {
        this.f17525g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzlp) f17524f.a()).a();
    }

    public static double c() {
        return ((zzlp) f17524f.a()).b();
    }

    public static long d() {
        return ((zzlp) f17524f.a()).c();
    }

    public static long e() {
        return ((zzlp) f17524f.a()).d();
    }

    public static String f() {
        return ((zzlp) f17524f.a()).e();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzlp a() {
        return this.f17525g.a();
    }

    public zzlq() {
        this(zzdc.b(new zzls()));
    }
}
