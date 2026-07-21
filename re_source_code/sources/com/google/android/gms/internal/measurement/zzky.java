package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzky implements zzcz<zzkx> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzky f17506f = new zzky();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzkx> f17507g;

    private zzky(zzcz<zzkx> zzczVar) {
        this.f17507g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzkx) f17506f.a()).a();
    }

    public static boolean c() {
        return ((zzkx) f17506f.a()).b();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzkx a() {
        return this.f17507g.a();
    }

    public zzky() {
        this(zzdc.b(new zzla()));
    }
}
