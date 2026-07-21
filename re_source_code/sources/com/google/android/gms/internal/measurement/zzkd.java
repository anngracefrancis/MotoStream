package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkd implements zzke {
    private static final zzcl<Boolean> a = new zzcr(zzcm.a("com.google.android.gms.measurement")).d("measurement.client.firebase_feature_rollout.v1.enable", true);

    @Override // com.google.android.gms.internal.measurement.zzke
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    public final boolean b() {
        return a.n().booleanValue();
    }
}
