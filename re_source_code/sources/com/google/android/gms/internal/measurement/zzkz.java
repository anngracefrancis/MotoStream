package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkz implements zzcz<zzlc> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzkz f17508f = new zzkz();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzlc> f17509g;

    private zzkz(zzcz<zzlc> zzczVar) {
        this.f17509g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzlc) f17508f.a()).a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzlc a() {
        return this.f17509g.a();
    }

    public zzkz() {
        this(zzdc.b(new zzlb()));
    }
}
