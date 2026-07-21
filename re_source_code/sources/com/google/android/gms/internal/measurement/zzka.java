package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzka implements zzcz<zzjz> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzka f17487f = new zzka();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzjz> f17488g;

    private zzka(zzcz<zzjz> zzczVar) {
        this.f17488g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzjz) f17487f.a()).a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzjz a() {
        return this.f17488g.a();
    }

    public zzka() {
        this(zzdc.b(new zzkc()));
    }
}
