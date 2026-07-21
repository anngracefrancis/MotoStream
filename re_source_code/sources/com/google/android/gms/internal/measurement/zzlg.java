package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlg implements zzld {
    private static final zzcl<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzcl<Boolean> f17514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final zzcl<Boolean> f17515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzcl<Boolean> f17516d;

    static {
        zzcr zzcrVar = new zzcr(zzcm.a("com.google.android.gms.measurement"));
        a = zzcrVar.d("measurement.sdk.collection.last_deep_link_referrer", false);
        f17514b = zzcrVar.d("measurement.sdk.collection.last_deep_link_referrer_campaign", false);
        f17515c = zzcrVar.d("measurement.sdk.collection.last_gclid_from_referrer", false);
        f17516d = zzcrVar.d("measurement.sdk.collection.worker_thread_referrer", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public final boolean b() {
        return a.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public final boolean c() {
        return f17514b.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public final boolean d() {
        return f17515c.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public final boolean e() {
        return f17516d.n().booleanValue();
    }
}
