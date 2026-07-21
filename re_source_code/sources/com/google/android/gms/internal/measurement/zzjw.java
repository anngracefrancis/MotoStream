package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjw implements zzjt {
    private static final zzcl<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzcl<Long> f17481b;

    static {
        zzcr zzcrVar = new zzcr(zzcm.a("com.google.android.gms.measurement"));
        a = zzcrVar.d("measurement.upload_dsid_enabled", false);
        f17481b = zzcrVar.b("measurement.id.upload_dsid_enabled", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzjt
    public final boolean a() {
        return a.n().booleanValue();
    }
}
