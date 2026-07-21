package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlm implements zzlj {
    private static final zzcl<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzcl<Boolean> f17523b;

    static {
        zzcr zzcrVar = new zzcr(zzcm.a("com.google.android.gms.measurement"));
        a = zzcrVar.d("measurement.personalized_ads_signals_collection_enabled", true);
        f17523b = zzcrVar.d("measurement.personalized_ads_property_translation_enabled", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final boolean a() {
        return a.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final boolean b() {
        return f17523b.n().booleanValue();
    }
}
