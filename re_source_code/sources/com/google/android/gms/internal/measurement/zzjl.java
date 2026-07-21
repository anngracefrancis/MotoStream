package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjl implements zzjm {
    private static final zzcl<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzcl<Long> f17472b;

    static {
        zzcr zzcrVar = new zzcr(zzcm.a("com.google.android.gms.measurement"));
        a = zzcrVar.d("measurement.service.disable_install_state_reporting", false);
        f17472b = zzcrVar.b("measurement.id.service.disable_install_state_reporting", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final boolean b() {
        return a.n().booleanValue();
    }
}
