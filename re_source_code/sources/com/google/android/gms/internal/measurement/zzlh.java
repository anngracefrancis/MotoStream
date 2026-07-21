package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlh implements zzli {
    private static final zzcl<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzcl<Boolean> f17517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final zzcl<Boolean> f17518c;

    static {
        zzcr zzcrVar = new zzcr(zzcm.a("com.google.android.gms.measurement"));
        a = zzcrVar.d("measurement.lifecycle.app_backgrounded_engagement", false);
        f17517b = zzcrVar.d("measurement.lifecycle.app_backgrounded_tracking", false);
        f17518c = zzcrVar.d("measurement.lifecycle.app_in_background_parameter", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzli
    public final boolean a() {
        return a.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzli
    public final boolean b() {
        return f17517b.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzli
    public final boolean c() {
        return f17518c.n().booleanValue();
    }
}
