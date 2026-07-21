package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzix implements zzcz<zzja> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzix f17451f = new zzix();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzja> f17452g;

    private zzix(zzcz<zzja> zzczVar) {
        this.f17452g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzja) f17451f.a()).a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzja a() {
        return this.f17452g.a();
    }

    public zzix() {
        this(zzdc.b(new zziz()));
    }
}
