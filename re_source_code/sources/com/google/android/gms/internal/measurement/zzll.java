package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzll implements zzcz<zzlo> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzll f17521f = new zzll();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzlo> f17522g;

    private zzll(zzcz<zzlo> zzczVar) {
        this.f17522g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzlo) f17521f.a()).a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzlo a() {
        return this.f17522g.a();
    }

    public zzll() {
        this(zzdc.b(new zzln()));
    }
}
