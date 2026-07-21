package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjo implements zzcz<zzjn> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzjo f17473f = new zzjo();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzjn> f17474g;

    private zzjo(zzcz<zzjn> zzczVar) {
        this.f17474g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzjn) f17473f.a()).a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzjn a() {
        return this.f17474g.a();
    }

    public zzjo() {
        this(zzdc.b(new zzjq()));
    }
}
