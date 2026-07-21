package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzku implements zzkr {
    private static final zzcl<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzcl<Boolean> f17505b;

    static {
        zzcr zzcrVar = new zzcr(zzcm.a("com.google.android.gms.measurement"));
        a = zzcrVar.d("measurement.collection.efficient_engagement_reporting_enabled", false);
        f17505b = zzcrVar.d("measurement.collection.redundant_engagement_removal_enabled", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzkr
    public final boolean a() {
        return a.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzkr
    public final boolean b() {
        return f17505b.n().booleanValue();
    }
}
