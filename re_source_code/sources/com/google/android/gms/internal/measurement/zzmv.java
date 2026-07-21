package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmv implements zzcz<zzmy> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzmv f17563f = new zzmv();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzmy> f17564g;

    private zzmv(zzcz<zzmy> zzczVar) {
        this.f17564g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzmy) f17563f.a()).a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzmy a() {
        return this.f17564g.a();
    }

    public zzmv() {
        this(zzdc.b(new zzmx()));
    }
}
