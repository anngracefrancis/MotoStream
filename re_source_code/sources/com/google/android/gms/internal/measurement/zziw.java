package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zziw implements zzcz<zziv> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zziw f17449f = new zziw();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zziv> f17450g;

    private zziw(zzcz<zziv> zzczVar) {
        this.f17450g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zziv) f17449f.a()).a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zziv a() {
        return this.f17450g.a();
    }

    public zziw() {
        this(zzdc.b(new zziy()));
    }
}
