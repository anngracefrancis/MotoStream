package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmq implements zzmn {
    private static final zzcl<Boolean> a = new zzcr(zzcm.a("com.google.android.gms.measurement")).d("measurement.integration.disable_firebase_instance_id", false);

    @Override // com.google.android.gms.internal.measurement.zzmn
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzmn
    public final boolean b() {
        return a.n().booleanValue();
    }
}
