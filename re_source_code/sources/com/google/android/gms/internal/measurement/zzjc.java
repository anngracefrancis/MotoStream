package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjc implements zzcz<zzjb> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzjc f17453f = new zzjc();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzjb> f17454g;

    private zzjc(zzcz<zzjb> zzczVar) {
        this.f17454g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzjb) f17453f.a()).a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzjb a() {
        return this.f17454g.a();
    }

    public zzjc() {
        this(zzdc.b(new zzje()));
    }
}
