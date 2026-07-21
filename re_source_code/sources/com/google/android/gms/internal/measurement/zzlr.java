package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlr implements zzcz<zzlu> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzlr f17526f = new zzlr();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzlu> f17527g;

    private zzlr(zzcz<zzlu> zzczVar) {
        this.f17527g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzlu) f17526f.a()).a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzlu a() {
        return this.f17527g.a();
    }

    public zzlr() {
        this(zzdc.b(new zzlt()));
    }
}
