package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzml implements zzmm {
    private static final zzcl<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzcl<Boolean> f17554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final zzcl<Boolean> f17555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzcl<Boolean> f17556d;

    static {
        zzcr zzcrVar = new zzcr(zzcm.a("com.google.android.gms.measurement"));
        a = zzcrVar.d("measurement.client.sessions.background_sessions_enabled", true);
        f17554b = zzcrVar.d("measurement.client.sessions.immediate_start_enabled_foreground", true);
        f17555c = zzcrVar.d("measurement.client.sessions.remove_expired_session_properties_enabled", true);
        f17556d = zzcrVar.d("measurement.client.sessions.session_id_enabled", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzmm
    public final boolean a() {
        return a.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmm
    public final boolean b() {
        return f17554b.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmm
    public final boolean c() {
        return f17555c.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmm
    public final boolean d() {
        return f17556d.n().booleanValue();
    }
}
