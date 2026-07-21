package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzls implements zzlp {
    private static final zzcl<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzcl<Double> f17528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final zzcl<Long> f17529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzcl<Long> f17530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final zzcl<String> f17531e;

    static {
        zzcr zzcrVar = new zzcr(zzcm.a("com.google.android.gms.measurement"));
        a = zzcrVar.d("measurement.test.boolean_flag", false);
        f17528b = zzcrVar.a("measurement.test.double_flag", -3.0d);
        f17529c = zzcrVar.b("measurement.test.int_flag", -2L);
        f17530d = zzcrVar.b("measurement.test.long_flag", -1L);
        f17531e = zzcrVar.c("measurement.test.string_flag", "---");
    }

    @Override // com.google.android.gms.internal.measurement.zzlp
    public final boolean a() {
        return a.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlp
    public final double b() {
        return f17528b.n().doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlp
    public final long c() {
        return f17529c.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlp
    public final long d() {
        return f17530d.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlp
    public final String e() {
        return f17531e.n();
    }
}
