package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjj implements zzcz<zzjm> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzjj f17460f = new zzjj();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzjm> f17461g;

    private zzjj(zzcz<zzjm> zzczVar) {
        this.f17461g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzjm) f17460f.a()).a();
    }

    public static boolean c() {
        return ((zzjm) f17460f.a()).b();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzjm a() {
        return this.f17461g.a();
    }

    public zzjj() {
        this(zzdc.b(new zzjl()));
    }
}
