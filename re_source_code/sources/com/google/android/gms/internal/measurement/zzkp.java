package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkp implements zzkq {
    private static final zzcl<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzcl<Boolean> f17500b;

    static {
        zzcr zzcrVar = new zzcr(zzcm.a("com.google.android.gms.measurement"));
        a = zzcrVar.d("measurement.client.sessions.check_on_startup", true);
        f17500b = zzcrVar.d("measurement.client.sessions.start_session_before_view_screen", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzkq
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzkq
    public final boolean b() {
        return a.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzkq
    public final boolean c() {
        return f17500b.n().booleanValue();
    }
}
