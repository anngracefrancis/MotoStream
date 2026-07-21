package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlw implements zzcz<zzlv> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzlw f17532f = new zzlw();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzlv> f17533g;

    private zzlw(zzcz<zzlv> zzczVar) {
        this.f17533g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzlv) f17532f.a()).a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzlv a() {
        return this.f17533g.a();
    }

    public zzlw() {
        this(zzdc.b(new zzly()));
    }
}
