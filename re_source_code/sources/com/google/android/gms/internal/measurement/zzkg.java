package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkg implements zzcz<zzkf> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzkg f17491f = new zzkg();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzkf> f17492g;

    private zzkg(zzcz<zzkf> zzczVar) {
        this.f17492g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzkf) f17491f.a()).a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzkf a() {
        return this.f17492g.a();
    }

    public zzkg() {
        this(zzdc.b(new zzki()));
    }
}
