package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmu implements zzcz<zzmt> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzmu f17561f = new zzmu();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzmt> f17562g;

    private zzmu(zzcz<zzmt> zzczVar) {
        this.f17562g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzmt) f17561f.a()).a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzmt a() {
        return this.f17562g.a();
    }

    public zzmu() {
        this(zzdc.b(new zzmw()));
    }
}
