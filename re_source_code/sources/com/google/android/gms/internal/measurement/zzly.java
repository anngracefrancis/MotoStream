package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzly implements zzlv {
    private static final zzcl<Boolean> a = new zzcr(zzcm.a("com.google.android.gms.measurement")).d("measurement.experiment.enable_experiment_reporting", true);

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final boolean a() {
        return a.n().booleanValue();
    }
}
