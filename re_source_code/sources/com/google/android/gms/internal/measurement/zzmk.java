package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmk implements zzmh {
    private static final zzcl<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzcl<Boolean> f17552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final zzcl<Boolean> f17553c;

    static {
        zzcr zzcrVar = new zzcr(zzcm.a("com.google.android.gms.measurement"));
        a = zzcrVar.d("measurement.service.sessions.remove_disabled_session_number", true);
        f17552b = zzcrVar.d("measurement.service.sessions.session_number_enabled", true);
        f17553c = zzcrVar.d("measurement.service.sessions.session_number_backfill_enabled", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzmh
    public final boolean a() {
        return a.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmh
    public final boolean b() {
        return f17552b.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmh
    public final boolean c() {
        return f17553c.n().booleanValue();
    }
}
