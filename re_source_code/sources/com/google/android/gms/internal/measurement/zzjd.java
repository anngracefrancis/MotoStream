package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjd implements zzcz<zzjg> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzjd f17455f = new zzjd();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzjg> f17456g;

    private zzjd(zzcz<zzjg> zzczVar) {
        this.f17456g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzjg) f17455f.a()).a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzjg a() {
        return this.f17456g.a();
    }

    public zzjd() {
        this(zzdc.b(new zzjf()));
    }
}
