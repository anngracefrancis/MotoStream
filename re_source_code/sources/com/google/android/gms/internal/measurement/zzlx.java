package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlx implements zzcz<zzma> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzlx f17534f = new zzlx();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzma> f17535g;

    private zzlx(zzcz<zzma> zzczVar) {
        this.f17535g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzma) f17534f.a()).a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzma a() {
        return this.f17535g.a();
    }

    public zzlx() {
        this(zzdc.b(new zzlz()));
    }
}
