package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjv implements zzcz<zzjy> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzjv f17479f = new zzjv();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzjy> f17480g;

    private zzjv(zzcz<zzjy> zzczVar) {
        this.f17480g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzjy) f17479f.a()).a();
    }

    public static boolean c() {
        return ((zzjy) f17479f.a()).b();
    }

    public static boolean d() {
        return ((zzjy) f17479f.a()).c();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzjy a() {
        return this.f17480g.a();
    }

    public zzjv() {
        this(zzdc.b(new zzjx()));
    }
}
