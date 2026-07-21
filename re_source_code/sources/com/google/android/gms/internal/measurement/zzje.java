package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzje implements zzjb {
    private static final zzcl<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzcl<Long> f17457b;

    static {
        zzcr zzcrVar = new zzcr(zzcm.a("com.google.android.gms.measurement"));
        a = zzcrVar.d("measurement.app_launch.event_ordering_fix", false);
        f17457b = zzcrVar.b("measurement.id.app_launch.event_ordering_fix", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzjb
    public final boolean a() {
        return a.n().booleanValue();
    }
}
