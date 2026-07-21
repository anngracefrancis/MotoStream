package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zziz implements zzja {
    private static final zzcl<Boolean> a = new zzcr(zzcm.a("com.google.android.gms.measurement")).d("measurement.module.collection.conditionally_omit_admob_app_id", true);

    @Override // com.google.android.gms.internal.measurement.zzja
    public final boolean a() {
        return a.n().booleanValue();
    }
}
