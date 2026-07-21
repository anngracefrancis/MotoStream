package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmf implements zzmg {
    private static final zzcl<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzcl<Boolean> f17540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final zzcl<Boolean> f17541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzcl<Boolean> f17542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final zzcl<Boolean> f17543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final zzcl<Boolean> f17544f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final zzcl<Long> f17545g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final zzcl<Boolean> f17546h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final zzcl<Boolean> f17547i;

    static {
        zzcr zzcrVar = new zzcr(zzcm.a("com.google.android.gms.measurement"));
        a = zzcrVar.d("measurement.service.audience.scoped_filters_v27", false);
        f17540b = zzcrVar.d("measurement.service.audience.session_scoped_user_engagement", false);
        f17541c = zzcrVar.d("measurement.client.audience.scoped_engagement_removal_when_session_expired", true);
        f17542d = zzcrVar.d("measurement.service.audience.scoped_engagement_removal_when_session_expired", true);
        f17543e = zzcrVar.d("measurement.service.audience.session_scoped_event_aggregates", false);
        f17544f = zzcrVar.d("measurement.service.audience.use_bundle_timestamp_for_property_filters", false);
        f17545g = zzcrVar.b("measurement.id.scoped_audience_filters", 0L);
        f17546h = zzcrVar.d("measurement.service.audience.not_prepend_timestamps_for_sequence_session_scoped_filters", false);
        f17547i = zzcrVar.d("measurement.service.audience.remove_disabled_session_scoped_user_engagement", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final boolean b() {
        return a.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final boolean c() {
        return f17540b.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final boolean d() {
        return f17541c.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final boolean e() {
        return f17542d.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final boolean l() {
        return f17547i.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final boolean m() {
        return f17546h.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final boolean q() {
        return f17543e.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final boolean s() {
        return f17544f.n().booleanValue();
    }
}
