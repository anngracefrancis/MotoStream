package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzju implements zzcz<zzjt> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzju f17477f = new zzju();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzjt> f17478g;

    private zzju(zzcz<zzjt> zzczVar) {
        this.f17478g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzjt) f17477f.a()).a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzjt a() {
        return this.f17478g.a();
    }

    public zzju() {
        this(zzdc.b(new zzjw()));
    }
}
