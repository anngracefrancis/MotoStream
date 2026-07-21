package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmp implements zzcz<zzms> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzmp f17559f = new zzmp();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzms> f17560g;

    private zzmp(zzcz<zzms> zzczVar) {
        this.f17560g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzms) f17559f.a()).a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzms a() {
        return this.f17560g.a();
    }

    public zzmp() {
        this(zzdc.b(new zzmr()));
    }
}
