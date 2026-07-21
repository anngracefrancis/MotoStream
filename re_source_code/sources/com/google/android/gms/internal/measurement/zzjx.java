package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjx implements zzjy {
    private static final zzcl<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzcl<Boolean> f17482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final zzcl<Boolean> f17483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzcl<Long> f17484d;

    static {
        zzcr zzcrVar = new zzcr(zzcm.a("com.google.android.gms.measurement"));
        a = zzcrVar.d("measurement.sdk.dynamite.allow_remote_dynamite", false);
        f17482b = zzcrVar.d("measurement.collection.init_params_control_enabled", true);
        f17483c = zzcrVar.d("measurement.sdk.dynamite.use_dynamite2", false);
        f17484d = zzcrVar.b("measurement.id.sdk.dynamite.use_dynamite", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final boolean a() {
        return a.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final boolean b() {
        return f17482b.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final boolean c() {
        return f17483c.n().booleanValue();
    }
}
